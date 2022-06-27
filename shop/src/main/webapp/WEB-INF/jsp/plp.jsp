<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page>
    <jsp:body>
        <html>
        <head>
            <title>Product Landing Page</title>
        </head>
        <body>
        <div class="links-style , product-container">
            <c:forEach items="${products}" var="product">
                <div class="item-plp">
                    <a style="text-decoration: none" href="/product/${product.code}">(${product.code}) ${product.name}
                        = ${product.price}</a>

                    <form class="add-product-form" action="/cart/add">

                        <input type="text" name="productCode" hidden value="${product.code}"/>
                        <input type="number" name="quantity" hidden value="1"/>
                        <button class="add-button" name="addProductButton" type="submit"> Add to Cart</button>

                    </form>
                </div>
            </c:forEach>

            <c:if test="${empty products}"><p>Sorry , we don't have these products for now.</p></c:if>

            <a style="display: block;" href="/categories">
                <button class="go-back">Go back</button>
            </a>
        </div>

        </body>
        </html>
    </jsp:body>
</template:page>