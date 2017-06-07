<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<%! List<String> fer = Arrays.asList("Java", "Groovy", "PHP"); %>
<%--<% fer.add("Java"); %>--%>
<%--<% fer.add("Groovy"); %>--%>
<%--<% fer.add("PHP"); %>--%>

<%! List<String> zach = Arrays.asList("Java", "Ruby", "Python", "PHP"); %>
<%--<% zach.add("Java"); %>--%>
<%--<% zach.add("Ruby"); %>--%>
<%--<% zach.add("Python"); %>--%>
<%--<% zach.add("PHP"); %>--%>
<%! List<String> languages; %>

<c:if test="${param.username == 'fer'}">
    <% languages = fer; %>
</c:if>
<c:if test="${param.username == 'zach'}">
    <% languages = zach; %>
</c:if>

<% request.setAttribute("languages", languages); %>

<html>
<head>
    <title>Programming Languages</title>
</head>
<body>
<h1>These are the languages that ${param.username} knows: </h1>
<ul>
    <c:forEach var="language" items="${languages}">
        <li>${language}</li>
    </c:forEach>
</ul>
</body>
</html>
