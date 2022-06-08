<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration page</title>
</head>
<body style="margin: 0; padding: 0;">
<style>
    .registration {
        width: 50%;
        text-align: center;
        background: orange;
        border-radius: 5px;
        padding: 30px;
        position: absolute;
        top: 50%;
        left: 50%;
        font-family: "Trebuchet MS", Helvetica, sans-serif;
        font-size: 20px;
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }
</style>
<jsp:include page="header/main_header.jsp"/>
<div class="registration">
    <form:form
            modelAttribute="customerDTO"
            cssStyle="align-self: center"
            action="/registration"
            method="post">
        <label>Enter login</label>
        <form:input path="login" type="email" required="true" placeholder="example@gmail.com"/>
        <form:errors path="login" cssStyle="background: indianred;border-radius: 5px"/>
        <br>
        <br>
        <label>Enter Password</label>
        <form:input path="password" type="password" required="true"/>
        <br>
        <br>
        <label>Enter First Name (Only Letters)</label>
        <form:input path="firstName" type="text" placeholder="Ivan" required="true"/>
        <form:errors path="firstName" cssStyle="background: indianred;border-radius: 5px"/>
        <br>
        <br>
        <label>Enter Last Name (Only Letters)</label>
        <form:input path="lastName" type="text" placeholder="Volkov" required="true"/>
        <form:errors path="lastName" cssStyle="background: indianred;border-radius: 5px"/>
        <br>
        <br>
        <label>Select Gender</label>
        <form:select path="gender" name="gender">
            <c:forEach var="genderValue" items="${genderValues}">
                <form:option value="${genderValue}">${genderValue}</form:option>
            </c:forEach>
        </form:select>
        <form:errors path="gender" cssStyle="background: indianred;border-radius: 5px"/>
        <br>
        <br>
        <label>Enter Birthday in format "dd-MM-yyyy"</label>
        <form:input path="birthDay" type="text" required="true" placeholder="08-12-2002"/>
        <form:errors path="birthDay" cssStyle="background: indianred;border-radius: 5px"/>
        <br>
        <br>
        <label>Enter phone (only 10 digits)</label>
        <form:input path="phone" type="number" required="true" placeholder="**********"/>
        <form:errors path="phone" cssStyle="background: indianred;border-radius: 5px"/>
        <br>
        <br>
        <input type="submit" value="Sign Up">
    </form:form>
    <a href="/login">
        <button>Go Back</button>
    </a>
</div>
</body>
</html>
