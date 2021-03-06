<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 24.10.2020
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Technologist</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/technologists.jsp" %>
<h3>Are you sure you want to remove ${technologist.email}? </h3>
<form:form method="post" modelAttribute="technologist">
    <form:hidden path="id"/>
    <input type="submit" value="yes">
</form:form>
<form:form method="get" action="/technologist/all">
    <input type="submit" value="no,return">
</form:form>
</body>
</html>
