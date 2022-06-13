<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Product Landing Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/ajax_sendProductInfo.js"></script>
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
    <c:forEach items="${products}" var="product">
        <a href="/product/${product.code}">${product.code} , ${product.name} , ${product.price}</a>
        <form action="/products/addToCart" name="productForm" method="POST">
            <input type="text" name="productCode" hidden value="${product.code}"/>
            <input type="number" name="quantity" hidden value="1"/>
            <input type="text" name="pageName" hidden value="plp"/>
            <button name="addProductButton" type="submit"> Add to Cart</button>
        </form>
        <br>
    </c:forEach>
    <c:if test="${empty products}"><p>Sorry , we don't have these products for now.</p></c:if>
    <a href="/categories">
        <button>Go back</button>
    </a>
</div>
</body>
</html>
