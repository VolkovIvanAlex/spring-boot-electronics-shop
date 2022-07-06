<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page pageTitle="No Auth">
    <div class="container , text-style-products">
        <h1>Looks like you're not logged in. </h1>
        <a href="/login" class="links-style"><button class="confirm-btn">Log in</button></a>
        <a href="/">
            <button class="go-back">Go home</button>
        </a>
    </div>
</template:page>
