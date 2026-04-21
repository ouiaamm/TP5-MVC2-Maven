<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="d-flex justify-content-center align-items-center vh-100 bg-light">

<div class="card p-4" style="width: 350px;">

    <h3 class="text-center">Login</h3>

    <form action="auth" method="post">

        <input type="hidden" name="action" value="login"/>

        <input type="text" name="username" class="form-control mb-2" placeholder="Username" required>
        <input type="password" name="password" class="form-control mb-2" placeholder="Password" required>

        <button class="btn btn-primary w-100">Login</button>

    </form>

    <c:if test="${param.error != null}">
        <p class="text-danger text-center mt-2">Invalid login</p>
    </c:if>

</div>

</body>
</html>