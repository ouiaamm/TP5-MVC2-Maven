<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="d-flex justify-content-center align-items-center vh-100 bg-light">

<div class="container" style="max-width:500px;">
    <div class="border border-secondary rounded bg-white p-4 shadow-sm">

        <h2 class="text-center mb-4 text-primary fw-bold">Log in</h2>

        <!-- MVC2 STYLE (controller-based login) -->
        <form action="controller" method="post">

            <!-- ACTION for controller -->
            <input type="hidden" name="action" value="login"/>

            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" class="form-control" name="username" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" class="form-control" name="password" required>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>

        </form>

        <!-- ERROR MESSAGE -->
        <c:if test="${param.error != null}">
            <p class="text-danger text-center mt-3">
                Invalid username or password
            </p>
        </c:if>

    </div>
</div>

</body>
</html>