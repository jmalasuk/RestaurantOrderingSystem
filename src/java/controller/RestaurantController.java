package controller;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import menu.Order;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malasuk
 */
public class RestaurantController extends HttpServlet {
    
    private static final String RESULT_PAGE = "orderConfirm.jsp";
    
    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        // parameters are name attributes in view pages
        // Here we're retrieving form content from form.html
        String c = request.getParameter("menuItems");
        
        System.out.println(c);
        
        // Create a new instance of a model object
        Order placeOrder = new Order();
        
        // Set the Order
        placeOrder.setOrderItems(c.trim());
        
        
        
        
          
        // We can use attributes to store data for use on another page.
        request.setAttribute("menuItems", c);
        
        // This object lets you forward both the request and response
        // objects to a destination page
        
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
    
}