<%-- 
    Document   : index
    Created on : Jun 8, 2021, 8:32:55 PM
    Author     : Jainy
--%>

<%@page import="my.helpers.DisplayProductData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <%
            DisplayProductData pd1 = new DisplayProductData();
        %>
        <%=pd1.getData()%>
        <br><br>
        <div class="w3-container w3-teal">
            <h2>Input Form</h2>
        </div>
        <form class="w3-container w3-card-4" action="ProductDisplay">
            <br>
            <p>      
                <label class="w3-text-grey">Product No</label>
                <input class="w3-input w3-border" type="text" name="pno" required>
            </p>
            <p>      
                <label class="w3-text-grey">Product Name</label>
                <input class="w3-input w3-border" type="text" name="pname" required>
            </p>
            <p>      
                <label class="w3-text-grey">Type</label>
                <textarea class="w3-input w3-border" type="text" name="type" required></textarea>
            </p>
                        <p>      
                <label class="w3-text-grey">Manufacturer</label>
                <input class="w3-input w3-border" type="text" name="manufacturer" required>
            </p>
                        <p>      
                <label class="w3-text-grey">Price</label>
                <input class="w3-input w3-border" type="text" name="price" required>
            </p>
                        <p>      
                <label class="w3-text-grey">Weight</label>
                <input class="w3-input w3-border" type="text" name="weight" required>
            </p>
            <br>
           
            <p><button class="w3-btn w3-padding w3-teal" type="submit" name="update" style="width:120px">Update</button>
                <button class="w3-btn w3-padding w3-teal" type="submit" name="delete" style="width:120px">Delete</button></p>
        </form>
    </body>
</html>
