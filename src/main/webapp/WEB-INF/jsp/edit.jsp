<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit page</title>
</head>
    <body>
        <h2>Enter new parameters:</h2>
        <form action="<spring:url value="/admin/editUser"/>" method="post">
            <table>
                <tr>
                    <td>Login:</td>
                    <td>Password:</td>
                    <td>Name:</td>
                    <td>Surname:</td>
                    <td>Age:</td>
                </tr>
                <tr>
                    <td><input type="text" name="login" value="${user.login}" required></td>
                    <td><input type="text" name="password"></td>
                    <td><input type="text" name="name" value="${user.name}" required></td>
                    <td><input type="text" name="surname" value="${user.surname}" required></td>
                    <td><input type="number" name="age" value="${user.age}" required></td>
                    <td><button type="submit">Submit</button>
                        <input type="hidden" name="id" value="${user.id}"></td>
                </tr>
            </table>
        </form>
        <form action="<spring:url value="/admin/allUsers"/>" method="get">
            <button type="submit">Back to main menu</button>
        </form>
    </body>
</html>
