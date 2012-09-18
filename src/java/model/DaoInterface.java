/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 * This Interface is used for Data Access Objects
 * - DB support
 * 
 * @author Joseph Malasuk
 */
public interface DaoInterface {
    
    // Get the Menu Choices from the Database
    List<MenuItem> getCurrentMenuChoices() throws RuntimeException;

    // Save a User order to the Database
    void saveOrder(List<MenuItem> orderList) throws RuntimeException;
    
}
