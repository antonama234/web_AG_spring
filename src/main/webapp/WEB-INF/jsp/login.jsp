<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main Page</title>
  </head>
  <body>
  <form action="<spring:url value="/login"/>" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><button type="submit" value="Sign In">Sign In</button></div>
  </form>
  <form action="<spring:url value="/registration"/>" method="get">
    <div><button type="submit" value="Registration">Registration</button></div>
  </form>
  </body>
</html>
