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
import java.util.Collection;
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
public class EditProductServlet extends HttpServlet {

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

        String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);
        Part file = null;
        byte[] imageData = null;
        boolean uploadImage = false;

        file = request.getPart("image");
        // process the uploaded file
        InputStream inputStream = file.getInputStream();
        BufferedImage image = ImageIO.read(inputStream);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (image != null) {
            ImageIO.write(image, "png", baos);

            imageData = baos.toByteArray();
            uploadImage = true;
        }

        Product p = em.find(Product.class, productId);

        try {
            utx.begin();
            p.setName(productName);
            p.setPrice(productPrice);
            p.setDescription(productDesc);
            p.setCategory(productCategory);
            if (quantity == 0)
                p.setStatus("Out Of Stock");
            else
                p.setStatus(status);
            if (uploadImage)
                p.setImage(imageData);
            p.setUpdatedby(getUser);
            p.setUpdatedtime(updatedDate);

            em.merge(p);
            utx.commit();

            editQuantity(request, response, session,
                    productId, quantity);
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

    public void editQuantity(HttpServletRequest request, HttpServletResponse response, HttpSession session, int productID, int quantity) {

        Query query = em.createNamedQuery("Inventory.findAll");
        List<Inventory> inventoryList = query.getResultList();
        for (Inventory inventory : inventoryList) {
            if (inventory.getProductId().getProductId() == productID) {
                inventory.setQuantity(quantity);
                try {
                    utx.begin();
                    em.merge(inventory);
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
