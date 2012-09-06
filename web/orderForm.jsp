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
                
                
                <form id="menuItems" name="menuItems" method="POST" action="Order.do">
                
                    <!-- Name -->
                    Full Name: <input type="text" name="fullname" />
                    <br>
                    <!-- Phone Number -->
                    Phone Number: <input type="text" name="phone" />
                    
                    <br><br>
                    <h3>Select Main Course </h3>
                    <table border="1" width="500px">
                        <tr>
                            <th>Selection</th>
                            <th>Main Course</th>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="main" value="burger" />
                            </td>
                            <td>Burger</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="main" value="cheeseburger" />
                            </td>
                            <td>Cheese Burger</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="main" value="steak" />
                            </td>
                            <td>Steak</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="main" value="fish" />
                            </td>
                            <td>Fish</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="main" value="taco" />
                            </td>
                            <td>Taco</td>
                        </tr>
                        
                        <tr>
                            <td>
                                <input type="checkbox" name="main" value="pizza" />
                            </td>
                            <td>Pizza</td>
                        </tr>
                        
                    </table>
                    
                    <br><br>
                        
                        <h3>Select Side </h3>
                        <select name="side">
                            <option value="soup">Soup</option>
                            <option value="salad">Salad</option>                            
                        </select>    
                        
                        <br /><br />
                        
                        <h3>Select Drink </h3>
                        <select name="drink">
                            <option value="soda">Soda</option>
                            <option value="beer">Beer</option>  
                            <option value="wine">Wine</option> 
                            <option value="shot">Shot</option> 
                        </select> 
                        
                        <br><br>
                        
                        <!-- Submit -->
                        <input id="submit" name="submit" type="submit" value="Place Order">
                        
                </form>
            </div>
        
        
    </body>
</html>
