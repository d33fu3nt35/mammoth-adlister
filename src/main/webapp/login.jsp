<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String username = "admin";
    String password = "password";
%>

<% request.setAttribute("username", username); %>
<% request.setAttribute("password", password); %>

<c:if test="${param.username == username && param.password == password}">
    <c:redirect url="profile.jsp">

    </c:redirect>
</c:if>

<html>
<head>
    <title><%= "- HOME -" %>
    </title>
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="card card-container">
    <form action="/login.jsp" method="POST" class="form-signin">
        <input type="username" id="inputUsername" name="username" class="form-control" placeholder="Username" required
               autofocus>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <div id="remember" class="checkbox">
        </div>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign In!</button>
    </form>
</div>
</body>
</html>