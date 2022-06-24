<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 404</title>
</head>
<body>
<style>
    .container {
        text-align: center;
        background: aliceblue;
        margin: 1%;
        padding: 2%;
        border-radius: 5px;
    }

    .text-style-products {
        text-decoration: none;
        font: small-caps bold 20px sans-serif;
    }

    .go-back {
        display: inline-block;
        background-color: #f4511e;
        border: none;
        color: white;
        padding: 16px 32px;
        text-align: center;
        font-size: 16px;
        margin: 4px 2px;
        opacity: 0.6;
        transition: 0.3s;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<div class="container , text-style-products">
    <h1>Sorry , looks like this page does not found. </h1>
    <a href="/">
        <button class="go-back">Go home</button>
    </a>
</div>

</body>
</html>
