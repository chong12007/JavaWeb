/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Payment;
import entity.Product;
import entity.Purchase;
import entity.PurchaseHistory;
import entity.PurchaseHistoryProduct;
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
public class GetMyPurchaseReceive extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

//        String action = request.getParameter("action");
        int cartId = (int) session.getAttribute("cartId");
        int custId = (int) session.getAttribute("customerId");

        Query query = em.createNamedQuery("Purchase.findAll");
        List<Purchase> pList = query.getResultList();
        List<Purchase> customerPurchaseList = new ArrayList<>();

        for (Purchase p : pList) {
            if (p.getCustomerId() == custId)
                customerPurchaseList.add(p);
        }

        query = em.createNamedQuery("Payment.findAll");
        List<Payment> paymentList = query.getResultList();
        List<Payment> customerPaymentList = new ArrayList<>();

        for (Payment p : paymentList) {
            for (Purchase purchase : customerPurchaseList) {
                if (purchase.getPurchaseId() == p.getPurchaseId())
                    customerPaymentList.add(p);
            }
        }

        query = em.createNamedQuery("PurchaseHistoryProduct.findAll");
        List<PurchaseHistoryProduct> phpList = query.getResultList();
        List<PurchaseHistoryProduct> customerPhpList = new ArrayList<>();

        for (PurchaseHistoryProduct php : phpList) {
            for (Purchase p : customerPurchaseList) {
                if (p.getPurchaseId() == php.getPurchaseId()) {
                    php.setStatus(p.getStatus());
                    customerPhpList.add(php);
                }
            }
        }

        query = em.createNamedQuery("PurchaseHistory.findAll");
        List<PurchaseHistory> phList = query.getResultList();
        List<PurchaseHistory> customerPurchaseHistoryList = new ArrayList<>();

        for (PurchaseHistory ph : phList) {
            for (PurchaseHistoryProduct php : customerPhpList) {
                if (php.getPurchaseHistoryId() == ph.getPurchaseHistoryId())
                    if (php.getStatus().contains("deliver")) {
                        ph.setStatus(php.getStatus());
                        customerPurchaseHistoryList.add(ph);
                        break;
                    }

            }
        }

        query = em.createNamedQuery("Product.findAll");
        List<Product> productList = query.getResultList();
        List<Product> customerProductList = query.getResultList();

        String imagePath = null;
        for (PurchaseHistory ph : customerPurchaseHistoryList) {
            for (Product product : productList) {
                if (product.getProductId() == ph.getProductId()) {
                    ph.setImage(product.getImage());
                    byte[] blob = ph.getImage();
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(image, "png", baos);
                    byte[] imageData = baos.toByteArray();
                    String encodedImage = Base64.getEncoder().encodeToString(imageData);
                    imagePath = "data:image/png;base64," + encodedImage;
                    ph.setImgPath(imagePath);
                    break;
                }
            }
        }

//         session.setAttribute("customerProductList", customerProductList);
        session.setAttribute("customerPurchaseHistory", customerPurchaseHistoryList);
        session.setAttribute("customerPaymentList", customerPaymentList);

        response.sendRedirect("Customer/Customer_Purchased_ToReceive.jsp");

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
