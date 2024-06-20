<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page pageTitle="Confirmation Page">
    <div class="container , text-style-products">
        <h1>Your order was successful! Thank you , ${cart.customerDTO.firstName} ${cart.customerDTO.lastName} , for
            shopping with us.</h1>
        <h2>Order # ${cart.code} |
            <fmt:formatDate value="${cart.placedDate}" pattern="dd.MM.yyyy"/> | To :
                ${cart.addressDTO.street} ${cart.addressDTO.town} ${cart.addressDTO.zipCode} ${cart.addressDTO.region}</h2>
        <c:forEach items="${cart.cartEntries}" var="cartEntry">
            <h3>${cartEntry.entryNumber})${cartEntry.productDTO.name} x ${cartEntry.quantity}</h3>
        </c:forEach>
        <h2>TOTAL : ${cart.totalPrice}$</h2>
    </div>
</template:page>