/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import entity.Manager;
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
public class StaffLoginServlet extends HttpServlet {

      @PersistenceContext
    EntityManager em;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
            
            HttpSession session = request.getSession();

        try {
            //Get value from CustomerLogin.jsp
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //find all
            Query query = em.createNamedQuery("Manager.findAll");
            List<Manager> ManagerList = query.getResultList();
            query = em.createNamedQuery("Staff.findAll");
            List<Staff> StaffList = query.getResultList();

            for (Manager manager : ManagerList) {
                if (manager.getName().equals(username)
                        && manager.getPassword().equals(password)) {

                    session.setAttribute("user", "manager");
                    session.setAttribute("manager", manager);
                  response.sendRedirect("StaffDashboard");
                  return;
                }

            }

            for (Staff staff : StaffList) {
                if (staff.getUsername().equals(username)
                        && staff.getPassword().equals(password)) {

                    session.setAttribute("user", staff.getStaffRole());
                    session.setAttribute("staff", staff);
                    response.sendRedirect("StaffDashboard");
                    return;
                }

            }

            //else    
            session.setAttribute("errorMessage", "Invalid username or password");
            response.sendRedirect("Public/StaffLogin.jsp");

        } catch (IOException e) {
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
