<%-- 
    Document   : DeptNamePages
    Created on : Nov 21, 2017, 12:16:19 AM
    Author     : BadzBadtz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <jsp:include page="/include/header.jsp" />
        <form action="Dept" method="post" class="form-inline">
            <table>
                <tr>
                    <td>Please input Department Name</td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="text" name="deptInfo" value="${param.deptInfo}" class="form-control"/></td>
                    <td>&nbsp;</td>
                    <td><input type="submit" class="btn btn-info"/></td>
                </tr>
            </table>
        </form>
        <br>
        <c:choose>
            <c:when test="${! empty deptList}">
                <table class="table">
                    <tr align="center" style="width: 100px">
                        <td>ID</td>
                        <td>Name</td>
                    </tr>
                <c:forEach items="${deptList}" var="dept">
                <tr align="left" style="width: 100px">
                    <td><a href="<%=request.getContextPath() %>/FindDept?deptCode=${dept.departmentCode}&deptName=${dept.departmentName}">${dept.departmentCode}</a></td>
                    <td>${dept.departmentName}</td>
                </tr>
                </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </body>
</html>
