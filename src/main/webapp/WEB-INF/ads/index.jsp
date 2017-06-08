<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 6/7/17
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ads" />
    </jsp:include>
</head>

<body>
<jsp:include page="../partials/navbar.jsp" />

<div class="container">
<h1>Here are all the ads!</h1>
<h2>Hello, ${sessionScope.get("username")}</h2>

<c:forEach var="ad" items="${ads}">
<h1>${ad.title}</h1>
    <p>${ad.description}</p>
</c:forEach>
</div>

</body>
</html>
