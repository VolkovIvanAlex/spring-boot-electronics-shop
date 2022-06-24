<%@ tag language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header style="background:  #ff9966; height: 50px">
    <div class="vertical-center">
        <a href="/" class="links-style">Home</a>
        <a href="/categories" class="links-style">Categories</a>
        <a href="/cart" class="links-style">Cart</a>
        <sec:authorize access="!isAuthenticated()">
            <a href="/login" class="links-style">Log in</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="/logout" class="links-style">Log out </a>
            <h1 class="user-name"> Logged-in User : <sec:authentication property="principal.customer.firstName"/></h1>
        </sec:authorize>
        <a class="links-style" href="/registration">Create Account</a>
    </div>
</header>
