/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Joseph Malasuk
 */
public class OrderController extends HttpServlet{
    
    private static final String RESULT_PAGE = "orderConfirm.jsp";
    
    
    // Create the Service Object
    // - Service object creates Data Access Object
    //  - DAO talks to the Database
    private OrderService orderService;
    
    
    
    
    /* doPost
     * - Called when form is submitted
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        

        processRequest(request, response);
           
        
        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
    
    
    // Where the Magic Happens
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
        
        	
        List<MenuItem> menuList = orderService.getMenuList();
	//List<MenuItem> orderList = orderService.getOrderList();
        
        // Get the 'Action' From Main Controller
        String action = request.getParameter("action");
        
        if(action.equals("init")) {
	    	// init the DB
            
                        
        }else{
            
        }
        
        
        
    }
    
    
    
    
    	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
        @Override
	public void init() throws ServletException {
            try{
                orderService = new OrderService();
            }catch(Exception e){
                System.out.println("********************* Problem! Thrown in OrderController, while Initializing\n" + e );
            }
            
	}
    
}
