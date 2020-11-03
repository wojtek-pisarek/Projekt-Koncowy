<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 12.09.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Painters all</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<table>
    <%@include file="/WEB-INF/views/fragments/painters.jsp" %>
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
    <c:forEach items="${painters}" var="painter">
    <tr>
        <td>${painter.id}</td>
        <td>${painter.name}</td>
        <td>${painter.surname}</td>
        <td>${painter.email}</td>
        <td>${painter.phoneNumber}</td>
        <td>
            <a href="<c:url value="/painter/delete?id=${painter.id}"/>">Delete Painter</a>
            <a href="<c:url value="/painter/update?id=${painter.id}"/>">Update Painter</a>
            <a href="<c:url value="/painter/${painter.id}/offer"/>">all Painters offer</a>

        </td>
        </c:forEach>
</body>
</html>
