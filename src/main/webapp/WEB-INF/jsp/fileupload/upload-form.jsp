<%--
  Created by IntelliJ IDEA.
  User: Kakan Ghosh
  Date: 11/16/2019
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Image File Upload</title>
</head>
<body>
<h1>File Upload Example - JavaTpoint</h1>

<h3 style="color:red">${filesuccess}</h3>
<form:form method="post" enctype="multipart/form-data">
    <p><label for="fileToUpload">Choose Image</label></p>
    <p><input name="file" id="fileToUpload" type="file" /></p>
    <p><input type="submit" value="Upload"></p>
</form:form>
</body>
</html>