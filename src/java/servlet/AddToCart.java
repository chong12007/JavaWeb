/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Cart;
import entity.CartProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class AddToCart extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        
        String qtyStr = request.getParameter("quantity");
        int qty = Integer.parseInt(qtyStr);
        String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);
        String priceStr = request.getParameter("price");
        double price = Double.parseDouble(priceStr);

        int custId = (int) session.getAttribute("customerId");
        int cartId = (int) session.getAttribute("cartId");

      
        int cartProductId = 0;
        Query query = em.createNamedQuery("CartProduct.findAll");
        List<CartProduct> cpList = query.getResultList();
        boolean continueLoop = true;
        
        for(CartProduct cp : cpList)
        {
            cartProductId = cp.getId();
        }
        
        
        while(continueLoop){        
            if (em.find(CartProduct.class, cartProductId) == null) {
                // ID does not exist, break out of the loop
                continueLoop = false;
                break;
        }
            cartProductId += 1;
        }
        
        if(cartProductId == 0)
            cartProductId = 1;
        
        
        
        boolean flag = true;
        query = em.createNamedQuery("Cart.findByCartId");
        query.setParameter("cartId", cartId);
        Cart c = (Cart) query.getSingleResult();
        
        
        for (CartProduct cartProduct : cpList) {
            if (cartProduct.getProductId() == productId && cartProduct.getCartId() == c.getCartId())
                try {
                cartProduct.setQuantity(qty);
                utx.begin();
                em.merge(cartProduct);
                utx.commit();

                flag = false;
                session.setAttribute("productId", productId);
                response.sendRedirect("GetCart");
                return;
            } catch (NotSupportedException notSupportedException) {
            } catch (SystemException systemException) {
            } catch (RollbackException rollbackException) {
            } catch (HeuristicMixedException heuristicMixedException) {
            } catch (HeuristicRollbackException heuristicRollbackException) {
            } catch (SecurityException securityException) {
            } catch (IllegalStateException illegalStateException) {
            }

        }//if already exist

        query = em.createNamedQuery("Cart.findByCartId");
        query.setParameter("cartId", cartId);
        c = (Cart) query.getSingleResult();
        if (flag)
            try {
            utx.begin();
           CartProduct cp = new CartProduct(cartProductId, cartId, productId, qty, price);
            em.persist(cp);
            utx.commit();
           
            

            response.sendRedirect("GetCart");
            return;
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
