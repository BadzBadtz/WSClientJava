<%-- 
    Document   : EmpResultPages
    Created on : Nov 20, 2017, 7:33:49 PM
    Author     : BadzBadtz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/include/header.jsp" />
    <c:choose>
        <c:when test="${! empty empList}">
            <table class="table">
                <tr align="center" style="width: 100px">
                    <td>ID</td>
                    <td>Title</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Employee Type</td>
                    <td>Position</td>
                    <td>Department</td>
                    <td>Email</td>
                    <td>Login</td>
                    <td>Card Number</td>
                    <td>Create</td>
                    <td>Expire</td>
                </tr>
            <c:forEach items="${empList}" var="el">
                    <tr align="left" style="width: 100px">
                        <td>${el.employeeID}</td>
                        <td>${el.titleShort}</td>
                        <td>${el.firstName}</td>
                        <td>${el.lastName}</td>
                        <td>${el.employeeTypeName}</td>
                        <td>${el.positionName}</td>
                        <td>${el.departmentName}</td>
                        <td>${el.email}</td>
                        <td>${el.loginName}</td>
                        <td>${el.cardNumber}</td>
                        <td>${el.createDate}</td>
                        <td>${el.expireDate}</td>
                    </tr>
                </table>
            </c:forEach>
        </c:when>
    </c:choose>
    </body>
</html>
