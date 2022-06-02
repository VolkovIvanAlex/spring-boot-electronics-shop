<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<div style="width:400px; margin:0 auto; text-align: center; background: khaki ;border-radius: 5px; padding: 10px; margin-top: 150px">
<form:form
        action="/login"
        method="post">

    <label>Enter User Name</label>
    <input type="text" name="username">
    <br>
    <br>
    <label>Enter Password</label>
    <input type="password" name="password">
    <c:if test="${param.error != null}">
        <p style="background: indianred;border-radius: 5px; text-decoration-color: khaki">Invalid login or password.
            Please try again.</p>
    </c:if>
    <br>
    <br>
    <input type="submit" value="Login">
</form:form>
<a href="/"> Go Back. </a>
<label> Want to create account ? -> </label> <a href="/registration"> Create Account</a>
</div>
</body>
</html>