<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gestion des Produits MVC1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-4">
	<div class="d-flex justify-content-between align-items-center mb-4">
	    <h2 class="text-primary">Gestion des Produits (MVC1)</h2>
	    <a href="LogoutServlet" class="btn btn-outline-danger btn-sm">Logout</a>
	</div>
	
	<div class="card p-3 mb-4 shadow-sm">
	    <form action="${produitEdit != null ? 'UpdateProduitServlet' : 'AddProduitServlet'}" method="post">
	
	        <input type="hidden" name="idProduit" value="${produitEdit.idProduit}" />
	
	        <div class="mb-2">
	            <input type="text" class="form-control" name="nom" placeholder="Nom"
	                   value="${produitEdit.nom}" required />
	        </div>
	
	        <div class="mb-2">
	            <input type="text" class="form-control" name="description" placeholder="Description"
	                   value="${produitEdit.description}" required />
	        </div>
	
	        <div class="mb-2">
	            <input type="text" class="form-control" name="prix" placeholder="Prix"
	                   value="${produitEdit.prix}" required />
	        </div>
	
	        <button type="submit" class="btn btn-primary">
	            ${produitEdit != null ? 'Modifier' : 'Ajouter'}
	        </button>
	
	    </form>
	</div>
	
	<div class="card p-3 mb-4 shadow-sm">
	    <form action="ListProduitServlet" method="get" class="d-flex gap-2">
	        <input type="text" class="form-control" name="idProduit" placeholder="Rechercher par ID" />
	        <button type="submit" class="btn btn-secondary">Rechercher</button>
	    </form>
	</div>
	
	<div class="card p-3 shadow-sm">
	    <table class="table table-bordered table-hover">
	        <thead class="table-light">
	        <tr>
	            <th>ID</th>
	            <th>Nom</th>
	            <th>Description</th>
	            <th>Prix</th>
	            <th>Actions</th>
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
	                    <a href="EditProduitServlet?id=${p.idProduit}" class="btn btn-sm btn-warning">Modifier</a>
	                    <a href="DeleteProduitServlet?id=${p.idProduit}"
	                       class="btn btn-sm btn-danger"
	                       onclick="return confirm('Voulez-vous vraiment supprimer ce produit ?');">
	                        Supprimer
	                    </a>
	                </td>
	            </tr>
	        </c:forEach>
	        </tbody>
	
	    </table>
	</div>

</div>

</body>
</html>
