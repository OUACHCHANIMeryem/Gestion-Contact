<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,modell.Categorie"%>


<!DOCTYPE html>

<!-- Jsp file is for register a new project -->

<html>

<head>
<title>Gestion des contacts</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body class="container jumbotron">
	<h1 class="text-center" ><img class="img-circle" src="add.jpg" height="100" width="100">Cr�er un nouveau contact!</h1>
	<br><br><br>
	<div>
	
	<!-- Form to add information in the new project -->
	
		<form class="col-lg-offset-3 col-sm-6" method="post"
			action="AddContact">
			<div class="form-group">
				<label class="control-label">Nom : </label> <input
					type="text" class="form-control" name="nom">
			</div>
			<div class="form-group">
				<label class="control-label">Pr�nom : </label> <input
					type="text" class="form-control" name="prenom">
			</div>
			<div class="form-group">
				<label class="control-label">N� de t�l�phone: </label> <input
					type="text" class="form-control" name="num_tel">
			</div>
			<div class="form-group">
				<label class="control-label">Type de t�l�phone : </label>
					<select name="type_tel" class="form-control">
					<option>Portable</option>
					<option>Fixe</option>
					<option>Autre</option>
					
					
					</select>
			</div>
				<div class="form-group">
				<label class="control-label">Cat�gorie : </label> 
					<select name="categorie" class="form-control">
						<%
								DAO.ContactDAO L1 = new DAO.ContactDAO ();
								List DATA = L1.ListCategorie();
								Iterator IT = DATA.listIterator();
								while (IT.hasNext()) {
									modell.Categorie L2 = (modell.Categorie) IT.next();
							%>
						<option value="<%=L2.getNom_categorie()%>"><%=L2.getNom_categorie()%></option>
						<%
								}
							%>
					</select>
			</div>
		
			<button class="pull-right btn btn-success glyphicon glyphicon-plus"> Cr�er</button>
		</form>
	</div>
	
</body>

</html>
