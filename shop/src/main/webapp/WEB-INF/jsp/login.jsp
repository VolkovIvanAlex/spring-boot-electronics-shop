<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body style="margin: 0; padding: 0;">
<style>
    .login {
        width: 50%;
        text-align: center;
        background: cornflowerblue;
        border-radius: 5px;
        padding: 30px;
        position: absolute;
        top: 30%;
        left: 50%;
        font-family: "Trebuchet MS", Helvetica, sans-serif;
        font-size: 30px;
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -30%);
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<div class="login">
    <form:form
            action="/login"
            method="post">

        <label>Enter User Name</label>
        <input type="text" name="username" style="padding: 5px">
        <br>
        <br>
        <label>Enter Password</label>
        <input type="password" name="password" style="padding: 5px">
        <c:if test="${param.error != null}">
            <p style="background: indianred;border-radius: 5px; color: white">Invalid login or password. Please try
                again.</p>
        </c:if>
        <input type="submit" value="Login">
    </form:form>
    <br>
    <br>
    <a href="/">
        <button>Go Back</button>
    </a>
    <label> Want to create account ? -> </label>
    <a href="/registration">
        <button>Create Account</button>
    </a>
</div>
</body>
</html>