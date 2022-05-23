<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registry page</title>
</head>
<body>
<%--display errors--%>
<form:form
        action="/registry"
        method="post">
    <label>Enter login</label>
    <input type="email" name="login" required placeholder="example@gmail.com">
    <br>
    <br>
    <label>Enter Password</label>
    <input type="password" name="password" required>
    <br>
    <br>
    <label>Enter First Name (Only Letters)</label>
    <input type="text" name="firstName" required placeholder="Ivan">
    <br>
    <br>
    <label>Enter Last Name  (Only Letters)</label>
    <input type="text" name="lastName" required placeholder="Volkov">
    <br>
    <br>
    <label>Select Gender</label>
    <select name="gender" required>
        <option>Male</option>
        <option>Female</option>
        <option>Other</option>
    </select>
    <br>
    <br>
    <label>Enter Birthday in format "dd-MM-yyyy"</label>
    <input type="date" name="birthDay" required placeholder="08-12-2002">
    <br>
    <br>
    <label>Enter phone (only 10 digits)</label>
    <input type="number" name="phone" required placeholder="**********">
    <br>
    <br>
    <input type="submit" value="Sign Up">
</form:form>
<c:if test="${pageContext.exception != null}">
    <p>${pageContext.exception.message}</p>
</c:if>
</body>
</html>
