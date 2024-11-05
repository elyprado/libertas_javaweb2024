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
		int h = Integer.parseInt(request.getParameter("home"));
		int m = Integer.parseInt(request.getParameter("muie"));
		int c = Integer.parseInt(request.getParameter("pivete"));
		
		double carne = ((h*300) + (m*270) + (c*250)) / 1000.0;
		double ceva = (h*2) + (m*1.5);
		double refri = (h*0.3) + (m*0.6) + (c*1);
		
		if (h>m) {
			response.sendRedirect("erro.jsp");
		}
	%>
	
	Quantidade de Carne: <%= carne %> Kg
	<br/>
	Quantidade de Cerveja: <%= ceva %> Litros
	<br/>
	Quantidade de Refrigerante: <%= refri %> Litros
	<br/>
</body>
</html>