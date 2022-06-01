<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Product Landing Page</title>
</head>
<body>
<jsp:include page="header/main_header.jsp"/>
<c:forEach items="${products}" var="product">
    <p>${product.code} , ${product.name} , ${product.price}</p>
    <br>
    <br>
</c:forEach>
<c:if test="${empty products}"><p>Sorry , we don't have these products</p></c:if>
<a href="/categories">Go back</a>
</body>
</html>
