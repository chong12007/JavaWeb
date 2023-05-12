/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Cart;
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

public class CustomerLoginRegisterServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action.equals("login"))
            Login(request, response, session);
        else if (action.equals("register"))
            Register(request, response, session);
        else
            System.out.println("error");
    }

    public void Login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            //Get value from CustomerLogin.jsp
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            //find all
            Query query = em.createNamedQuery("Customer.findAll");
            //get all result in customer
            List<Customer> CustomerList = query.getResultList();
            //Compare all user one by one

            query = em.createNamedQuery("Cart.findAll");
            List<Cart> cartList = query.getResultList();

            for (Customer customer : CustomerList) {
                if (customer.getEmail().equals(email)
                        && customer.getPassword().equals(password))
                    //Set user=customer

                    for (Cart cart : cartList) {
                        if (customer.getCustomerId() == cart.getCustomerId().getCustomerId()) {
                            session.setAttribute("cust", customer);
                            session.setAttribute("customerId", customer.getCustomerId());
                            session.setAttribute("cart", cart);
                            session.setAttribute("cartId", cart.getCartId());
                            response.sendRedirect("Dashboard");
                            return;
                        }

                    }

            }

            //else
            
            session.setAttribute("errorMessage", "Invalid username or password");
            response.sendRedirect("Public/CustomerLogin.jsp");

        } catch (Exception e) {
        }
    }

    public void Register(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        //Get value from login.jsp
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("RegisterPassword");
        String phoneNum = request.getParameter("phoneNum");
        String address = request.getParameter("address");
        //open session

        //find all
        Query query = em.createNamedQuery("Customer.findAll");
        //get all result in customer
        List<Customer> CustomerList = query.getResultList();

        query = em.createNamedQuery("Cart.findAll");
        List<Cart> cartList = query.getResultList();
        //Compare all user one by one

        int custId =0;
        
        for (Customer customer : CustomerList) {
            //if have same email or phone Number in DB display error
            if (customer.getEmail().equals(email)) {
                session.removeAttribute("SuccessfulMessage");
                session.setAttribute("errorEmail", "This Email already Registered");
                response.sendRedirect("Public/CustomerLogin.jsp");
                return;
            }
            if (customer.getPhonenumber().equals(phoneNum)) {
                   session.removeAttribute("SuccessfulMessage");
                session.setAttribute("errorPhoneNumber", "This Phone number already Registered");
                response.sendRedirect("Public/CustomerLogin.jsp");
                return;
            }
            //=================   
            custId = customer.getCustomerId();
        }
        
        if(custId == 0)
            custId =1;
        
       
        query = em.createNamedQuery("Cart.countAll");
        Long totalCartId = (Long) query.getSingleResult();
        int cartLatestId = totalCartId.intValue();
        boolean continueLoop = true;
        boolean continueLoopCart = true;

        do {
            // check if the ID exists in the database
            if (em.find(Customer.class, custId) == null)
            {
                 // ID does not exist, break out of the loop
                continueLoop = false;
                break;
            }
               

            // ID exists, increment and try again
            custId++;
        } while (continueLoop);

        do {
            // check if the ID exists in the database
            if (em.find(Cart.class, cartLatestId) == null)
             {
                 // ID does not exist, break out of the loop
                continueLoopCart = false;
                break;
            }

            // ID exists, increment and try again
            cartLatestId++;
        } while (continueLoopCart);

        try {
            utx.begin();
            Customer newCustomer = new Customer(
                    custId,
                    username,
                    email,
                    password,
                    phoneNum,
                    address);
            Cart newCart = new Cart(cartLatestId, newCustomer);
            em.persist(newCustomer);
            em.persist(newCart);
            utx.commit();
            session.setAttribute("cust", newCustomer);
        } catch (NotSupportedException notSupportedException) {
        } catch (SystemException systemException) {
        } catch (RollbackException rollbackException) {
        } catch (HeuristicMixedException heuristicMixedException) {
        } catch (HeuristicRollbackException heuristicRollbackException) {
        } catch (SecurityException securityException) {
        } catch (IllegalStateException illegalStateException) {
        }

        session.removeAttribute(
                "errorEmail");
        session.removeAttribute(
                "errorPhoneNumber");
        session.setAttribute(
                "SuccessfulMessage", "Account Successfuly Registered");

        response.sendRedirect(
                "Public/CustomerLogin.jsp");

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
