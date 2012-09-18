<%-- 
    Document   : orderConfirm
    Created on : Sep 2, 2012, 2:54:05 PM
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
        <h2>Order Complete!</h2>
        

       
        <%
        out.print("Thank you, " + request.getAttribute("fullname") + " for your order!<br>");
        out.println("We will call you at: " + request.getAttribute("phone") + " when your order is completed.");
        out.println("<br><br>");
        out.print("<br>Your main course: ");
        

        %>
            
        
    </body>
</html>
