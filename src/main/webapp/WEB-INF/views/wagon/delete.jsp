<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 03.11.2020
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Wagon</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/wagons.jsp" %>
<h3>Are you sure you want to remove ${wagon.type}? </h3>
<form:form method="post" modelAttribute="wagon">
    <form:hidden path="id"/>
    <input type="submit" value="yes">
</form:form>
<form:form method="get" action="/wagon/all">
    <input type="submit" value="no,return">
</form:form>
</body>
</html>
