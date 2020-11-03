<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 24.10.2020
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Painter</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/painters.jsp" %>
<h3>Are you sure you want to remove ${painter.email}? </h3>
<form:form method="post" modelAttribute="painter">
    <form:hidden path="id"/>
    <input type="submit" value="yes">
</form:form>
<form:form method="get" action="/painter/all">
    <input type="submit" value="no,return">
</form:form>
</body>
</html>
