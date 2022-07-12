<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page pageTitle="My Orders">
    <div class="container , text-style-products">
        <template:pagination page="${orderPage}" pageLink="/my-orders">
            <h1 style="display: inline-block">Customer : ${customer.firstName} ${customer.lastName}</h1>
            <div>
                <h3 style="display: inline-block">Phone : ${customer.phone} | </h3>
                <h3 style="display: inline-block">Email : ${customer.login}</h3>
            </div>

            <form:form name="sizeForm" modelAttribute="orderPage" action="/my-orders" method="get">
                <label>Orders to show : </label>
                <form:select path="size" name="size" id="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                </form:select>
            </form:form>

            <c:forEach items="${orderPage.content}" var="order">
                <div class="order-container">
                    <h2>Order # : ${order.code}</h2>
                    <h3>To : ${order.addressDTO.street} ${order.addressDTO.town} ${order.addressDTO.zipCode}</h3>
                    <h3>Placed Date :<fmt:formatDate value="${order.placedDate}" pattern="dd.MM.yyyy"/></h3>
                    <h3>Total Price : ${order.totalPrice}</h3>
                </div>
            </c:forEach>

            <c:if test="${orderPage.totalPages <= 0}">
                <div class="alert-container">
                    <h1>You haven't got any orders yet.</h1>
                    <a href="/categories">
                        <button class="confirm-btn">Buy something.</button>
                    </a>
                </div>
            </c:if>
        </template:pagination>
    </div>

</template:page>
