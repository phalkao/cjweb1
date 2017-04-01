<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Usu&aacute;rio</title>
<script type="text/javascript">
	function confirmaExclusao(id){
		if(window.confirm("Tem certeza que deseja excluir o registro: "+id)){
			location.href="usucontroller.do?acao=exc&id="+id;
		}
	}
</script>
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
	<c:forEach items="${requestScope.lista}" var="usu">
		<tr>
			<td>${usu.id}</td> 
			<td>${usu.nome}</td> 
			<td>${usu.login}</td> 
			<td>${usu.senha}</td>
			<td>
				<a href="javascript:confirmaExclusao(${usu.id})"> Excluir </a>
				|
				<a href="usucontroller.do?acao=alt&id=${usu.id}"> Alterar </a>
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="5"><a href="usucontroller.do?acao=cad"> Incluir </a></td>
		</tr>
	</table>
</body>
</html> 