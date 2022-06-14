<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Product Landing Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajax_sendProductInfo.js" type="text/javascript"></script>

</head>
<body style="margin: 0; padding: 0;">
<style>
    .links-style {
        padding: 3px;
        border-radius: 5px;
        text-decoration: none;
        background: aliceblue;
        font: small-caps bold 20px sans-serif;
        margin: 30px;
    }

    .product-container {
        isplay: block;
        text-align: center;
    }

    .item {
        width: 20%;
        height: 35%;
        display: inline-block;
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
        box-shadow: 0 9px #999;
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
<div class="links-style , product-container">
    <c:forEach items="${products}" var="product">
        <div class="item">
            <a href="/product/${product.code}">(${product.code}) ${product.name} = ${product.price}</a>

            <form action="/product/addToCart">

                <input type="text" name="productCode" hidden value="${product.code}"/>
                <input type="number" name="quantity" hidden value="1"/>
                <button class="add-button" name="addProductButton" type="submit"> Add to Cart</button>

            </form>
        </div>
    </c:forEach>

    <a style="display: block;" href="/categories">
        <button class="go-back">Go back</button>
    </a>


    <c:if test="${empty products}"><p>Sorry , we don't have these products for now.</p></c:if>
</div>

</body>
</html>
