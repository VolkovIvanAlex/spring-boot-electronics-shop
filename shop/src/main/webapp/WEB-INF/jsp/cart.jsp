<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:master/>
<page:header/>
<page:footer/>
<html>
<head>
    <title>Cart Page</title>
</head>
<body>
<div class="links-style , product-container">

    <c:if test="${not empty invalidQuantity}">
        <h2 style="display: inline-block;background: indianred;border-radius: 5px">${invalidQuantity}</h2>
    </c:if>
    <c:if test="${not empty cart.cartEntries}">
        <c:forEach items="${cart.cartEntries}" var="cartEntry" varStatus="counter">
            <div>
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
        <div>
            <h1 style="display: inline-block">Cart total : ${cart.totalPrice}</h1>
            <a href="/checkout">
                <button class="place-order">Place order</button>
            </a>
        </div>
    </c:if>
    <c:if test="${empty cart.cartEntries}"><p>Seems like you haven't added any product to your cart.</p></c:if>

    <a style="display: block;" href="/">
        <button class="go-back">Go back</button>
    </a>
</div>
</body>
</html>
