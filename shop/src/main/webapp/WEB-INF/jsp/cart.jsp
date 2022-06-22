<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Cart Page</title>
</head>
<body style="margin: 0; padding: 0;">
<style>
    .links-style {
        padding: 3px;
        border-radius: 5px;
        text-decoration: none;
        font: small-caps bold 20px sans-serif;
        margin: 30px;
    }

    .product-container {
        background: aliceblue;
    }

    .item {

    }

    .go-back {
        display: inline-block;
        background-color: #f4511e;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        margin: 4px 2px;
        opacity: 0.6;
        transition: 0.3s;
        text-decoration: none;
        cursor: pointer;
    }

    .go-back:hover {
        opacity: 1
    }

    .input {
        margin-right: 10px;
        padding: 8px;
        border: none;
        border-bottom: 1px solid #ccc;
    }

    .update {
        display: inline-block;
        background-color: #670025;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        margin: 4px 2px;
        opacity: 0.6;
        transition: 0.3s;
        text-decoration: none;
        cursor: pointer;
    }

    .remove-button {
        display: inline-block;
        background-color: #f4511e;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        margin: 4px 2px;
        opacity: 0.6;
        transition: 0.3s;
        text-decoration: none;
        cursor: pointer;
    }

    .place-order {
        display: inline-block;
        background-color: #669999;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        margin: 0px 35px;
        transition: 0.3s;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<div class="links-style , product-container">

    <c:if test="${not empty invalidQuantity}">
        <h2 style="display: inline-block;background: indianred;border-radius: 5px">${invalidQuantity}</h2>
    </c:if>
    <c:if test="${not empty cart.cartEntries}">
        <c:forEach items="${cart.cartEntries}" var="cartEntry" varStatus="counter">
            <div class="item">
                <h2 style="display: inline-block;">
                    #${cartEntry.entryNumber} :
                    <a style="text-decoration: none" href="/product/${cartEntry.productDTO.code}">
                        (${cartEntry.productDTO.code}) ${cartEntry.productDTO.name} (${cartEntry.productDTO.price}$)
                    </a>
                    <form:form
                            cssStyle="display: inline-block"
                            action="/cart/update"
                            method="post">
                        <input name="entryNumber" value="${cartEntry.entryNumber}" hidden>
                        <input class="input" type="number" name="productCode" value="${cartEntry.productDTO.code}"
                               hidden/>
                        <input class="input" type="number" name="quantity" value="${cartEntry.quantity}"/>
                        <button class="update" name="updateEntryButton" type="submit"> Update</button>
                    </form:form>
                    Total : ${cartEntry.totalPrice}$
                    <form:form
                            cssStyle="display: inline-block"
                            action="/cart/update"
                            method="post">
                        <input class="input" type="number" name="productCode" value="${cartEntry.productDTO.code}"
                               hidden/>
                        <input class="input" type="number" name="quantity" value="0" hidden/>
                        <button class="remove-button" name="removeEntryButton" type="submit"> Remove</button>
                    </form:form>
                </h2>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty cart.cartEntries}"><p>Seems like you haven't added any product to your cart.</p></c:if>

    <a style="display: block;" href="/">
        <button class="go-back">Go back</button>
    </a>
</div>
</body>
</html>
