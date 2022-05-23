<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<form:form
        action="/login"
        method="post">
    <c:if test="${param.error != null}">
        <p>Invalid login or password. Please try again.</p>
    </c:if>
    <label>Enter User Name</label>
    <input type="text" name="username">
    <br>
    <br>
    <label>Enter Password</label>
    <input type="password" name="password">
    <br>
    <br>
    <input type="submit" value="Login">
</form:form>
<label>Want to create account ? -> </label><a href="/registry"> Create Account</a>
</body>
</html>