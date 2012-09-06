/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.query;

import java.sql.Statement;

/**
 *
 * @author malasuk
 */
public class Insert {
    
    private Statement stmt;
    
    /*
     * Insert to mysql
     * 
     * Returns: True = pass.  False = failure
     */
    public boolean doInsert(db.MySQL_Connection conn, String sql) throws Exception{
        
        try{
            stmt.executeQuery(sql);
        }catch (Exception e){
            System.out.println(e);
            return false; 
        }finally{
            return true;
        }
        
    }
    
}
