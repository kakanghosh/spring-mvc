<%--
  Created by IntelliJ IDEA.
  User: ghosh
  Date: 2019-11-14
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "jstl" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>User Info</h2>
    <p><a href="/users/create">Create User</a></p>
    <jstl:forEach begin="1" end="${totalPages}" varStatus="loop">
        <jstl:choose>
            <jstl:when test="${loop.current != currentPage}">
                <a href="/home?page=${loop.current}">${loop.current}</a>
            </jstl:when>
            <jstl:when test="${loop.current == currentPage}">
                <b><a href="javascript:void(0)">${loop.current}</a></b>
            </jstl:when>
        </jstl:choose>
    </jstl:forEach>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
        <tbody>
        <jstl:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.gender}</td>
                <td>
                    <a href="/users/${user.id}/edit">Edit</a>
                </td>
            </tr>
        </jstl:forEach>
        </tbody>
    </table>
    <jstl:forEach begin="1" end="${totalPages}" varStatus="loop">
        <jstl:choose>
            <jstl:when test="${loop.current != currentPage}">
                <a href="/home?page=${loop.current}">${loop.current}</a>
            </jstl:when>
            <jstl:when test="${loop.current == currentPage}">
                <b><a href="javascript:void(0)">${loop.current}</a></b>
            </jstl:when>
        </jstl:choose>
    </jstl:forEach>
</body>
</html>
