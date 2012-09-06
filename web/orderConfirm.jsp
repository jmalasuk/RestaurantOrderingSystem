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
        out.println("Thank you for your order");
        out.print("<br>Your main course: ");
        out.println(request.getAttribute("main"));
        out.print("<br>Side Course: ");
        out.println(request.getAttribute("side"));
        out.print("<br>Drink:");
        out.println(request.getAttribute("drink"));
        %>
            
        
    </body>
</html>
