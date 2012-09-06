package controller;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrderModel;


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
        String main = request.getParameter("main");
        String side = request.getParameter("side");
        String drink = request.getParameter("drink");
        
        
        // Create a new instance of a model object
        OrderModel placeOrder = new OrderModel();
        
        // Set the Order
        placeOrder.setMain(main);
        placeOrder.setSide(side);
        placeOrder.setDrink(drink);

          
        // We can use attributes to store data for use on another page.
        request.setAttribute("main", main);
        request.setAttribute("side", side);
        request.setAttribute("drink", drink);
        
        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
    
}
