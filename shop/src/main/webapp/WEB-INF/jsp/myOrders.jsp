<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<template:page pageTitle="My Orders">
    <div class="container , text-style-products">
        <h1 style="display: inline-block">Customer : ${customer.firstName} ${customer.lastName}</h1>
        <div>
            <h3 style="display: inline-block">Phone : ${customer.phone} | </h3>
            <h3 style="display: inline-block">Email : ${customer.login}</h3>
        </div>
        <c:forEach items="${orderPage.content}" var="order">
            <div class="order-container">
                <h2>Order # : ${order.code}</h2>
                <h3>To : ${order.addressDTO.street} ${order.addressDTO.town} ${order.addressDTO.zipCode}</h3>
                <h3>Placed Date :<fmt:formatDate value="${order.placedDate}" pattern="dd.MM.yyyy"/></h3>
                <h3>Total Price : ${order.totalPrice}</h3>
            </div>
        </c:forEach>
        <c:if test="${orderPage.totalPages > 0}">

            <c:forEach begin="0" varStatus="status" end="${orderPage.totalPages-1}">
                <a href="/my-orders/${status.index}">${status.count}</a>
            </c:forEach>
            <form action="/my-orders/${orderPage.number}" method="post">
                <select name="ordersToShow">
                    <option>5</option>
                    <option>10</option>
                    <option>15</option>
                </select>
                <input type="submit" value="Apply">
            </form>
        </c:if>
        <c:if test="${orderPage.totalPages <= 0}">
            <div class="alert-container">
                <h1>You haven't got any orders yet.</h1>
                <a href="/categories">
                    <button class="confirm-btn">Buy something.</button>
                </a>
            </div>
        </c:if>
    </div>
</template:page>
