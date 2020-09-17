<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Buyers all</title>
</head>
<body>
<table>
    <caption>Buyers List</caption>
    <thead>
    <th scope="col">id</th>
    <th scope="col">name</th>
    <th scope="col">surname</th>
    <th scope="col">email</th>
    <th scope="col">phoneNumber</th>
    </thead>
    <c:forEach items="${buyers}" var="buyer">
    <tr>
        <td>${buyer.id}</td>
        <td>${buyer.name}</td>
        <td>${buyer.surname}</td>
        <td>${buyer.email}</td>
        <td>${buyer.phoneNumber}</td>
        <td>
            <a href="<c:url value="/buyer/${buyer.id}/offer"/>">all buyers offer</a>

        </td>
        </c:forEach>
</table>
</body>
</html>
