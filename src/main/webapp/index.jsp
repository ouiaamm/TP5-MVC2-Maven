<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gestion Produits MVC2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-4">

    <!-- HEADER -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Gestion Produits</h2>

        <!-- LOGOUT (IMPORTANT FIX) -->
        <form action="auth" method="post">
            <input type="hidden" name="action" value="logout"/>
            <button class="btn btn-danger btn-sm">Logout</button>
        </form>
    </div>

    <!-- FORM -->
    <div class="card p-3 mb-4">

        <form action="controller" method="post">

            <input type="hidden" name="action"
                   value="${produitEdit != null ? 'update' : 'add'}"/>

            <input type="hidden" name="idProduit"
                   value="${produitEdit.idProduit}"/>

            <input type="text" class="form-control mb-2" name="nom"
                   value="${produitEdit.nom}" placeholder="Nom" required/>

            <input type="text" class="form-control mb-2" name="description"
                   value="${produitEdit.description}" placeholder="Description" required/>

            <input type="number" step="0.01" class="form-control mb-2" name="prix"
                   value="${produitEdit.prix}" placeholder="Prix" required/>

            <button class="btn btn-primary">
                ${produitEdit != null ? 'Modifier' : 'Ajouter'}
            </button>

        </form>

    </div>

    <!-- TABLE -->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th><th>Nom</th><th>Description</th><th>Prix</th><th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="p" items="${listeProduits}">
            <tr>
                <td>${p.idProduit}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.prix}</td>
                <td>
                    <c:if test="${sessionScope.role == 'ADMIN'}">
					    <a href="controller?action=edit&id=${p.idProduit}" class="btn btn-warning btn-sm">Edit</a>
					
					    <a href="controller?action=delete&id=${p.idProduit}" class="btn btn-danger btn-sm">
					        Delete
					    </a>
					</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>