/*
 * Model Class
 */
package menu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malasuk
 */
public class OrderModel {
    
    private List orderItems = new ArrayList();
    private String orderString = "";
    
    // set Order
    public void setOrderItems(String orderItems){
        //this.orderItems = orderItems;
        this.orderString = orderItems;
        System.out.println("Order Set: " + orderString);
    }
    
    // get the menu
    public List getMenu(){
        
        List menu = new ArrayList();  
        
        // Menu Items
        menu.add("Item 1");
        menu.add("Item 2");
        menu.add("Item 3");
        menu.add("Item 4");
        
        return menu;
    }
    
    
}
