<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 03.09.2020
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oferty Greenbrier Europe</title>
    <c:url value="/resources/main.css" var="maincss" />
    <link href="${maincss}" rel="stylesheet" />
<body>
<h1>Greenbrier Europe Offers</h1>
<a href="<c:url value="/offer/add"/>">offer add</a>
<a href="<c:url value="/offer/all"/>">offer all</a>
<a href="<c:url value="/designer/all"/>"> designer all</a>
<a href="<c:url value="/technologist/all"/>"> technologist all</a>
<a href="<c:url value="/painter/all"/>"> painter all</a>
<a href="<c:url value="/buyer/all"/>"> buyer all</a>
<a href="<c:url value="/wagon/all"/>"> wagon all</a>
<a href="<c:url value="/login"/>"> login</a>
<form method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<a href="<c:url value="/logout"/>"> logout</a>
<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
