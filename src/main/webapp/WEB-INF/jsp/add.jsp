<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user page</title>
</head>
<body>
    <div>
        <h1>Please enter parameters</h1>
    </div>
    <div>
        <form action="<spring:url value="/admin/addUser"/>" method="post">
            <table>
                <tr>
                    <td>Login:</td>
                    <td>Password:</td>
                    <td>Name:</td>
                    <td>Surname:</td>
                    <td>Age:</td>
                </tr>
                <tr>
                    <td><input type="text" name="login" required></td>
                    <td><input type="text" name="password" required></td>
                    <td><input type="text" name="name" required></td>
                    <td><input type="text" name="surname" required></td>
                    <td><input type="number" name="age" required></td>
                    <td><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        <form action="<spring:url value="/admin/allUser"/>" method="get">
            <button type="submit">Back to main menu</button>
        </form>
    </div>
</body>
</html>
