<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
</head>
<body>
<header>
</header>
<h1>Welcome to our shop !</h1>

<sec:authorize access="isAuthenticated()">
    <h1>Hi ,
        <sec:authentication property="principal.firstName"/>
    </h1>
    <a href="/logout"> Log out </a>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <a href="/login">Log in</a>
</sec:authorize>

</body>
</html>