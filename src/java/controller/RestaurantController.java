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



/** Main Controller
 *
 * @author malasuk
 */
public class RestaurantController extends HttpServlet {

    
    /*
     * Create the service class here.
     * It was moved here from orderController
     *
     */
    private OrderService orderService;
    
    
    

    // Constructor
    public RestaurantController() {
        super();  // added because Jim did
        
        // Debugging
        System.out.println("*********************** Constructing Restraunt Controller....................");

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
        
        // Process the Request
        //processRequest(request, response);
        
        if( request.getParameter("action").equals("init")) {
                // initialize for first use
    		init(request, response);
    	} else if( request.getParameter("action").equals("placeOrder")) {
    		// place the order
                placeOrder(request, response);
        }
        
    }
    
    
    /* init()
     * - This method runs when orderForm is called to initialize the DB
     *  - gets the menu
     * 
     */
    protected void init(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	String destination = "/orderForm.jsp";

        // Get Values
        List<MenuItem> menuList = orderService.getMenuList();
	List<MenuItem> orderList = orderService.getOrderList();
        
        
        // set the attribute to retreive in orderForm.jsp
        request.setAttribute("menuList", menuList);
        request.setAttribute("orderList", orderList);                
        
        // Redirect to destination page
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
        
    }
    
    
    
    /* placeOrder()
     * - This method is ran to place an order
     * 
     */
    protected void placeOrder(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	String destination = "/orderConfirm.jsp";

        
        // Values to work with
        List<MenuItem> menuList = orderService.getMenuList();
	List<MenuItem> orderList = orderService.getOrderList();;
        
        // Get the checkboxes from orderForm.jsp
        String[] orderedItems = request.getParameterValues("menuItems");
        
            /*
             * Take the items the user ordered, and enter the menuItem() into
             *  a List<MenuItem>
             */
            orderList.clear();
            for(String item : orderedItems) {
                for(MenuItem menuItem : menuList) {
                    if(menuItem.getItemName().equals(item)) {
                        orderList.add(menuItem);
                        break;
                    }
                }   
            }
            
            // Place the order if the user made a selection
            if(orderList.size() > 0){
                orderService.placeOrder();
            }
        
        /* the order is placed    */
        // Redirect to destination page
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
            
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

