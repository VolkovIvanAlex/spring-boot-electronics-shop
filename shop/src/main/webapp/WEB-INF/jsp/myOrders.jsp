<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page pageTitle="My Orders">
    <div class="container , text-style-products">
        <h1 style="display: inline-block">Customer : ${orders.get(0).customerDTO.firstName} ${orders.get(0).customerDTO.lastName}</h1>
        <div>
        <h3 style="display: inline-block">Phone : ${orders.get(0).customerDTO.phone} | </h3>
        <h3 style="display: inline-block">Email : ${orders.get(0).customerDTO.login}</h3>
        </div>
        <c:forEach items="${orders}" var="order">
            <div class="order-container">
            <h2>Order # : ${order.code}</h2>
            <h3>To : ${order.addressDTO.street} ${order.addressDTO.town} ${order.addressDTO.zipCode}</h3>
            <h3>Placed Date :<fmt:formatDate value="${order.placedDate}" pattern="dd.MM.yyyy"/></h3>
            <h3>Total Price : ${order.totalPrice}</h3>
            </div>
        </c:forEach>
    </div>
</template:page>
