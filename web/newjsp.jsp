<%-- 
    Document   : newjsp
    Created on : Jun 3, 2017, 9:33:21 PM
    Author     : BadzBadtz
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WS Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Department" method="post" class="form-inline">
        <input type="text" name="deptInfo" 
                   value="${param.deptInfo}" class="form-control"/>
            <input type="submit" class="btn btn-info"/>
        </form>
        <br>
        <table class="table">
            <tr align="center">
                <td>DepartmentCode</td>
                <td>Level1</td>
                <td>Level2</td>
                <td>Level3</td>
                <td>Level4</td>
                <td>DepartmentEng</td>
            </tr>
            <%
                Iterator itr;
                List data = (List)request.getAttribute("result");
                if (data != null){
                for(itr=data.iterator();itr.hasNext();)
                {
            %>
            <tr>
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
            </tr>
            <% }} %>
        </table>
        
    </body>
</html>
