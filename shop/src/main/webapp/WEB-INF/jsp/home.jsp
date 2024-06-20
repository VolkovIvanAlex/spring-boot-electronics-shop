<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:page pageTitle="Home">
    <sec:authorize access="isAuthenticated()">
        <div class="greeting">
            <h1>Hello ,
                <sec:authentication property="principal.customer.firstName"/>
            </h1>
        </div>
    </sec:authorize>
    <h1 class="center title">Welcome to our shop !</h1>
</template:page>

