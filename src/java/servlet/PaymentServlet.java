/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Cart;
import entity.CartProduct;
import entity.Customer;
import entity.Inventory;
import entity.Payment;
import entity.Product;
import entity.Purchase;
import entity.PurchaseHistory;
import entity.PurchaseHistoryProduct;
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

        HttpSession session = request.getSession();

        String paymentMethod = request.getParameter("payment");
        String address = (String) session.getAttribute("address");
        int cartId = (int) session.getAttribute("cartId");
        int custId = (int) session.getAttribute("customerId");
        double totalPrice = (double) session.getAttribute("totalPrice");

        int purchaseHistoryId = 0;
        Query query = em.createNamedQuery("PurchaseHistory.findAll");
        List<PurchaseHistory> purchaseHistoryList = query.getResultList();
        for (PurchaseHistory purchaseHistory : purchaseHistoryList) {
            purchaseHistoryId = purchaseHistory.getPurchaseHistoryId();
        }

        if (purchaseHistoryId == 0)
            purchaseHistoryId = 1;

        boolean continueLoop = true;

        while (continueLoop) {
            // check if the ID exists in the database
            if (em.find(PurchaseHistory.class, purchaseHistoryId) == null) {
                // ID does not exist, break out of the loop
                continueLoop = false;
                break;
            }

            // ID exists, increment and try again
            purchaseHistoryId += 1;
        }

        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
        Date createdDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        List<PurchaseHistory> addPurchaseHistorys = new ArrayList<>();
        List<Product> productListCart = (List<Product>) session.getAttribute("productListCart");
        

        for (Product product : productListCart) {
            PurchaseHistory ph = new PurchaseHistory(
                    purchaseHistoryId,
                    product.getProductId(),
                    product.getName(),
                    product.getQuantity(),
                    product.getPrice(),
                    product.getDescription(),
                    createdDate);
            addPurchaseHistorys.add(ph);
            purchaseHistoryId++;
        }

        try {

            for (PurchaseHistory addPh : addPurchaseHistorys) {
                utx.begin();
                em.persist(addPh);
                utx.commit();
            }

        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        }

        int purchaseId = 0;
        query = em.createNamedQuery("Purchase.findAll");
        List<Purchase> purchaseList = query.getResultList();
        for (Purchase purchase : purchaseList) {
            purchaseId = purchase.getPurchaseHistoryProductId();
        }

        if (purchaseId == 0)
            purchaseId = 1;

        boolean continueLoopPurchase = true;

        while (continueLoopPurchase) {
            // check if the ID exists in the database
            if (em.find(Purchase.class, purchaseId) == null) {
                // ID does not exist, break out of the loop
                continueLoopPurchase = false;
                break;
            }

            // ID exists, increment and try again
            purchaseId += 1;
        }

        try {
            utx.begin();
            Purchase addPuchase = new Purchase(
                    purchaseId,
                    totalPrice,
                    address,
                    "Prepared to Ship",
                    0,
                    custId);
            em.persist(addPuchase);
            utx.commit();
        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        }

        int id = 0;
        int phdId = 0;
        query = em.createNamedQuery("PurchaseHistoryProduct.findAll");
        List<PurchaseHistoryProduct> phdList = query.getResultList();
        for (PurchaseHistoryProduct phd : phdList) {
            id = phd.getId();
            phdId = phd.getPurchaseHistoryProductId();
        }

        if (id == 0)
            id = 1;

        if (phdId == 0)
            phdId = 1;

        boolean continueLoopPhd = true;

        while (continueLoopPhd) {
            // check if the ID exists in the database
            if (em.find(PurchaseHistoryProduct.class, purchaseId) == null) {
                // ID does not exist, break out of the loop
                continueLoopPhd = false;
                break;
            }

            // ID exists, increment and try again
            id += 1;
            phdId++;
        }

        List<PurchaseHistoryProduct> phpList = new ArrayList<>();

     

            for (PurchaseHistory ph : addPurchaseHistorys) {
                PurchaseHistoryProduct php = new PurchaseHistoryProduct(
                        id,
                        phdId,
                        purchaseId,
                        ph.getPurchaseHistoryId()
                );

                phpList.add(php);
                id++;
            }
           
        

        for (PurchaseHistoryProduct addPhp : phpList) {
            try {
                utx.begin();
                em.persist(addPhp);
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

        try {
            utx.begin();
            Purchase addPurchase = em.find(Purchase.class, purchaseId);
            addPurchase.setPurchaseHistoryProductId(purchaseHistoryId);
            em.merge(addPurchase);
            utx.commit();
        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        }

        int paymentId = 0;

        query = em.createNamedQuery("Payment.findAll");
        List<Payment> paymentList = query.getResultList();
        for (Payment payment : paymentList) {
            paymentId = payment.getPaymentId();
        }

        if (paymentId == 0)
            paymentId = 1;

        boolean continueLoopPayment = true;

        while (continueLoopPayment) {
            // check if the ID exists in the database
            if (em.find(Payment.class, paymentId) == null) {
                // ID does not exist, break out of the loop
                continueLoopPayment = false;
                break;
            }

            // ID exists, increment and try again
            paymentId += 1;

        }

        try {
            utx.begin();
            Payment addPayment = new Payment(
                    paymentId,
                    createdDate,
                    paymentMethod,
                    totalPrice,
                    purchaseId);
            em.persist(addPayment);
            utx.commit();
        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        }

        query = em.createNamedQuery("Inventory.findAll");
        List<Inventory> inventoryList = query.getResultList();
        for (Product product : productListCart) {
            for (Inventory i : inventoryList) {
                if (product.getProductId() == i.getProductId().getProductId()) {
                    i.setQuantity(i.getQuantity() - product.getQuantity());
                    try {
                        utx.begin();
                        em.merge(i);
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

        query = em.createNamedQuery("CartProduct.findAll");
        List<CartProduct> cpList = query.getResultList();
        for (Product product : productListCart) {
            for (CartProduct cp : cpList) {
                if (product.getProductId() == cp.getProductId())
                    cp.setQuantity(0);
                try {
                    utx.begin();
                    em.merge(cp);
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

        response.sendRedirect("Customer/OrderCompleted.jsp");
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
