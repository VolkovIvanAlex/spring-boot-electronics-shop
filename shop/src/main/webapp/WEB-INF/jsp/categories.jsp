<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories</title>
</head>
<body style="margin: 0; padding: 0;">
<jsp:include page="header/main_header.jsp"/>
<style>
    .links-style {
        padding: 3px;
        border-radius: 5px;
        text-decoration: none;
        background: aliceblue;
        font: small-caps bold 24px/1 sans-serif;
        margin: 30px;
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
</style>
<div class="links-style">
<c:forEach items="${categories}" var="category">
    <a href="/products/${category.code}">${category.name} products : ${category.productsAmount}</a>
    <br>
    <br>
</c:forEach>
    <a style="display: inline-block;" href="/">
        <button class="go-back">Go Back</button>
    </a>
</div>
</body>
</html>
