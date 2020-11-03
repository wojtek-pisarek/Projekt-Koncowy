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
    <title>Offer add</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/offers.jsp" %>
<style> tr, td, table {
    border: 1px solid black;
    padding: 5px;
    text-align: right;
}
</style>
<form:form method="post" modelAttribute="offer">
    <table>
        <tr>
            <td><form:label path="rfq">rfq:<form:input path="rfq"/></form:label></td>
            <form:errors path="rfq"/>
        </tr>
        <tr>
            <td><form:label path="date">leadTime:<form:input type="date" path="date" element="span"/></form:label></td>
            <form:errors path="date"/>
        </tr>
        <tr>
            <td><form:label path="wagon">wagon:<form:select path="wagon" items="${wagons}" itemValue="id"  itemLabel="type"/> </form:label></td>
            <form:errors path="wagon"/>
        </tr>
        <tr>
            <td><form:label path="designer">designer:<form:select path="designer" items="${designers}" itemValue="id" itemLabel="email"/> </form:label></td>
            <form:errors path="designer"/>
        </tr>
        <tr>
            <td><form:label path="technologist">technologist:<form:select path="technologist" items="${technologists}" itemValue="id" itemLabel="email"/> </form:label></td>
            <form:errors path="technologist"/>
        </tr>
        <tr>
            <td><form:label path="painter">painter:<form:select path="painter" items="${painters}" itemValue="id" itemLabel="email"/> </form:label></td>
            <form:errors path="painter"/>
        </tr>
        <tr>
            <td><form:label path="buyer">buyer:<form:select path="buyer" items="${buyers}" itemValue="id" itemLabel="email"/> </form:label></td>
            <form:errors path="buyer"/>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
</html>
