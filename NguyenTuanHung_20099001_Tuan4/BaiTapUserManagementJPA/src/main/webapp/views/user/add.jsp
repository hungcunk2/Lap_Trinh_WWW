<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/09/2025
  Time: 1:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css"/>
</head>
<body>
<div>
    <h1>User Management</h1>
    <h2>
        <%--          users lien ket o trang UserController--%>
        <a href="${pageContext.request.contextPath}/users?action=new">
            New User
        </a> &nbsp

        <a href="${pageContext.request.contextPath}/users">
            List All Users
        </a> &nbsp
    </h2>
    <h2>
        Add New User
    </h2>
    <form action="${pageContext.request.contextPath}/users?action=insert" method="post">
        <c:if test="${errors != null}">
            <p style="color: red">
                <c:out value="${errors}" escapeXml="false">
                </c:out>
            </p>

        </c:if>
        <table>

            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}'/>"
            </c:if>
            <tr>
                <th>
                    User Name
                </th>
                <td>
                    <input type="text" name="name" maxlength="50" size="50" value="<c:out value="${user.name}"/>"/>
                </td>
            </tr>
            <tr>
                <th>
                    User Email
                </th>
                <td>
                    <input type="text" name="email" maxlength="50" size="50" value="<c:out value="${user.email}"/>"/>
                </td>
            </tr>
            <tr>
                <th>
                    User Country:
                </th>
                <td>
                    <input type="text" name="country" maxlength="20" size="50"
                           value="<c:out value="${user.country}"/>"/>
                </td>

            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>

    </form>

</div>

</body>
</html>
