<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:page pageTitle="Product Landing Page">
    <div class="links-style , container">

        <c:if test="${productsPage.totalPages > 0}">

            <form:form name="sizeForm" modelAttribute="productsPage" action="/products/${categoryCode}" method="get">
                <label>Products to show : </label>
                <form:select path="size" name="size" id="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                </form:select>
            </form:form>
        </c:if>

        <c:forEach items="${productsPage.content}" var="product">
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

        <c:if test="${productsPage.totalPages > 0}">

            <div>
                <label>Page : </label>
                <c:forEach begin="1" varStatus="status" end="${productsPage.totalPages}">
                    <a style="text-decoration: none"
                       class="${productsPage.number+1 eq status.count ? 'alert-container' : ''}"
                       href="/products/${categoryCode}/?page=${status.index}&size=${productsPage.size}">${status.count}
                    </a>
                </c:forEach>
            </div>
        </c:if>

        <c:if test="${productsPage.totalPages <= 0}"><p>Sorry , we don't have these products for now.</p></c:if>

        <a style="display: block; margin-bottom: 5%;" href="/categories">
            <button class="go-back">Go back</button>
        </a>
    </div>
</template:page>