/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author malasuk
 */
public class Select {    
    
    /*
     * Submit a Select to DB
     * 
     */

    private Statement stmt;
    private ResultSet rs;
    
    public List<Map> getAllRecords(db.MySQL_Connection conn, String sql) throws Exception {
        // --- we are passing a connection
        //conn = DriverManager.getConnection(url, userName, password);
        
            
        ResultSetMetaData metaData = null;
        final List<Map> list=new ArrayList<Map>();
        Map record = null;

        // do this in an excpetion handler so that we can depend on the
        // finally clause to close the connection
        try {
                //stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                metaData = rs.getMetaData();
                final int fields=metaData.getColumnCount();

                while( rs.next() ) {
                        record = new HashMap();
                        for( int i=1; i <= fields; i++ ) {
                                try {
                                    record.put( metaData.getColumnName(i), rs.getObject(i) );
                                } catch(NullPointerException npe) {
                                    // no need to do anything... if it fails, just ignore it and continue
                                }
                        } // end for
                        list.add(record);
                } // end while

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            throw e;
        } finally {
            
            // ---- no need for this since we passed a connection
            //try {
            //    if(stmt !=null) stmt.close();
            //    if(conn != null) conn.close();
            //} catch(SQLException e) {
            //        throw e;            
            //} // end try
            
        } // end finally

        return list; // will  be null if none found
    }

//    public static void main(String[] args) {
//        try {
//            DBManager db = new DBManager("com.microsoft.sqlserver.jdbc.SQLServerDriver",
//                    "jdbc:sqlserver://bitsql.wctc.edu:1433;databaseName=JGL-EMPLOYEE",
//                    "advjava", "advjava");
//
//            String sql = "SELECT LastName, FirstName, Email, HireDate FROM Employee";
//
//            List<Map> records = db.getAllRecords(sql);
//
//            for(Map record : records) {
//                System.out.print(record.get("LastName") + ", ");
//                System.out.println(record.get("FirstName"));
//            }
//            
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
            
    
}
