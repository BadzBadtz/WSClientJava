<%-- 
    Document   : PeoplePages
    Created on : Jun 7, 2017, 2:26:20 AM
    Author     : BadzBadtz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Naming" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>People Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/include/header.jsp"/>
        <form action="People" method="post" class="form-inline">
            <table>
                <tr>
                    <td>Department</td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="deptInfo" value="<%=session.getAttribute("dCode") %>" class="form-control"/></td>
                    <td><input type="text" value="<%=session.getAttribute("dName") %>" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Please Input Name</td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="peopleInfo" value="${param.peopleInfo}" class="form-control"/></td>
                    <td><input type="submit" class="btn btn-info"/></td>
                </tr>
            </table>
        </form>
        <br>
        <c:choose>
            <c:when test="${! empty empData}">
                <table class="table" style="width: 150px">
                    <tr align="center" style="width: 150px">
                        <td style="width:10px">ID</td>
                        <td style="width:140px">Name</td>
                    </tr>
                <c:forEach items="${empData}" var="emp">
                <tr align="left">
                    <td style="width:10px"><a href="<%=request.getContextPath()%>/Employee?empInfo=${emp.employeeID}" >${emp.employeeID}</a></td>
                    <td>${emp.fullName}</td>
                </tr>
                </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h3 style="color: red">${message}</h3>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
