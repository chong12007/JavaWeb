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
import javax.annotation.Resource;
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
public class AddEditDeleteStaffServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if (action.equals("update"))
            editStaff(request, response, session);
        else if (action.equals("add"))
            addStaff(request, response, session);
        else if (action.equals("delete"))
            deleteStaff(request, response, session);
        else
            System.out.println("error");

    }

    public void addStaff(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            //get from addstaff.jsp
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            //open session
            Staff getFromAddStaff = new Staff(
                    username,
                    password,
                    role
            );

            //find all
            Query query = em.createNamedQuery("Staff.findAll");
            //get all result in staff
            List<Staff> StaffList = query.getResultList();
            //Compare all user one by one
            int staffId = 0;
            for (Staff staff : StaffList) {
                //if staff edy exist
                if (staff.getUsername().equals(getFromAddStaff.getUsername())) {

                    session.removeAttribute("SuccessfulAddedStaff");
                    session.setAttribute("staffAlreadyRegistered", "This Staff already Registered");
                    response.sendRedirect("Staff/StaffAdd.jsp");
                }

                staffId = staff.getStaffId();
            }

            
            if(staffId == 0)
                staffId = 101;
            
            boolean continueLoop = true;

            while (continueLoop) {
                // check if the ID exists in the database
                if (em.find(Staff.class, staffId) == null) {
                    // ID does not exist, break out of the loop
                    continueLoop = false;
                    break;
                }

                // ID exists, increment and try again
                staffId += 1;
            }

            Manager manager = (Manager) session.getAttribute("manager");

            try {

                utx.begin();
                Staff addStaff = new Staff(
                        staffId,
                        getFromAddStaff.getUsername(),
                        getFromAddStaff.getPassword(),
                        getFromAddStaff.getStaffRole(),
                        manager
                );
                em.persist(addStaff);
                utx.commit();

                session.setAttribute("addStaff", addStaff);
                session.removeAttribute("staffAlreadyRegistered");
                session.setAttribute("SuccessfulAddedStaff", "Staff " + getFromAddStaff.getUsername() + " Successfuly Registered");
                response.sendRedirect("Staff/StaffAdd.jsp");
                return;
            } catch (IOException iOException) {
                System.out.println("erro io");
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void editStaff(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        try {
            int staffId = 0;

            String staffIdStr = request.getParameter("id");
            staffId = Integer.parseInt(staffIdStr);

            String role = request.getParameter("role");

            session.setAttribute("role", role);
            session.setAttribute("staffId", staffId);

            Staff s = em.find(Staff.class, staffId);
            s.setStaffRole(role);

            try {
                utx.begin();
                em.merge(s);
                utx.commit();

                Query query = em.createNamedQuery("Staff.findAll");
                List<Staff> StaffList = query.getResultList();

                session.setAttribute("staffList", StaffList);
                response.sendRedirect("GetStaff");
                return;
            } catch (Exception e) {
                System.out.println("erro io");
            }

        } catch (NumberFormatException numberFormatException) {
        }
    }

    public void deleteStaff(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            int staffId = 0;

            String staffIdStr = request.getParameter("id");
            staffId = Integer.parseInt(staffIdStr);

            session.setAttribute("staffId", staffId);

            try {
                utx.begin();
                Staff sd = em.find(Staff.class, staffId);
                em.remove(sd);
                utx.commit();

                //find all
                Query query = em.createNamedQuery("Staff.findAll");
                //get all result in staff
                List<Staff> StaffList = query.getResultList();
                session.setAttribute("staffList", StaffList);
                response.sendRedirect("GetStaff");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (NumberFormatException numberFormatException) {
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
