<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation Page</title>
</head>
<body style="margin: 0; padding: 0;">
<style>
    .text-style-products {
        text-decoration: none;
        font: small-caps bold 20px sans-serif;
    }
    .container {
        text-align: center;
        background: aliceblue;
        margin: 1%;
        padding: 2%;
        border-radius: 5px;
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<div class="container , text-style-products">
    <h1>Your order was successful! Thank you for shopping with us.</h1>
    <h2>Order # ${cart.code} | ${cart.placedDate} | To : ${cart.addressDTO.street} ${cart.addressDTO.town} ${cart.addressDTO.zipCode} ${cart.addressDTO.region}</h2>
    <c:forEach items="${cart.cartEntries}" var="cartEntry">
        <h3>${cartEntry.entryNumber})${cartEntry.productDTO.name} x ${cartEntry.quantity}</h3>
    </c:forEach>
    <h2>TOTAL : ${cart.totalPrice}$</h2>
</div>
</body>
</html>
