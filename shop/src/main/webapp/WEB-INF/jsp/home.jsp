<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
</head>
<body>
<jsp:include page="header/main_header.jsp"/>
<sec:authorize access="isAuthenticated()">
    <h1>Hi ,
        <sec:authentication property="principal.customer.firstName"/>
    </h1>
</sec:authorize>
<h1>Welcome to our shop !</h1>
</body>
</html>