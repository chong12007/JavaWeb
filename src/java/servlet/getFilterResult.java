/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

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
public class getFilterResult extends HttpServlet {

      @PersistenceContext
    EntityManager em;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         HttpSession session = request.getSession();
    
    
    String priceStr =request.getParameter("price");
    double price = Double.parseDouble(priceStr);
    
         List<Product> results = new ArrayList<>();
         
         
        
        List<Product> productList = getAllProductCustomer(request, response, session, price);
        
         for (Product productAll : productList) {
                if (productAll.getPrice() <= price)
                    results.add(productAll);
            }

            session.setAttribute("productSearchResults", results);
            response.sendRedirect("Public/Product_Search_Result.jsp");
        
        
    }
 public List<Product> getAllProductCustomer(HttpServletRequest request, HttpServletResponse response, HttpSession session,double price ) {

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
