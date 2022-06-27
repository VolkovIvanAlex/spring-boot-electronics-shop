<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="address-container">
        <div class="links-style-products">
            <h2>${cart.customerDTO.firstName} ${cart.customerDTO.lastName} (${cart.customerDTO.phone})</h2>
            <form:form modelAttribute="addressDTO" action="/checkout/address" method="post">
                <label>Street : </label>
                <form:input cssClass="input-address" path="street" type="text"/>
                <form:errors cssClass="input-error" path="street"/>
                <br>
                <br>
                <label>Town : </label>
                <form:input cssClass="input-address" path="town" type="text"/>
                <form:errors cssClass="input-error" path="town"/>
                <br>
                <br>
                <label>Zip-Code : </label>
                <form:input cssClass="input-address" path="zipCode" type="text"/>
                <form:errors cssClass="input-error" path="zipCode"/>
                <br>
                <br>
                <label>Region : </label>
                <form:input cssClass="input-address" path="region" type="text"/>
                <form:errors cssClass="input-error" path="region"/>
                <br>
                <br>
                <label>Country : </label>
                <form:input cssClass="input-address" path="country" type="text"/>
                <form:errors cssClass="input-error" path="country"/>
                <br>
                <br>
                <button class="confirm-btn" type="submit">Confirm</button>
            </form:form>
        </div>
    </div>
</template:page>