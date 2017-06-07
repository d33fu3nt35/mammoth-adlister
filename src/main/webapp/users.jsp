<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div class="container">
    <h1>Users Page</h1>
    <c:forEach var="user" items="${users}">
        <p>User's username: ${user.username}</p>
    </c:forEach>
</div>

</body>
</html>
