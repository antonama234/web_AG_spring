<%@ page import="ru.simpleCRUD.models.Role" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
    <div>
        <%
            out.println("<p>Welcome to your page " + request.getAttribute("user") + "!</p>");
        %>
        <form action="<spring:url value="/login"/>" method="get">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
