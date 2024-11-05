<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

	<jsp:useBean id="pdao" scope="page" class="org.libertas.PessoaDao" />

	<a href="formulario.jsp?idpessoa=0">novo</a>
	<table class="table table-striped" width="100%">
		<th>Nome</th>
		<th>Telefone</th>
		<th>E-mail</th>
		<th>Cidade</th>
		<th></th>
		<c:forEach var='p' items='${pdao.listar()}'>
			<tr>
				<td>${p.nome}</td>
				<td>${p.telefone}</td>
				<td>${p.email}</td>
				<td>${p.cidade}</td>
				<td>
					<a href="formulario.jsp?idpessoa=${p.idpessoa}">alterar</a>
					<a href="excluir.jsp?idpessoa=${p.idpessoa}">excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>