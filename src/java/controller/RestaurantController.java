package controller;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItem;
import model.OrderService;


/*
 * This is the 'Main' Controller
 * 
 * what it does, im not quite sure yet
 * - OrderController will handel communication reguarding the Order Process
 *    - get menu
 *    - save order <-- TODO
 * 
 */

/**
 *
 * @author malasuk
 */
public class RestaurantController extends HttpServlet {


    // Not sure if a controller should have a Constructor
    public RestaurantController() {
        super();  // added because Jim did
        
        // Get the menuList for the orderpage
        System.out.println("*********************** Construction Restraunt Controller....................");

    }

    
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
        
        // Debugging
        System.out.println("********************* Running doPost in Controller.");
        
        // call method to Process the Request
        processRequest(request, response);
        
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	String destination = "/orderForm.jsp";
        
        
        /*
         * Shit happend here
         */
        destination = "/Order.do?action=init";
        
        
        // Redirect to destination page
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
        
    }
    
    // Use a method to set all values - at some point
    private void submitOrder(){
        
    }
    

}


