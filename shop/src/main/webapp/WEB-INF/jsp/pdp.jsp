<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Detail Page</title>
</head>
<body style="margin: 0; padding: 0;">
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
<jsp:include page="header/main_header.jsp"/>
<div class="links-style">
    <h1>${product.name}</h1>
    <h2>code : ${product.code}</h2>
    <h2>price : ${product.price}</h2>
    <h2>description : ${product.description}</h2>
    <a href="/products/${product.categoryDTO.code}">
        <button>Go back</button>
    </a>
</div>
</body>
</html>

