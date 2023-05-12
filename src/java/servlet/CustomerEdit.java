/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class CustomerEdit extends HttpServlet {

     @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNum = request.getParameter("phoneNum");
        String address = request.getParameter("address");

         //find all
        Query query = em.createNamedQuery("Customer.findAll");
        //get all result in customer
        List<Customer> CustomerList = query.getResultList();
        
      
       int custId = (int) session.getAttribute("customerId");
        
//         for (Customer customer : CustomerList) {
//            //if have same email or phone Number in DB display error
//            if (customer.getEmail().equals(email)) {
//                session.removeAttribute("SuccessfulMessage");
//                session.setAttribute("errorEmailEdit", "This Email already Registered");
//                response.sendRedirect("Public/CustomerLogin.jsp");
//                return;
//            }
//            if (customer.getPhonenumber().equals(phoneNum)) {
//                   session.removeAttribute("SuccessfulMessage");
//                session.setAttribute("errorPhoneNumberEdit", "This Phone number already Registered");
//                response.sendRedirect("Public/CustomerLogin.jsp");
//                return;
//            }
//            //=================   
//            
//        }
         
        try {
            utx.begin();
            Customer editCust = em.find(Customer.class, custId);
            editCust.setAddress(address);
            editCust.setEmail(email);
            editCust.setName(username);
            editCust.setPhonenumber(phoneNum);
            editCust.setPassword(password);
            em.merge(editCust);
            utx.commit();
            
            session.setAttribute("cust", editCust);
            response.sendRedirect("Customer/customerDashboard.jsp");
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
