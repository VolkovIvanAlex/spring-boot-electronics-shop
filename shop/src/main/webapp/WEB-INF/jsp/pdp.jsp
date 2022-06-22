<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Product Detail Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajax_sendProductInfo.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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

    .form {
        display: flex;
        padding-top: 20px;
    }

    .input {
        margin-right: 10px;
        padding: 8px;
        display: block;
        border: none;
        border-bottom: 1px solid #ccc;
        width: 10%;
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

    .add-button {
        display: inline-block;
        padding: 11px 25px;
        font-size: 16px;
        cursor: pointer;
        text-align: center;
        text-decoration: none;
        outline: none;
        color: #fff;
        background-color: #4CAE7E;
        border: none;
        border-radius: 15px;
    }

    .add-button:hover {
        background-color: #3e8e41
    }

    .add-button:active {
        background-color: #3e8e41;
        box-shadow: 0 5px #666;
        transform: translateY(4px);
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<div class="links-style">
    <c:if test="${not empty product}">
        <h1>${product.name}</h1>
        <h2>code : ${product.code}</h2>
        <h2>price : ${product.price}</h2>
        <h2>description : ${product.description}</h2>
        <a style="display: block; text-decoration: none" href="/products/${product.categoryDTO.code}">
            <button class="go-back">Go back</button>
        </a>
        <form:form class="form" action="/cart/add">

            <input type="text" name="productCode" hidden value="${product.code}"/>
            <input class="input" type="number" name="quantity" value="1"/>
            <button class="add-button" name="addProductButton" type="submit"> Add to Cart</button>

        </form:form>
    </c:if>
</div>
</body>
</html>

