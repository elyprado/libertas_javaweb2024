<%@page import="org.libertas.PessoaDao"%>
<%@page import="org.libertas.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//declare um objeto Pessoa
		Pessoa p = new Pessoa();
	
		//receba o parametro id e atribua no objeto pessoa o valor do idpessoa
		p.setIdpessoa( Integer.parseInt(request.getParameter("id")) );
		
		//declare o PessoaDao
		PessoaDao pdao = new PessoaDao();
		
		//execute o método excluir
		pdao.excluir(p);
		
		//adicione um link pra voltar para página lista.jsp
	%>
	
	Registro excluído com sucesso<br/>
	<a href="listar.jsp">ok</a>
	
</body>
</html>