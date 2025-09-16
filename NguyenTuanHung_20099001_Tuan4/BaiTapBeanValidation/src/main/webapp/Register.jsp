<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 15/09/2025
  Time: 2:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.fit.se.baitapbeanvalidation.entities.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${not empty errors}">
    <c:forEach var="err" items="${errors}">

        <p style="color: red">${err.message}</p>
    </c:forEach>


</c:if>


<form action="register" method="post">
    <table>
        <tr>


            <td>
                <lable> Name</lable>
            </td>

            <td><input type="text" name="name" value="${user.name}"/></td>


        </tr>


        <tr>

            <td>
                <lable>Email</lable>
            </td>
            <td><input type="email" name="email" value="${user.email}" /></td>


        </tr>


        <tr>

            <td>
                <lable> Country</lable>
            </td>

            <td><input type="text" name="country" value="${user.country}"/></td>


        </tr>

        <tr>

            <td><input type="submit" value="submit"/></td>


        </tr>


    </table>


</form>

</body>
</html>
