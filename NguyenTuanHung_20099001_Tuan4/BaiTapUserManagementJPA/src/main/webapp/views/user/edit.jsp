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
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css"/>
</head>
<body>

<h1>
    User Management
</h1>


<h2>
    <a href="${pageContext.request.contextPath}/users?action=new">
        New User
    </a>
    <a href="${pageContext.request.contextPath}/users">
        List All Users
    </a>

    <h2>edit User</h2>

    <form action="${pageContext.request.contextPath}/users?action=update" method="post">
        <c:if test="${errors != null}">
            <c:if test="${errors != null}">
                <p style="color:red"
                >
                    <c:out value="${errors}" escapeXml="false">
                    </c:out>

                </p>
            </c:if>
        </c:if>
        <input type="hidden" name="id" value="${user.id}"/>
        <table>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" maxlength="50" size="50" value="<c:out value='${user.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" maxlength="50" size="50" value="<c:out value='${user.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" maxlength="20" size="15"
                           value="<c:out value='${user.country}' />"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>

</h2>

</body>
</html>
