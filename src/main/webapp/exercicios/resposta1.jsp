<%@page import="java.text.DecimalFormat"%>
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
		String desc = request.getParameter("descricao");
		int quant = Integer.parseInt(request.getParameter("quant"));
		double dolar = Double.parseDouble(request.getParameter("dolar"));
		
		double unitReais = dolar * 5.48;
		double totalReais = unitReais * quant;
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
	%>
	
	<table border="1">
		<tr>
			<td><b>Produto:</b></td><td><%= desc %></td>
		</tr>
		<tr>
			<td><b>Quantidade:</b></td><td><%= quant %></td>
		</tr>
		<tr>
			<td><b>Preço em Dólar:</b></td><td>$ <%= df.format(dolar) %></td>
		</tr>
		<tr>
			<td><b>Preço Unitário em Reais:</b></td><td>R$ <%= df.format(unitReais) %></td>
		</tr>
		<tr>
			<td><b>Preço Total em Reais:</b></td><td>R$ <%= df.format(totalReais) %></td>
		</tr>

	</table>
	
</body>
</html>