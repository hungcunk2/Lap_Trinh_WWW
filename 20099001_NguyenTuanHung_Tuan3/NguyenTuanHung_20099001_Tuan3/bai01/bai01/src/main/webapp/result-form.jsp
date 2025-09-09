<%@ page import="com.example.bai01.Student" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/4/2025
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Form</title>
</head>
<body>

<%
    Student student = new Student();
    student = (Student) request.getAttribute("student");

    out.println(
            "First name: " + student.getFirstName()
            + "<br/> last name : " + student.getLastName()
            + "<br/> Email : " + student.getEmail()
            + "<br/> Gender : " + student.getGender()
            + "<br/> Birthday : " + student.getBirthday()
            
    );
%>
</body>
</html>
