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
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="tweet">
    <form:label path="title">title:<form:input path="title"/></form:label>
    <form:errors path="title"/><br/>
    <form:label path="tweetText">text:<form:textarea path="tweetText"/></form:label>
    <form:errors path="tweetText"/><br/>
    <form:label path="user"><form:select path="user" items="${users}" itemValue="id" itemLabel="email"/> </form:label>
    <form:errors path="user"/>
    <input type="submit">
</form:form>
</body>
</html>
