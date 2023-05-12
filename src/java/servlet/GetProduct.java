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
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chong
 */
public class GetProduct extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = null;
        List<Product> productList = null;
        Product product = null;

        try {
            action = "";
            action = request.getParameter("action");

            if (action.equals("getAllProduct")) {
                productList = getAllProduct(request, response, session);
                session.setAttribute("productList", productList);

                response.sendRedirect("Staff/Product_Tables.jsp");
                return;

            } else if (action.equals("edit") || action.equals("delete")) {
                product = getProduct(request, response, session);

                session.setAttribute("productAction", action);
                session.setAttribute("productModify", product);

                response.sendRedirect("Staff/ProductEditDelete.jsp");
                return;

            } else if (action.equals("getAllProductCustomer")) {
                productList = getAllProductCustomer(request, response, session);
                session.setAttribute("productList", productList);

                response.sendRedirect("Customer/shop.jsp");
                return;

            } else if (action.equals("getAllProductGuest")) {
                productList = getAllProductCustomer(request, response, session);
                session.setAttribute("productList", productList);

                response.sendRedirect("Public/shop.jsp");
                return;

            } else if (action.equals("view")) {

                product = getProduct(request, response, session);

                session.setAttribute("productAction", action);
                session.setAttribute("productModify", product);

                response.sendRedirect("Public/ProductDetail.jsp");

            } else if (action.equals("viewCustomer")) {

                product = getProduct(request, response, session);

                session.setAttribute("productAction", action);
                session.setAttribute("productModify", product);

                response.sendRedirect("Customer/ProductDetail.jsp");

            } else if (action.equals("cart")) {
                productList = getAllProductCart(request, response, session);
                session.setAttribute("productListCart", productList);

                response.sendRedirect("Customer/cart.jsp");
            }

        } catch (Exception e) {

        }// end catch
    }

    public List<Product> getAllProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        List<Product> productList = null;
        String imagePath = null;
        try {
            Query query = em.createNamedQuery("Product.findAll");
            productList = query.getResultList();
            query = em.createNamedQuery("Inventory.findAll");
            List<Inventory> inventoryList = query.getResultList();

            for (Product product : productList) {
                for (Inventory inventory : inventoryList) {
                    if (product.getProductId() == inventory.getProductId().getProductId())
                        product.setQuantity(inventory.getQuantity());
                }
            }

            //get image
            for (Product product : productList) {
                byte[] blob = product.getImage();
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] imageData = baos.toByteArray();
                String encodedImage = Base64.getEncoder().encodeToString(imageData);
                imagePath = "data:image/png;base64," + encodedImage;
                product.setImgPath(imagePath);

            }
        } catch (IOException iOException) {
        }

        return productList;
    }

    public List<Product> getAllProductCustomer(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        List<Product> productList = null;
        List<Product> productListResult = new ArrayList<>();

        String imagePath = null;
        try {
            Query query = em.createNamedQuery("Product.findAll");
            productList = query.getResultList();
            query = em.createNamedQuery("Inventory.findAll");
            List<Inventory> inventoryList = query.getResultList();

            for (Product product : productList) {
                if (!product.getStatus().equals("Hidden"))
                    productListResult.add(product);
            }

            for (Product product : productListResult) {
                for (Inventory inventory : inventoryList) {
                    if (product.getProductId() == inventory.getProductId().getProductId())
                        product.setQuantity(inventory.getQuantity());
                }
            }

            //get image
            for (Product product : productListResult) {
                byte[] blob = product.getImage();
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] imageData = baos.toByteArray();
                String encodedImage = Base64.getEncoder().encodeToString(imageData);
                imagePath = "data:image/png;base64," + encodedImage;
                product.setImgPath(imagePath);

            }
        } catch (IOException iOException) {
        }

        return productListResult;
    }

    public List<Product> getAllProductCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

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
                for (CartProduct cp: cpList) {
                    if (product.getProductId() == cp.getCartId())
                        product.setQuantity(cp.getQuantity());
                }
            }

        return customerCart;

    }

    public Product getProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        Query query = null;
        Product productEdit = null;
        String productIdStr = request.getParameter("pid");
        String imagePath = null;
        int productId = Integer.parseInt(productIdStr);

        try {
            query = em.createNamedQuery("Product.findByProductId");
            query.setParameter("productId", productId);
            productEdit = (Product) query.getSingleResult();
            productEdit = getQty(request, response, session, productEdit);

            //get image
            byte[] blob = productEdit.getImage();
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] imageData = baos.toByteArray();
            String encodedImage = Base64.getEncoder().encodeToString(imageData);
            imagePath = "data:image/png;base64," + encodedImage;
            productEdit.setImgPath(imagePath);

        } catch (Exception e) {
            //product dont found
        }

        return productEdit;

    }

    public Product getQty(HttpServletRequest request, HttpServletResponse response, HttpSession session, Product productEdit) {
        try {
            Query query = em.createNamedQuery("Inventory.findAll");
            List<Inventory> inventoryList = query.getResultList();
            for (Inventory inventory : inventoryList) {
                if (inventory.getProductId().getProductId() == productEdit.getProductId())
                    productEdit.setQuantity(inventory.getQuantity());
            }

        } catch (Exception e) {
            //product dont found
        }

        return productEdit;
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
