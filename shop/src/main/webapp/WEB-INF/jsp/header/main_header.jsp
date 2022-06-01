<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header style="background: bisque">
    <a href="/categories" style="text-decoration: none; margin: 20px; background: aliceblue; font: small-caps bold 24px/1 sans-serif">Categories</a>
    <sec:authorize access="!isAuthenticated()">
        <a href="/login" style="text-decoration: none;margin: 20px; background: aliceblue; font: small-caps bold 24px/1 sans-serif">Log in</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    <a href="/logout"
       style="text-decoration: none;margin: 20px; background: aliceblue; font: small-caps bold 24px/1 sans-serif"> Log
        out </a>
    </sec:authorize>
</header>