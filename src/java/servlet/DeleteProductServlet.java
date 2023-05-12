package servlet;

import entity.Inventory;
import entity.Product;
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
import javax.transaction.UserTransaction;

/**
 *
 * @author chong
 */
public class DeleteProductServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productIdStr = request.getParameter("id");
        int productId = Integer.parseInt(productIdStr);
        String name = request.getParameter("productName");

//        Query query = em.createNamedQuery("Inventory.findAll");
//        List<Inventory> inventoryList = query.getResultList();
//        for (Inventory i : inventoryList) {
//            if (i.getProductId().getProductId() == productId)
//                try {
//                    utx.begin();
//                    i.setProductId(null);
//                    em.remove(i);
//                    utx.commit();
//                } catch (Exception e){}
//
//        }
        
        
      
        try {
            utx.begin();
              Product p = em.find(Product.class, productId);
            em.remove(p);
            utx.commit();
           
        } catch (Exception e) {
        } finally {
             response.sendRedirect("GetProduct?action=getAllProduct");
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
