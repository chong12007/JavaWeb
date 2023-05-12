/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Customer;
import entity.Inventory;
//import entity.Payment;
import entity.Product;
import entity.ProductReview;
import entity.Purchase;
//import entity.PurchaseHistory;
import entity.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class StaffDashboard extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

//        Query query = em.createNamedQuery("Payment.findAll");
//        List<Payment> paymentList = query.getResultList();
        Query query = em.createNamedQuery("Product.findAll");
        List<Product> productList = query.getResultList();
        query = em.createNamedQuery("Inventory.findAll");
        List<Inventory> inventoryList = query.getResultList();
        query = em.createNamedQuery("ProductReview.findAll");
        List<ProductReview> productReviewList = query.getResultList();
        query = em.createNamedQuery("PurchaseHistory.findAll");
//        List<PurchaseHistory> purchaseHistoryList = query.getResultList();
//        query = em.createNamedQuery("Staff.findAll");
        List<Staff> staffList = query.getResultList();
        query = em.createNamedQuery("Purchase.findAll");
        List<Purchase> purchaseList = query.getResultList();
         query = em.createNamedQuery("Customer.findAll");
        List<Customer> customerList = query.getResultList();

//        session.setAttribute("paymentList", paymentList);
        session.setAttribute("productList", productList);
        session.setAttribute("inventoryList", inventoryList);
        session.setAttribute("productReviewList", productReviewList);
//        session.setAttribute("purchaseHistoryList", purchaseHistoryList);
        session.setAttribute("staffList", staffList);
        session.setAttribute("purchaseList", purchaseList);
           session.setAttribute("customerList", customerList);
        response.sendRedirect("Staff/Dashboard.jsp");
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
