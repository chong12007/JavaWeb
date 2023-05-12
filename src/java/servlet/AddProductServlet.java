/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Inventory;
import entity.Product;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author chong
 */
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String getUser = (String) session.getAttribute("user");
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
        Date createdDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date updatedDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        String productName = request.getParameter("productName");
        String productPriceStr = request.getParameter("price");
        Double productPrice = Double.parseDouble(productPriceStr);
        String productCategory = request.getParameter("productType");
        String quantityStr = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantityStr);
        String productDesc = request.getParameter("product_description");
        String status = request.getParameter("status");
        Part file = request.getPart("image");

        byte[] imageData = null;
        boolean uploadImage = false;

        InputStream inputStream = file.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);

        imageData = baos.toByteArray();
        uploadImage = true;

        Query query = em.createNamedQuery("Product.findAll");
        List<Product> productList = query.getResultList();
        int productId = 0;
        for (Product p : productList) {
            productId = p.getProductId();
        }

        //If no product exist in db
        if (productId == 0)
            productId = 1;

        boolean continueLoop = true;

        while (continueLoop) {
            // check if the ID exists in the database
            if (em.find(Product.class, productId) == null) {
                // ID does not exist, break out of the loop
                continueLoop = false;
                break;
            }

            // ID exists, increment and try again
            productId += 1;
        }

        Product addProduct = new Product(
                productId,
                productName,
                productPrice,
                productDesc,
                productCategory,
                status,
                imageData,
                getUser,
                createdDate
        );

        if (quantity == 0)
            addProduct.setStatus("Out Of Stock");

        try {
            utx.begin();
            em.persist(addProduct);
            utx.commit();

            addQuantity(request, response, session, addProduct, quantity);
        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        } finally {
            response.sendRedirect("GetProduct?action=getAllProduct");
            return;
        }
    }

    public void addQuantity(HttpServletRequest request, HttpServletResponse response, HttpSession session, Product product, int quantity)
            throws IOException {
        Query query = em.createNamedQuery("Inventory.findAll");
        List<Inventory> inventoryList = query.getResultList();

        int inventoryId = 0;

        for (Inventory inventory : inventoryList) {
            inventoryId = inventory.getInventoryId();

        }

        if (inventoryId == 0)
            inventoryId = 1;

        boolean continueLoop = true;

        while (continueLoop) {
            // check if the ID exists in the database
            if (em.find(Inventory.class, inventoryId) == null) {
                // ID does not exist, break out of the loop
                continueLoop = false;
                break;
            }

            // ID exists, increment and try again
            inventoryId += 1;
        }

        try {
            utx.begin();
            Inventory i = new Inventory(inventoryId, quantity, product);
            em.persist(i);
            utx.commit();

        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        }

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
