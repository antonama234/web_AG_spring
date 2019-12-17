<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete page</title>
</head>
<body>
    <div>
        <%
                out.println("<p>User "); %> ${user.name} ${user.surname} <% out.println(" is delete.</p>");
        %>
    </div>
    <form action="<spring:url value="/admin/allUsers"/>" method="get">
        <button type="submit">Back to main menu</button>
    </form>
</body>
</html>
