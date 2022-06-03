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
</style>
<div class="links-style">
<c:forEach items="${categories}" var="category">
    <a href="/products/${category.code}">${category.name} products : ${category.productsAmount}</a>
    <br>
    <br>
</c:forEach>
    <a href="/">
        <button>Go Back</button>
    </a>
</div>
</body>
</html>
