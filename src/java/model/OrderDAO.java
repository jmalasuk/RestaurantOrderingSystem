/*
 * 
 */
package model;

import db.accessor.DBAccessor;
import db.accessor.DB_Generic;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * The DAO uses terminology the average BuisnessMan understands
 *
 * @author malasuk
 */
public class OrderDAO implements DaoInterface {
    
    private DBAccessor db;
    
    // Connect to Your Database
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://malasuk.com:3306";
    private static final String USER = "c1java";
    private static final String PWD = "jossmalo";
    
    private static int orderCount = 0;
        
    // Constructor
    public OrderDAO(){
        db = new DB_Generic();
    }
    
    @Override
    public List<MenuItem> getCurrentMenuChoices() throws RuntimeException{
        
        // Debugging
        System.out.println("****************************** Running getCurrentMenuChoices() in OrderDAO ***********************");
        
        List<MenuItem> items = new ArrayList<MenuItem>();

        try {
                    
            //create connection.  not a good idea.  ok for now.  We will retreive from a 'pool'
            db.openConnection(DRIVER,URL,USER,PWD);

            // Database name = c1java
            // Table name = Menu
            /*
             * SELECT column_name(s)
             * FROM table_name 
             */
            String sql = "SELECT * FROM c1java.Menu ORDER BY itemPrice";

            List<Map> rawData = db.findRecords(sql, true);
                for(Map record : rawData) {
                    MenuItem item = new MenuItem();
                    int id = Integer.valueOf(record.get("id").toString());
                    item.setId(id);
                    String name = String.valueOf(record.get("itemName"));
                    item.setItemName(name);
                    items.add(item); 
            }
                
        // close the DB connection
        db.closeConnection();            
        
        return items;

            
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch(Exception ex) {
             throw new RuntimeException(ex.getMessage(), ex);
        }finally{
            
        }
            
    }

    /*
     * Save the order to the DB
     *
     */
    @Override
    public void saveOrder(List<MenuItem> orderList) throws RuntimeException {
        
        System.out.println("*********************** Running saveOrder in OderDAO()");
            
            /* Save the order into the DB
             * Table = order_history
             *    - order_id
             *    - date
             *    - order_description
             *    - contact_info
             */
        try {   
            
            // open a Database Connection
            db.openConnection(DRIVER,URL,USER,PWD); 
            
            // create the date to send to DB
             Date date = new Date();
             SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
             String dateStr = sdf.format(date);
             
            String orderDescription = "";
            String contactInfo = "Mr. Implement Me";
            
            // loop through the passed orderList
            // place them into a string to put into the database.
            //  - not a professional thing to do
            for(MenuItem item : orderList) {
                orderDescription += item + " ";
            }
            
            // Varibles to hold information relating to the DB          
            String tablename = "c1java.order_history";
            List colDescriptors = new ArrayList();
            List colValues = new ArrayList();
            
            // DB colums to insert into
            colDescriptors.add(0, "date");
            colDescriptors.add(1, "order_description");
            colDescriptors.add(1, "contact_info");
            
            // Values to go to DB
            colValues.add(0, dateStr);
            colValues.add(1, orderDescription);
            colValues.add(1, contactInfo);
            
            // Insert data in DB and close the connection once finished
            db.insertRecord(tablename, colDescriptors, colValues, true);
            
            
            System.out.println("*** Finished Insert in saveOrder. OrderDAO()");
            
            
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } catch(Exception ex) {
             throw new RuntimeException(ex.getMessage(), ex);
        }
        
    }
    
}
