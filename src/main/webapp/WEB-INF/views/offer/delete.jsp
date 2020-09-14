<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 13.09.2020
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete offer</title>
</head>
<body>
<h3>Are you sure you want to remove ${offer.rfq}? </h3>
<form:form method="post" modelAttribute="offer">
    <form:hidden path="id"/>
    <input type="submit" value="yes">
</form:form>
<form:form method="get" action="/offer/all">
    <input type="submit" value="no,return">
</form:form>
</body>
</html>
