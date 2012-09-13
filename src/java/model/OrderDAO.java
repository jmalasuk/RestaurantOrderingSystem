/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.accessor.DBAccessor;
import db.accessor.DB_Generic;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * The DAO uses terminology the average BuisnessMan understands
 *
 * @author malasuk
 */
public class OrderDAO {
    

    private DBAccessor db;
    
    public OrderDAO(){
        db = new DB_Generic();
    }
    
    public List<MenuItem> getCurrentMenuChoices() throws Exception{
        
        List<MenuItem> items = new ArrayList<MenuItem>();

        //create connection.  not a good idea.  ok for now.  We will retreive from a 'pool'
        db.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://malasuk.com:3306", "c1java", "jossmalo");

        String sql = "SELECT * FROM Menu ORDER BY price";
        
        List<Map> rawData = db.findRecords(sql, true);
        
        for (Map record : rawData){
            MenuItem item = new MenuItem();
            String name = record.get("ItemName").toString();
            item.setItemName(name);
            //
            //item.additem();
            
        }
        
        return null;
    }
    
}
