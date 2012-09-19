<!-- Imports for Database Support -->
<%@page import="model.MenuItem"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
        // Hold the Menu
        System.out.println("********************* Attempting to Get Attribute MenuList in orderForm.jsp: " + request.getAttribute("menuList"));
	List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");

        // TODO: use to save order
	List<MenuItem> orderList = (List<MenuItem>) request.getAttribute("orderList");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Ordering System</title>
    </head>
    <body>
        
        
        
        <h2>Restaurant Ordering System</h2>
       
            <!-- Order Form -->
            <div>
                
                <form method="POST" action="Controller.do?action=placeOrder">

                    <h3>Select Menu Item </h3>                        
                    

                    <%
                        for(MenuItem menuItem : menuList) {
                            String item = menuItem.getItemName();

                    %>

                            <input type="checkbox" name="menuItems" value="<%= item %>" /> <%= item %><br/>

                    <%
                        }
                    %>

                    <br>
                        
                        <!-- Submit Button -->
                        <input id="submit" name="submit" type="submit" value="Place Order">
                        
                </form>
            </div>
            
             
                     
                     
                     
    </body>
</html>
