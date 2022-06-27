<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page>
    <jsp:body>
        <html>
        <head>
            <title>Categories</title>
        </head>
        <body>
        <div class="links-style">
            <c:forEach items="${categories}" var="category">
                <a style="text-decoration: none" href="/products/${category.code}">${category.name} products
                    : ${category.productsAmount}</a>
                <br>
                <br>
            </c:forEach>
            <a style="display: inline-block;" href="/">
                <button class="go-back">Go Back</button>
            </a>
        </div>
        </body>
        </html>
    </jsp:body>
</template:page>