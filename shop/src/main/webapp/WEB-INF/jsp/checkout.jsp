<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Checkout page</title>
</head>
<body style="margin: 0; padding: 0;">
<style>
    .links-style-products {
        text-decoration: none;
        font: small-caps bold 20px sans-serif;
    }

    .item {
        display: inline-block;
    }

    .product-container {
        display: inline-block;
        float: left;
        width: 47%;
        background: aliceblue;
        margin: 1%;
        border-radius: 5px;
    }

    .address-container {
        display: inline-block;
        background:   #b3fff0;
        margin-top: 1%;
        padding-left: 21px;
        width: 49%;
    }

    .cart-btn{
        display: inline-block;
        background-color: #6699C5;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        margin: 0px 35px;
        text-decoration: none;
        cursor: pointer;
    }

    .confirm-btn {
        display: inline-block;
        background-color: #6699C5;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        text-decoration: none;
        cursor: pointer;
    }

    .input {
        margin-right: 10px;
        padding: 8px;
        border: none;
        border-bottom: 1px solid #ccc;
        width: 50%;
    }

    .input-error{
        background: #ff704d;
        border-radius: 5px
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<div class="links-style-products , product-container">
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
    <div>
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
            <form:input cssClass="input" path="street" required="true" type="text"/>
            <form:errors cssClass="input-error" path="street"/>
            <br>
            <br>
            <label>Town : </label>
            <form:input cssClass="input" path="town" required="true" type="text"/>
            <form:errors cssClass="input-error" path="town"/>
            <br>
            <br>
            <label>Zip-Code : </label>
            <form:input cssClass="input" path="zipCode" required="true" type="text"/>
            <form:errors cssClass="input-error" path="zipCode"/>
            <br>
            <br>
            <label>Region : </label>
            <form:input cssClass="input" path="region" required="true" type="text"/>
            <form:errors cssClass="input-error" path="region"/>
            <br>
            <br>
            <label>Country : </label>
            <form:input cssClass="input" path="country" required="true" type="text"/>
            <form:errors cssClass="input-error" path="country"/>
            <br>
            <br>
            <button class="confirm-btn" type="submit">Confirm</button>
        </form:form>
    </div>
</div>
</body>
</html>
