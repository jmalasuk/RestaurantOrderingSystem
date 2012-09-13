/*
 * Manage Data to and fro DB
 */
package db;

import db.MySQL_Connection;
import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author malasuk
 */
public class DBManager {
    
    // Create MySQL connection
    MySQL_Connection conn = new MySQL_Connection();


    // Constructor
    public DBManager() {
        // ask db to connect. <rigid>
        conn.dbConnect();        
    }
    
    
    /* --- Select ---
     * 
     */
    public java.util.List<Map> doSelect(String sql){
        // create sql object --> probably a bad idea
        Select select = new Select();
        // List Map to store result
        java.util.List<Map> records = new ArrayList<Map>();
        
        try{
            records = select.getAllRecords(conn, sql);
        }catch (Exception e){
            System.out.println(e);
        }finally{
            return records;
        }
    }
        
        
        
    /* --- Add New Order ---
     *  LEFT OFF HERE  
     * YOUR insert probably wont work.  
     * idk about passing around the connection.  its kinda getting skechy
     * 
     * You must create the Database Schema before you can go on with this
     */
    public void doInsert(String sql){
        Insert insert = new Insert();
        
        try{
            if (insert.doInsert(conn, sql)){
               // Success
                System.out.println("Success inserting into DB");
            }else{
                // Insert Failed
                System.out.println("Failure when attempting DB Insert: Check Insert.java");
            }
                
        }catch(Exception e){
            // do something
            System.out.println(e);
        }finally{
            // then do this
        }
                
    }
        
        
    
    
    
    

    
    
    
    
}
