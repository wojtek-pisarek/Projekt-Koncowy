<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 13.09.2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wagon add</title>
</head>
<body>
<form:form method="post" modelAttribute="wagon">
    <form:label path="type">type:<form:input path="type"/></form:label>
    <form:errors path="type"/><br/>
    <input type="submit">
</form:form>
</body>
</html>
