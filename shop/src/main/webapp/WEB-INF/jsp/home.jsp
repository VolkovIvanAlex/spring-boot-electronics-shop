<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
</head>
<body style="margin: 0; padding: 0;">
<style>
    .center {
        margin: 0;
        position: absolute;
        top: 50%;
        left: 50%;
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }

    .text-style {
        padding: 60px;
        border-radius: 5px;
        text-decoration: none;
        background: sandybrown;
        font: small-caps bold 24px/1 sans-serif;
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<sec:authorize access="isAuthenticated()">
    <h1>Hi ,
        <sec:authentication property="principal.customer.firstName"/>
    </h1>
</sec:authorize>
<h1 class="center text-style">Welcome to our shop !</h1>
</body>
</html>