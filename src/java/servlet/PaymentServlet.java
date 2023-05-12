/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Cart;
import entity.Customer;
import entity.Product;
import entity.Purchase;
//import entity.PurchaseHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
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
public class PaymentServlet extends HttpServlet {

     @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
//        HttpSession session = request.getSession();
//
//        String address = (String) session.getAttribute("address");
//        int cartId = (int) session.getAttribute("cartId");
//        int custId = (int) session.getAttribute("custId");
//        double totalPrice = (double) session.getAttribute("totalPrice");
//
//        int purchaseHistoryId = 0;
//        Query query = em.createNamedQuery("PurchaseHistory.findAll");
//        List<PurchaseHistory> purchaseHistoryList = query.getResultList();
//        for(PurchaseHistory purchaseHistory: purchaseHistoryList){
//            purchaseHistoryId = purchaseHistory.getPurchaseHistoryId();
//        }
//        
//        if(purchaseHistoryId == 0)
//            purchaseHistoryId =1;
//        
//        boolean continueLoop = true;
//        
//       while (continueLoop) {
//            // check if the ID exists in the database
//            if (em.find(PurchaseHistory.class, purchaseHistoryId) == null) {
//                // ID does not exist, break out of the loop
//                continueLoop = false;
//                break;
//            }
//
//            // ID exists, increment and try again
//            purchaseHistoryId += 1;
//        }
//       
//        LocalTime localTime = LocalTime.now();
//        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
//        Date createdDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//
//        
//        List<PurchaseHistory> addPurchaseHistorys = new ArrayList<>();
//        List<Product> productListCart = (List<Product>) session.getAttribute("productListCart");
//        for(PurchaseHistory ph : purchaseHistoryList)
//        {
//            for(Product product: productListCart){
//                ph.setPurchaseHistoryId(purchaseHistoryId);
//                ph.setProductId(product.getProductId());
//                ph.setName(product.getName());
//                ph.setQuantity(product.getQuantity());
//                ph.setPrice(product.getPrice());
//                ph.setImage(product.getImgPath());
//                ph.setPurchaseddate(createdDate);
//                addPurchaseHistorys.add(ph);
//                purchaseHistoryId += 1;
//            }
//             
//        }
//       
//                
//
//      
//
//        try {
//            utx.begin();
//            for(PurchaseHistory addPh: addPurchaseHistorys){
//                em.persist(addPh);
//            }            
//            utx.commit();
//        } catch (NotSupportedException notSupportedException) {
//        } catch (SystemException systemException) {
//        } catch (RollbackException rollbackException) {
//        } catch (HeuristicMixedException heuristicMixedException) {
//        } catch (HeuristicRollbackException heuristicRollbackException) {
//        } catch (SecurityException securityException) {
//        } catch (IllegalStateException illegalStateException) {
//        }
//    
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
