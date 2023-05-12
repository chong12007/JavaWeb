/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Product;
import entity.ProductReview;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
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
public class CustomerReviewServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        String ratingStr = request.getParameter("rating");
        int rating = Integer.parseInt(ratingStr);
        String comment = request.getParameter("comment");
        int custId = (int) session.getAttribute("customerId");
        
          LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
        Date createdDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        
        Query query = em.createNamedQuery("ProductReview.findAll");
        List<ProductReview> productReviewList = query.getResultList();
        int Id = 0;
        for (ProductReview p : productReviewList) {
            Id = p.getProductReviewId();
        }

        //If no product exist in db
        if (Id == 0)
            Id = 1;

        boolean continueLoop = true;

        while (continueLoop) {
            // check if the ID exists in the database
            if (em.find(ProductReview.class, Id) == null) {
                // ID does not exist, break out of the loop
                continueLoop = false;
                break;
            }

            // ID exists, increment and try again
            Id += 1;
        }
        
        try {
            utx.begin();
            ProductReview addPR = new ProductReview(
                    Id,
                    rating,
                    comment,
                    createdDate,
                    custId);
            em.persist(addPR);
            utx.commit();
            
            response.sendRedirect("Customer/index.jsp");
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
