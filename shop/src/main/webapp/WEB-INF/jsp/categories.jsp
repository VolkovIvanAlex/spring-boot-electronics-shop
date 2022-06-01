<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<c:forEach items="${categories}" var="category">
    <a href="categories/id/${category.id}">${category.name} products : ${category.productsAmount}</a>
    <br>
    <br>
</c:forEach>
<a href="/">Go Back</a>
</body>
</html>
