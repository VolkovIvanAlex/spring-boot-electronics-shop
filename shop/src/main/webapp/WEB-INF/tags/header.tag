<%@ tag language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header style="background:   #8080ff;     height: 10%;">
    <div class="vertical-center">
        <a href="/" class="links-style">Home</a>
        <a href="/categories" class="links-style">Categories</a>
        <a href="/cart" class="links-style">Cart</a>
        <div style="float: right">
            <sec:authorize access="!isAuthenticated()">
                <a href="/login" class="links-style">Log in</a>
                <a class="links-style" href="/registration">Create Account</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="/logout" class="links-style">Log out </a>
                <h1 class="user-name">User : <sec:authentication
                        property="principal.customer.firstName"/></h1>
                <a class="links-style" href="/my-account">My Account</a>
            </sec:authorize>
        </div>
    </div>
</header>
