/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItem;
import model.OrderService;

/* 
 *
 * @author Joseph Malasuk
 */
public class OrderController extends HttpServlet {
    
    private static final String RESULT_PAGE = "orderConfirm.jsp";
    
    /* This is the second time you are instaniating this!
     * 
     */
    private OrderService orderService;

    // Where the Magic Happens
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {


        // Get the checkboxes from orderForm.jsp
        String[] orderedItems = request.getParameterValues("menuItems");
        
        
        //
//        List<MenuItem> placeOrder = new ArrayList<MenuItem>();
//        for (String s : orderedItems){
//            placeOrder.
//        }
        
    }
    
    
        
    /* doPost
     * - Called when form is submitted
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        
        // call the method to do the work for the order
        processRequest(request, response);
                   
        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
    




	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
        @Override
	public void init() throws ServletException {
            orderService = new OrderService();
	}
    
}
