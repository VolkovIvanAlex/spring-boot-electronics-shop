<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Product Landing Page</title>
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
        <a href="/products/product/${product.code}">${product.code} , ${product.name} , ${product.price}</a>
        <br>
        <br>
    </c:forEach>
    <c:if test="${empty products}"><p>Sorry , we don't have these products</p></c:if>

    <a href="/categories">
        <button>Go back</button>
    </a>
</div>
</body>
</html>
