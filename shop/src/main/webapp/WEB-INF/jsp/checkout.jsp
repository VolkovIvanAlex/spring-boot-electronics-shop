<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page pageTitle="Checkout">
    <div class="links-style-products , product-container-checkout">
        <c:forEach items="${cart.cartEntries}" var="cartEntry" varStatus="counter">

            <div class="item">

                <h2 style="display: inline-block;">
                        ${cartEntry.entryNumber})
                    <a style="text-decoration: none" href="/product/${cartEntry.productDTO.code}">
                        #${cartEntry.productDTO.code} ${cartEntry.productDTO.name} X ${cartEntry.quantity}
                        (${cartEntry.totalPrice}$)
                    </a>
                </h2>
            </div>
        </c:forEach>
        <div style="padding: 15px;">
            <h1 style="display: inline-block">Total : ${cart.totalPrice}</h1>
            <a href="/cart">
                <button class="cart-btn">Cart</button>
            </a>
        </div>

    </div>
    <div class="right-container">
        <div class="links-style-products">

            <sec:authorize access="isAuthenticated()">
                <h2>${cart.customerDTO.firstName} ${cart.customerDTO.lastName} (${cart.customerDTO.phone})</h2>
            </sec:authorize>
            <form:form modelAttribute="checkoutDTO" action="/checkout/address" method="post">
                <sec:authorize access="!isAuthenticated()">
                    <br>
                    <label>First Name : </label>
                    <div>
                        <form:input cssClass="input-address" path="anonymousDTO.firstName" type="text"/>
                        <form:errors cssClass="input-error" path="anonymousDTO.firstName"/>
                    </div>
                    <label>Last Name : </label>
                    <div>
                        <form:input cssClass="input-address" path="anonymousDTO.lastName" type="text"/>
                        <form:errors cssClass="input-error" path="anonymousDTO.lastName"/>
                    </div>
                    <label>Email : </label>
                    <div>
                        <form:input cssClass="input-address" path="anonymousDTO.login" type="text"/>
                        <form:errors cssClass="input-error" path="anonymousDTO.login"/>
                    </div>
                    <label>Phone : </label>
                    <div>
                        <form:input cssClass="input-address" path="anonymousDTO.phone" type="text"/>
                        <form:errors cssClass="input-error" path="anonymousDTO.phone"/>
                    </div>
                    <br>
                </sec:authorize>
                <div class="address-container">
                    <label>Street : </label>
                    <div>
                        <form:input cssClass="input-address" path="addressDTO.street" type="text"/>
                        <form:errors cssClass="input-error" path="addressDTO.street"/>
                    </div>
                    <br>
                    <label>Town : </label>
                    <div>
                        <form:input cssClass="input-address" path="addressDTO.town" type="text"/>
                        <form:errors cssClass="input-error" path="addressDTO.town"/>
                    </div>
                    <br>
                    <label>Zip-Code : </label>
                    <div>
                        <form:input cssClass="input-address" path="addressDTO.zipCode" type="text"/>
                        <form:errors cssClass="input-error" path="addressDTO.zipCode"/>
                    </div>
                    <br>
                    <label>Region : </label>
                    <div>
                        <form:input cssClass="input-address" path="addressDTO.region" type="text"/>
                        <form:errors cssClass="input-error" path="addressDTO.region"/>
                    </div>
                    <br>
                    <label>Country : </label>
                    <div>
                        <form:input cssClass="input-address" path="addressDTO.country" type="text"/>
                        <form:errors cssClass="input-error" path="addressDTO.country"/>
                    </div>
                    <br>
                </div>
                <button class="confirm-btn" type="submit">Confirm</button>
            </form:form>
        </div>
    </div>
</template:page>