<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:page>
    <jsp:body>
        <html>
        <head>
            <title>Registration page</title>
        </head>
        <body>
        <div class="registration">
            <form:form
                    modelAttribute="customerDTO"
                    cssStyle="align-self: center"
                    action="/registration"
                    method="post">
                <label>Enter login</label>
                <form:input cssClass="input-registration" path="login" type="email" required="true"
                            placeholder="example@gmail.com"/>
                <form:errors path="login" cssStyle="background: #ff704d;border-radius: 5px"/>
                <br>
                <br>
                <label>Enter Password</label>
                <form:input cssClass="input-registration" path="password" type="password" required="true"/>
                <br>
                <br>
                <label>Enter First Name (Only Letters)</label>
                <form:input cssClass="input-registration" path="firstName" type="text" placeholder="Ivan"
                            required="true"/>
                <form:errors path="firstName" cssStyle="background: #ff704d;border-radius: 5px"/>
                <br>
                <br>
                <label>Enter Last Name (Only Letters)</label>
                <form:input cssClass="input-registration" path="lastName" type="text" placeholder="Volkov"
                            required="true"/>
                <form:errors path="lastName" cssStyle="background: #ff704d;border-radius: 5px"/>
                <br>
                <br>
                <label>Select Gender</label>
                <form:select cssClass="input-registration" path="gender" name="gender">
                    <c:forEach var="genderValue" items="${genderValues}">
                        <form:option value="${genderValue}">${genderValue}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="gender" cssStyle="background: #ff704d;border-radius: 5px"/>
                <br>
                <br>
                <label>Enter Birthday in format "dd-MM-yyyy"</label>
                <form:input cssClass="input-registration" path="birthDay" type="text" required="true"
                            placeholder="08-12-2002"/>
                <form:errors path="birthDay" cssStyle="background: #ff704d;border-radius: 5px"/>
                <br>
                <br>
                <label>Enter phone (only 10 digits)</label>
                <form:input cssClass="input-registration" path="phone" type="number" required="true"
                            placeholder="**********"/>
                <form:errors path="phone" cssStyle="background: #ff704d;border-radius: 5px"/>
                <br>
                <br>
                <input class="input-registration" type="submit" value="Sign Up">
            </form:form>
            <a href="/login">
                <button class="go-back">Go Back</button>
            </a>
        </div>
        </body>
        </html>
    </jsp:body>
</template:page>