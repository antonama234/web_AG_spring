<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users list</title>
</head>
<body>
    <h1>All users</h1>
    <div>
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Age</th>
            </tr>
            <c:forEach var="users" items="${requestScope.allUsers}">
                <tr>
                    <td>${users.name}</td>
                    <td>${users.surname}</td>
                    <td>${users.age}</td>
                    <td>
                        <form action="editUser" method="get">
                            <button name="id" value=${users.id}>Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="deleteUser" method="post">
                            <button name="id" value=${users.id}>Delete</button>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/user" method="get">
                            <button name="id" value=${users.id}>To user page</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="addUser" method="get">
        <button type="submit">Add new user</button>
    </form>
</body>
</html>
