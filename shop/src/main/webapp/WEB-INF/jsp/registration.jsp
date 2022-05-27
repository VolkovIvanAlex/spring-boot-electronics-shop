<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration page</title>
</head>
<body>
<div style="width:800px; margin:0 auto; text-align: center; background: orange ;border-radius: 5px; padding: 10px; margin-top: 150px">
    <form:form
            modelAttribute="customerDTO"
            cssStyle="align-self: center"
            action="/registration"
            method="post">
        <label>Enter login</label>
        <form:input path="login" type="email" required="true" placeholder="example@gmail.com"/>
        <form:errors path="login" cssStyle="background: indianred"/>
        <br>
        <br>
        <label>Enter Password</label>
        <form:input path="password" type="password" required="true"/>
        <br>
        <br>
        <label>Enter First Name (Only Letters)</label>
        <form:input path="firstName" type="text" placeholder="Ivan" required="true"/>
        <form:errors path="firstName" cssStyle="background: indianred"/>
        <br>
        <br>
        <label>Enter Last Name (Only Letters)</label>
        <form:input path="lastName" type="text" placeholder="Volkov" required="true"/>
        <form:errors path="lastName" cssStyle="background: indianred"/>
        <br>
        <br>
        <label>Select Gender</label>
        <form:select path="gender" name="gender" required="true">
            <option>Male</option>
            <option>Female</option>
            <option>Other</option>
        </form:select>
        <form:errors path="gender" cssStyle="background: indianred"/>
        <br>
        <br>
        <label>Enter Birthday in format "dd-MM-yyyy"</label>
        <form:input path="birthDay" type="text" required="true" placeholder="08-12-2002"/>
        <form:errors path="birthDay" cssStyle="background: indianred"/>
        <br>
        <br>
        <label>Enter phone (only 10 digits)</label>
        <form:input path="phone" type="number" required="true" placeholder="**********"/>
        <form:errors path="phone" cssStyle="background: indianred"/>
        <br>
        <br>
        <input type="submit" value="Sign Up">
    </form:form>
    <a href="/login"> Go Back </a>
</div>
</body>
</html>
