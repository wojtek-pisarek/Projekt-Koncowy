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
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/technologists.jsp" %>
<style> tr,th,td { border: 1px solid black;
    padding: 5px;
    text-align: center     ;
}
</style>
<table>
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
            <a href="<c:url value="/buyer/delete?id=${technologist.id}"/>">Delete Technologist</a>
            <a href="<c:url value="/buyer/update?id=${technologist.id}"/>">Update Technologist</a>
            <a href="<c:url value="/technologist/${technologist.id}/offer"/>">All Technologists Offer</a>
        </td>
        </c:forEach>
</table>
</body>
</html>
