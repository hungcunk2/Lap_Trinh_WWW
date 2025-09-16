<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07/09/2025
  Time: 9:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css"/>


</head>
<body>

<div>
    <form style="justify-content: center" action="registrationForm" method="post">

        <table>
            <tr>
                <td>
                    <input name="txtfname" placeholder="First name">
                </td>

                <td>
                    <input name="txtlname" placeholder="Last name">
                </td>
            </tr>


            <tr>
                <td colspan="2">
                    <input name="txtEmail" type="email" placeholder="Your Email">

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input name="txtReEmail" type="email" placeholder="Re-enter Email">

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <select name="day">
                        <option>Day</option>
                        <option>1</option>
                        <option>2</option>
                        <!-- Add more days -->
                    </select>
                    <select name="month">
                        <option>Month</option>
                        <option>January</option>
                        <option>February</option>
                        <!-- Add more months -->
                    </select>
                    <select name="year">
                        <option>Year</option>
                        <option>2024</option>
                        <option>2023</option>
                        <!-- Add more years -->
                    </select>

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input name="txtPw" type="password" placeholder="New password">

                </td>
            </tr>


            <tr>
                <td colspan="2">
                    <label><input type="radio" name="gender" value="male"> Male</label>
                    <label><input type="radio" name="gender" value="female"> Female</label>
                </td>
            </tr>

            <tr>
                <td>
                    <button type="submit" name="signup">Sign Up</button>
                </td>
            </tr>

        </table>





    </form>

    <h2>Danh sach User</h2>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Re-Email</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><c:out value="${user.reemail}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
