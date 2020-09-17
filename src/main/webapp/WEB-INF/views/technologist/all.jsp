<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Technologists all</title>
</head>
<body>
<table>
    <caption>Technologist List</caption>
    <thead>
    <th scope="col">id</th>
    <th scope="col">name</th>
    <th scope="col">surname</th>
    <th scope="col">email</th>
    <th scope="col">phoneNumber</th>
    </thead>
    <c:forEach items="${technologists}" var="technologist">
    <tr>
        <td>${technologist.id}</td>
        <td>${technologist.name}</td>
        <td>${technologist.surname}</td>
        <td>${technologist.email}</td>
        <td>${technologist.phoneNumber}</td>
        <td>
            <a href="<c:url value="/technologist/${technologist.id}/offer"/>">all technologists offer</a>

        </td>
        </c:forEach>
</table>
</body>
</html>
