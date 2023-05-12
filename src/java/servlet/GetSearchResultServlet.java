
package servlet;

import entity.Customer;
import entity.Inventory;
import entity.Product;
import entity.Staff;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
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
public class GetSearchResultServlet extends HttpServlet {

     @PersistenceContext
    EntityManager em;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            HttpSession session = request.getSession();
        String table = request.getParameter("table");
        String queryFromSearch = request.getParameter("query");

        if (table.equals("productTable")) {
            List<Product> results = new ArrayList<>();
            int count = 0;

            List<Product> productList = getAllProduct(request, response, session);
            for (Product productAll : productList) {
                if (productAll.getName().toLowerCase().contains(queryFromSearch.toLowerCase()))
                    results.add(productAll);
            }

            session.setAttribute("productSearchResults", results);

            response.sendRedirect("Staff/Product_Tables_Search_Result.jsp");
        } else if (table.equals("staffTable")) {
            List<Staff> results = new ArrayList<>();
            List<Staff> staffList = getAllStaff(request, response, session);

            for (Staff staffAll : staffList) {
                if (staffAll.getUsername().toLowerCase().contains(queryFromSearch.toLowerCase()))
                    results.add(staffAll);
            }
            session.setAttribute("staffSearchResults", results);
            response.sendRedirect("Staff/Staff_Tables_Search_Result.jsp");
        } else if (table.equals("productTableView")) {
            List<Product> results = new ArrayList<>();
            List<Product> productList = getAllProductCustomer(request, response, session);

            for (Product productAll : productList) {
                if (productAll.getName().toLowerCase().contains(queryFromSearch.toLowerCase()))
                    results.add(productAll);
            }

            session.setAttribute("productSearchResults", results);
            response.sendRedirect("Customer/Product_Search_Result.jsp");
        } else if(table.equals("productTableViewGuest")){
             List<Product> results = new ArrayList<>();
            List<Product> productList = getAllProductCustomer(request, response, session);

            for (Product productAll : productList) {
                if (productAll.getName().toLowerCase().contains(queryFromSearch.toLowerCase()))
                    results.add(productAll);
            }

            session.setAttribute("productSearchResults", results);
            response.sendRedirect("Public/Product_Search_Result.jsp");
        } else if(table.equals("userTable")) {
               List<Customer> results = new ArrayList<>();
            List<Customer> customerList = getAllCustomer(request, response, session);
            
             for (Customer customerAll : customerList) {
                if (customerAll.getName().toLowerCase().contains(queryFromSearch.toLowerCase()))
                    results.add(customerAll);
            }
             
              session.setAttribute("CustomerSearchResults", results);
            response.sendRedirect("Staff/User_Search_Result.jsp");

        }

    }
    
      public List<Product> getAllProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        List<Product> productList = null;
        String imagePath = null;
        try {
            Query query = em.createNamedQuery("Product.findAll");
            productList = query.getResultList();
            query = em.createNamedQuery("Inventory.findAll");
            List<Inventory> inventoryList = query.getResultList();

            for (Product product : productList) {
                for (Inventory inventory : inventoryList) {
                    if (product.getProductId() == inventory.getProductId().getProductId())
                        product.setQuantity(inventory.getQuantity());
                }
            }

            //get image
            for (Product product : productList) {
                byte[] blob = product.getImage();
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] imageData = baos.toByteArray();
                String encodedImage = Base64.getEncoder().encodeToString(imageData);
                imagePath = "data:image/png;base64," + encodedImage;
                product.setImgPath(imagePath);

            }
        } catch (IOException iOException) {
        }

        return productList;
    }

    public List<Staff> getAllStaff(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Query query = em.createNamedQuery("Staff.findAll");
        List<Staff> staffList = query.getResultList();

        return staffList;

    }

    public List<Product> getAllProductCustomer(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        List<Product> productList = null;
        List<Product> productListResult = new ArrayList<>();

        String imagePath = null;
        try {
            Query query = em.createNamedQuery("Product.findAll");
            productList = query.getResultList();
            query = em.createNamedQuery("Inventory.findAll");
            List<Inventory> inventoryList = query.getResultList();

            for (Product product : productList) {
                if (!product.getStatus().equals("Hidden"))
                    productListResult.add(product);
            }

            for (Product product : productListResult) {
                for (Inventory inventory : inventoryList) {
                    if (product.getProductId() == inventory.getProductId().getProductId())
                        product.setQuantity(inventory.getQuantity());
                }
            }

            //get image
            for (Product product : productListResult) {
                byte[] blob = product.getImage();
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(blob));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] imageData = baos.toByteArray();
                String encodedImage = Base64.getEncoder().encodeToString(imageData);
                imagePath = "data:image/png;base64," + encodedImage;
                product.setImgPath(imagePath);

            }
        } catch (IOException iOException) {
        }

        return productListResult;
    }
    
    public List<Customer> getAllCustomer (HttpServletRequest request, HttpServletResponse response, HttpSession session){
         Query query = em.createNamedQuery("Customer.findAll");
        List<Customer> customerList = query.getResultList();

        return customerList;
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
