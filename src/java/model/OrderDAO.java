/*
 * 
 */
package model;

import db.accessor.DBAccessor;
import db.accessor.DB_Generic;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The DAO uses terminology the average BuisnessMan understands
 *
 * @author malasuk
 */
public class OrderDAO implements DaoInterface {
    
    private DBAccessor db;
    
    // Connect to Database at Home
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
            
        return items;
            
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

    @Override
    public void saveOrder(List<MenuItem> orderList) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
