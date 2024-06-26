<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:page pageTitle="Login">
    <div class="login">
        <form:form
                action="/login"
                method="post">
            <div class="label-input">
                <input class="input-login" type="text" name="username" style="padding: 5px" placeholder="Login">
            </div>
            <div class="label-input">
                <input class="input-login" type="password" name="password" style="padding: 5px" placeholder="Password">
            </div>
            <c:if test="${param.error != null}">
                <span class="input-error">Invalid login or password. Please try again.</span>
            </c:if>
            <input class="login-btn" type="submit" value="Login">
        </form:form>
        <br>
        <div>
            <a href="/" style="text-decoration: none;">
                <button class="go-back">Go Back</button>
            </a>
            <a href="/registration">
                <button class="reg-btn">Create Account</button>
            </a>
        </div>
    </div>
</template:page>