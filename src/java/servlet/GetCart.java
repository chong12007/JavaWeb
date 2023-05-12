/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Cart;
import entity.CartProduct;
import entity.Inventory;
import entity.Product;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author chong
 */
public class GetCart extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        int cartId = (int) session.getAttribute("cartId");

        Query query = em.createNamedQuery("Product.findAll");
        List<Product> productList = query.getResultList();

        query = em.createNamedQuery("CartProduct.findAll");
        List<CartProduct> cpList = query.getResultList();

        query = em.createNamedQuery("Cart.findByCartId");
        query.setParameter("cartId", cartId);
        Cart c = (Cart) query.getSingleResult();

        query = em.createNamedQuery("Inventory.findAll");
        List<Inventory> inventoryList = query.getResultList();

        List<Integer> customeCartList = new ArrayList<>();
        for (CartProduct cp : cpList) {
            if (cp.getCartId() == cartId)
                customeCartList.add(cp.getProductId());
        }

        byte[] blob = null;
        String imagePath = null;

        List<Product> customerCart = new ArrayList<>();

        for (Product product : productList) {
            int productId = product.getProductId();
            if (customeCartList.contains(productId)) {
                blob = product.getImage();
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] imageData = baos.toByteArray();
                String encodedImage = Base64.getEncoder().encodeToString(imageData);
                imagePath = "data:image/png;base64," + encodedImage;
                product.setImgPath(imagePath);
                customerCart.add(product);
            }

        }

        for (Product product : customerCart) {
            for (CartProduct cp : cpList) {
                if (product.getProductId() == cp.getProductId())
                {
                    product.setQuantity(cp.getQuantity());
                    product.setCartProductId(cp.getId());
                }
                    
            }
        }

        session.setAttribute("productListCart",  customerCart);

        response.sendRedirect("Customer/cart.jsp");

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
