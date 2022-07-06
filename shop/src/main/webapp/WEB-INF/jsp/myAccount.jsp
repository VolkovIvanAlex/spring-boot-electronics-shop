<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>
<template:page pageTitle="My Account">
    <div class="container , text-style-products">
        <h2>Login : ${customerDTO.login}</h2>
        <h3>First name : ${customerDTO.firstName}</h3>
        <h3>Last name :${customerDTO.lastName}</h3>
        <h2>Gender : ${customerDTO.gender}</h2>
        <fmt:parseDate value="${customerDTO.birthDay}" var="date" pattern="yyyy-MM-dd"/>
        <h2>Birth Date : <fmt:formatDate value="${date}" pattern="dd.MM.yyyy"/></h2>
        <h2>Phone : ${customerDTO.phone}</h2>
    </div>
</template:page>
