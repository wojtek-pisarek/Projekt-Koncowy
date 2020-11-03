<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 30.08.2020
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>All Offers</title>
<%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<table>
    <%@include file="/WEB-INF/views/fragments/offers.jsp" %>
    <style> tr,th,td { border: 1px solid black;
        padding: 5px;
        text-align: center     ;
    }
    </style>
    <thead>
    <th scope="col">id</th>
    <th scope="col">rfq</th>
    <th scope="col">leadTime</th>
    <th scope="col">wagon</th>
    <th scope="col">designer</th>
    <th scope="col">technologist</th>
    <th scope="col">technologistPainter</th>
    <th scope="col">specialistBuyer</th>
    </thead>
    <c:forEach items="${offers}" var="offer">
    <tr>
        <td>${offer.id}</td>
        <td>${offer.rfq}</td>
        <td>${offer.leadTime}</td>
        <td>${offer.wagon.type}</td>
        <td>${offer.designer.email}</td>
        <td>${offer.technologist.email}</td>
        <td>${offer.painter.email}</td>
        <td>${offer.buyer.email}</td>
        <td>
            <a href="<c:url value="/offer/update?id=${offer.id}"/>">update</a>
            <a href="<c:url value="/offer/delete?id=${offer.id}"/>">delete</a>
        </td>
        </c:forEach>
</table>
</body>
</html>
