<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" scope="page" class="org.libertas.Pessoa" />
	<jsp:useBean id="pdao" scope="page" class="org.libertas.PessoaDao"/>
 	<jsp:setProperty property="*" name="p"/>  
	<% pdao.salvar(p); %> 

	Registro salvo com sucesso
	<br/>
	<a href="index.jsp">OK</a>

</body>
</html>