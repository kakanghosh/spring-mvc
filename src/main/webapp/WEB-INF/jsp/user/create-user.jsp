<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ghosh
  Date: 2019-11-14
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user Form</title>
</head>
<body>
    <h2>User Form</h2>
    <form:form modelAttribute="user">
        <form:hidden path="id"/>
        <p>First Name <form:input path="firstName"/></p>
        <p>Last Name <form:input path="lastName"/></p>
        <p>
            Gender
            <form:radiobutton path="gender" value="male"/> Male
            <form:radiobutton path="gender" value="female"/> Female
        </p>
        <p>
            Foods
            <form:checkbox path="foods" value="Coffee"/> Coffee
            <form:checkbox path="foods" value="Tea"/> Tea
            <form:checkbox path="foods" value="Rice"/> Rice
        </p>
        <input type="submit" value="Add">
        <a href="/home">Cancel</a>
    </form:form>
</body>
</html>
