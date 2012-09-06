/*
 * Model Class
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malasuk
 */
public class OrderModel implements Serializable {
    
    //private List orderItems = new ArrayList();
    private String fullname = "";
    private String phone = "";
    private String main = "";
    private String side = "";
    private String drink = "";
    
    // set Order
//    public void setOrderItems(String orderItems){
//        //this.orderItems = orderItems;
//        this.orderString = orderItems;
//        System.out.println("Order Set: " + orderString);
//    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setMain(String main) {
        this.main = main;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
    
    
    
    
    
    
}
