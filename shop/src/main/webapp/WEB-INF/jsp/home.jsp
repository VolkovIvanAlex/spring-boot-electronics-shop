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
    <sec:authentication property="name"/>
    <a href="/logout"> Log out </a>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <a href="/login">Log in</a>
</sec:authorize>

</body>
</html>