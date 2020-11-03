<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 20.09.2020
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update designer</title>
    <%@include file="/WEB-INF/views/fragments/head_styles.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/fragments/designers.jsp" %>
<style> tr, td, table {
    border: 1px solid black;
    padding: 5px;
    text-align: right;
}
</style>
<form:form method="post" modelAttribute="designer">
    <table>
        <tr>
            <td><form:label path="name">name:<form:input path="name"/></form:label></td>
            <form:errors path="name"/>
        </tr>
        <tr>
            <td><form:label path="surname">surname:<form:input path="surname"/></form:label></td>
            <form:errors path="surname"/>
        </tr>
        <tr>
            <td><form:label path="email">mail:<form:input path="email"/></form:label></td>
            <form:errors path="email"/>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">phone number:<form:input path="phoneNumber"/></form:label></td>
            <form:errors path="phoneNumber"/>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
</html>
