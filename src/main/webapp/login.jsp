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


    <h2 class="text-center mb-4 text-danger fw-bold display-5">Log in</h2>

    <form action="LoginServlet" method="post">

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

    <% if(request.getParameter("error") != null) { %>
        <p class="text-danger text-center mt-3">Invalid username or password</p>
    <% } %>

</div>

</div>

</body>
</html>
