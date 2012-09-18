package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Service Class
 * 
 *
 * @author malasuk
 */
public class OrderService implements Serializable {
    
    // Data Access Object
    private DaoInterface orderDao;
    // Holds the Menu Choices
    private List<MenuItem> menuList;
    // Holds Customers Order
    private List<MenuItem> orderList;

    
    // Constructor
    public OrderService() {
        // call method to init DB
        initItemsDb();        
    }
    
    
    // Initialize the Database items
    // - Place menu items into menuList
    // - ready orderList for customers order
    private void initItemsDb() {
        System.out.println("************************* Initializing the Database........ In OrderService **********************************");
        orderDao = new OrderDAO();
        menuList = orderDao.getCurrentMenuChoices();
        orderList = new ArrayList<MenuItem>();
    }

    // Ask DAO to save the order to DB
    public void placeOrder(){
        orderDao.saveOrder(orderList);
    }
    
    
    /*********************************************
     * Getters and Setters
     * 
     *********************************************/
    public DaoInterface getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(DaoInterface orderDao) {
        this.orderDao = orderDao;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public List<MenuItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MenuItem> orderList) {
        this.orderList = orderList;
    }
   
}
