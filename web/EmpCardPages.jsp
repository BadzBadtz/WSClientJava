<%-- 
    Document   : EmpCardPages
    Created on : Jun 7, 2017, 1:33:23 AM
    Author     : BadzBadtz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Card Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/include/header.jsp"/>
        <form action="EmpCard" method="post" class="form-inline">
            <table>
                <tr>
                    <td>Please Input EmployeeID</td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="cardInfo" value="${param.cardInfo}" class="form-control"/></td>
                    <td>&nbsp;</td>
                    <td><input type="submit" class="btn btn-info"/></td>
                </tr>
            </table>
        </form>
        <br>
    <c:choose>
        <c:when test = "${! empty result}">
            <table class="table">
            <tr align="center">
                <td>EmployeeID</td>
                <td>TitleShortEng</td>
                <td>FirstName</td>
                <td>LastName</td>
                <td>CardNumber</td>
                <td>CreateDate</td>
                <td>ExpireDate</td>
                <td>RFID</td>
                <td>Proximity</td>
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
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
                <td><%=itr.next() %></td>
            </tr>
            <% }} %>
        </table>
        </c:when>
        <c:otherwise>
            <h3 style="color: red">${msg}</h3>
        </c:otherwise>
    </c:choose>
        
    </body>
</html>
