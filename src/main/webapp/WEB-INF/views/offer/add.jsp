<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 09.09.2020
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="offer">
    <form:label path="rfq">rfq:<form:input path="rfq"/></form:label>
    <form:errors path="rfq"/><br/>
    <form:label path="date">leadTime:<form:input type="date" path="date" element="span"/></form:label>
    <form:errors path="date"/><br/>
    <form:label path="wagon">wagon<form:select path="wagon" items="${wagons}" itemValue="id"  itemLabel="type"/> </form:label>
    <form:errors path="wagon"/>
    <form:label path="designer">designer<form:select path="designer" items="${designers}" itemValue="id" itemLabel="email"/> </form:label>
    <form:errors path="designer"/>
    <form:label path="technologist">technologist<form:select path="technologist" items="${technologists}" itemValue="id" itemLabel="email"/> </form:label>
    <form:errors path="technologist"/>
    <form:label path="painter">painter<form:select path="painter" items="${painters}" itemValue="id" itemLabel="email"/> </form:label>
    <form:errors path="painter"/>
    <form:label path="buyer">buyer<form:select path="buyer" items="${buyers}" itemValue="id" itemLabel="email"/> </form:label>
    <form:errors path="buyer"/>
    <input type="submit">
</form:form>
</body>
</html>
