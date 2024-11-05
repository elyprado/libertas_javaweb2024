<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
	.margem {
		margin: 20px;
	}
</style>

</head>
<body>

	<div class="margem">

	<jsp:useBean id="p" class="org.libertas.Pessoa" scope="page"/>
	<jsp:useBean id="pdao" class="org.libertas.PessoaDao" scope="page" />
	<jsp:setProperty property="*" name="p"/>
	${p = pdao.consultar(p.idpessoa)}

	<form action="gravar.jsp" method="post">
		<input  class="form-control"  type="hidden" name="idpessoa" value="${p.idpessoa}"/>
		Nome:
		<input  class="form-control"  type="text" name="nome" value="${p.nome}"/>
		<br/>
		Telefone:
		<input  class="form-control"  type="text" name="telefone" value="${p.telefone}"/>
		<br/>
		E-mail:
		<input  class="form-control"  type="text" name="email" value="${p.email}"/>
		<br/>
		Cidade:
		<input  class="form-control"  type="text" name="cidade" value="${p.cidade}"/>
		<br/>
		<input class="btn btn-primary" type="submit" value="salvar"/>
	</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>