<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 19.09.2020
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Designer</title>
</head>
<body>
<h3>Are you sure you want to remove ${designer.email}? </h3>
<form:form method="post" modelAttribute="designer">
    <form:hidden path="id"/>
    <input type="submit" value="yes">
</form:form>
<form:form method="get" action="/designer/all">
    <input type="submit" value="no,return">
</form:form>
</body>
</html>
