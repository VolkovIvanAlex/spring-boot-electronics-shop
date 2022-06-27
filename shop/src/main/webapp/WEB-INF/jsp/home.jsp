<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page>
    <jsp:body>
        <html>
        <head>
            <title>Home page</title>
        </head>
        <body>
        <sec:authorize access="isAuthenticated()">
            <div class="greeting">
                <h1>Hello ,
                    <sec:authentication property="principal.customer.firstName"/>
                </h1>
            </div>
        </sec:authorize>
        <h1 class="center title">Welcome to our shop !</h1>
        </body>
        </html>
    </jsp:body>
</template:page>