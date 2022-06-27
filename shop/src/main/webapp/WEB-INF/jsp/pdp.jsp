<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:page pageTitle="Product Detail Page">
    <div class="links-style">
        <c:if test="${not empty product}">
            <h1>${product.name}</h1>
            <h2>code : ${product.code}</h2>
            <h2>price : ${product.price}</h2>
            <h2>description : ${product.description}</h2>
            <a style="display: block; text-decoration: none" href="/products/${product.categoryDTO.code}">
                <button class="go-back">Go back</button>
            </a>
            <form class="add-product-form" action="/cart/add">

                <input type="text" name="productCode" hidden value="${product.code}"/>
                <input class="input-pdp" type="number" name="quantity" value="1"/>
                <button class="add-button" name="addProductButton" type="submit"> Add to Cart</button>

            </form>
        </c:if>
    </div>
</template:page>
