<%@page import="br.com.phalkao.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td colspan="5"><h2>Cadastro</h2></td>
		</tr>
		<tr bgcolor="#CCCCCC">
			<th>C&oacute;digo</th> 
			<th>Nome</th> 
			<th>Login</th> 
			<th>Senha</th> 
			<th>A&ccedil;&otilde;es</th>
		</tr>
<%
	List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
	
	for(Usuario usu: lista){
%>
		<tr>
			<td><%= usu.getId() %></td> 
			<td><%= usu.getNome() %></td> 
			<td><%= usu.getLogin() %></td> 
			<td><%= usu.getSenha() %></td>
			<td>
				<a href="usucontroller.do?acao=exc&id=<%= usu.getId() %>"> Excluir </a>
				|
				<a href="usucontroller.do?acao=alt&id=<%= usu.getId() %>"> Alterar </a>
			</td>
		</tr>

<%		 
	}
%>
		<tr>
			<td colspan="5"><a href="usucontroller.do?acao=cad"> Incluir </a></td>
		</tr>
	</table>
</body>
</html> 