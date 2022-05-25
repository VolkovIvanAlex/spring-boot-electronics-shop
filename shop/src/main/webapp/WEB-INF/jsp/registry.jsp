<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registry page</title>
</head>
<body>
<div style="width:800px; margin:0 auto;background: aqua; text-align: center">
    <form:form
            cssStyle="align-self: center"
            action="/registry"
            method="post">
        <label>Enter login</label>
        <input type="email" name="login" required placeholder="example@gmail.com">
        <c:if test="${not empty userAlreadyExistsException}">
            <br>
            <br>
            <div style="background: red">Error: ${userAlreadyExistsException}</div>

        </c:if>
        <c:if test="${not empty invalidEmailException}">
            <br>
            <br>
            <div style="background: red">Error: ${invalidEmailException}</div>
        </c:if>
        <br>
        <br>
        <label>Enter Password</label>
        <input type="password" name="password" required>
        <br>
        <br>
        <label>Enter First Name (Only Letters)</label>
        <input type="text" name="firstName" pattern="[a-zA-Z'-'\s]*" placeholder="Ivan" required>
        <br>
        <br>
        <label>Enter Last Name (Only Letters)</label>
        <input type="text" name="lastName" pattern="[a-zA-Z'-'\s]*" placeholder="Volkov" required>
        <c:if test="${not empty invalidInitialsException}">
            <br>
            <br>
            <div style="background: red">Error: ${invalidInitialsException}</div>
        </c:if>
        <br>
        <br>
        <label>Select Gender</label>
        <select name="gender" required>
            <option>Male</option>
            <option>Female</option>
            <option>Other</option>
        </select>
        <c:if test="${not empty unknownGenderException}">
            <br>
            <br>
            <div style="background: red">Error: ${unknownGenderException}</div>
        </c:if>
        <br>
        <br>
        <label>Enter Birthday in format "dd-MM-yyyy"</label>
        <input type="text" name="birthDay" required placeholder="08-12-2002">
        <c:if test="${not empty invalidDateFormat}">
            <br>
            <br>
            <div style="background: red">Error: ${invalidDateFormat}</div>
        </c:if>
        <br>
        <br>
        <label>Enter phone (only 10 digits)</label>
        <input type="number" name="phone" pattern=".{10}" required placeholder="**********">
        <c:if test="${not empty invalidPhoneException}">
            <br>
            <br>
            <div style="background: red">Error: ${invalidPhoneException}</div>
        </c:if>
        <br>
        <br>
        <input type="submit" value="Sign Up">
    </form:form>
    <a href="/login"> Go Back </a>
</div>
</body>
</html>
