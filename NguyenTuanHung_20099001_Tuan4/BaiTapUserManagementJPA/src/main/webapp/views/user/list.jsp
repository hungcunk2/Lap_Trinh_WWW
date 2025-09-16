<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/09/2025
  Time: 1:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css"/>
</head>
<body>
<div>
    <h1>User Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/users?action=new">Add New User</a>
        <a href="${pageContext.request.contextPath}/users">List All Users</a>
    </h2>
    <h2>List Users</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>

<%--        lay thong qua setactribute ben trang UserController--%>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/users?action=edit&id=<c:out value='${user.id}' />">Edit</a>
                    <a href="${pageContext.request.contextPath}/users?action=delete&id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
