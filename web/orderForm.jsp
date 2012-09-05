<%-- 
    Document   : orderForm
    Created on : Sep 2, 2012, 2:31:02 PM
    Author     : malasuk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h2>Restaurant Ordering System</h2>
        
        
            <!-- Order Form -->
            <div>
                
                <h1>Select Meal</h1>
                <form id="menuItems" name="menuItems" method="POST" action="Order.do">
                
                    <table border="1" width="500px">
                        <tr>
                            <th>Selection</th>
                            <th>Menu Option</th>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="menuItems" value="burger" />
                            </td>
                            <td>Burger</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="menuItems" value="cheeseburger" />
                            </td>
                            <td>Cheese Burger</td>
                        </tr>
                        
                        
                        
                        <select>
                               
                            
                        </select>
                        
                        
                        
                        

                        <% 
/*
                            List recs = (List)request.getAttribute("getMenu");
                            Iterator it = recs.iterator();
                            if (it == null){
                                out.print("Error, Received Null from Menu");
                            }else{
                                
                                while(it.hasNext()) {
                                    // Notice we're outputting some HTML. Is that a good idea?
                                    // Also, notice we do not cast the object returned by the
                                    // iterator to a String. Why?
                                    out.print("<tr>");
                                    out.print("<th>CheckBoxes</th>");
                                    out.print("<br>try: " + it.next());
                                    out.print("</tr>");
                                } 
                            }
 */                           
                        %>
                 
                        
                    
                    </table>
                        
                        <br /><br />
                        
                        <input id="submit" name="submit" type="submit" value="Place Order">
                        
                </form>
            </div>
        
        
    </body>
</html>
