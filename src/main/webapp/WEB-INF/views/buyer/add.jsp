<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 20.09.2020
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Buyer</title>
</head>
<body>
<form:form method="post" modelAttribute="buyer">
    <form:label path="name">name:<form:input path="name"/></form:label>
    <form:errors path="name"/><br/>
    <form:label path="surname">surname:<form:input path="surname"/></form:label>
    <form:errors path="surname"/><br/>
    <form:label path="email">mail:<form:input path="email"/></form:label>
    <form:errors path="email"/><br/>
    <form:label path="phoneNumber">phone number:<form:input path="phoneNumber"/></form:label>
    <form:errors path="phoneNumber"/><br/>
    <input type="submit">
</form:form>
</body>
</html>
