<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title></title>
</head>
<body>
    <c:forEach var="msgString" items="${messages}">
        <c:out value="${msg}"/><br>
    </c:forEach>
</body>
</html>