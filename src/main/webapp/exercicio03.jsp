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
		double saldo = 1000;
		for (int i=0; i<60; i++) {
			saldo = saldo + (saldo * 0.7 / 100);
		}
		DecimalFormat df = new DecimalFormat("###,##0.00");
		out.print(df.format(saldo));
	
	%>

</body>
</html>