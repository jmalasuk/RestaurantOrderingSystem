/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author malasuk
 */
public class MenuItem implements Serializable {
    
    private int id;
    private String itemName;
    private double itemPrice;
    private String itemDescription;    
    
    // Constructor
    public MenuItem() {
        
    }

    public MenuItem(int id, String itemName, double itemPrice, String description) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = description;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", itemName=" + itemName 
                + ", itemPrice=" + itemPrice + ", description=" 
                + itemDescription + '}';
    }
    
      
}
