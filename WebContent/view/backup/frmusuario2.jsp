<!DOCTYPE html>
<%@page import="br.com.phalkao.entidades.Usuario"%>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usu&aacute;rio</title>
</head>
<body>
<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
	<div id="div" align="center" >
		<form action="usucontroller.do?acao=lis" method="post">
			<table>
				<thead>Cadastro</thead>
				<tbody>
					<tr>
						<td><label>C&oacute;digo:</label></td>
						<td><input type="text" name="txtid" readonly="true" value="<%= usuario.getId() %>" placeholder="C&oacute;digo do Usuário" min="0" /></td>
					</tr>
					<tr>
						<td><label>Nome:</label></td>
						<td><input type="text" name="txtnome" value="<%= usuario.getNome() %>" placeholder="Digite o nome" required size="30" /></td>
					</tr>
					<tr>
						<td><label>Login:</label></td>
						<td><input type="text" name="txtlogin" value="<%= usuario.getLogin() %>" placeholder="Nome de usuário ou email" required size="30" /></td>
					</tr>
					<tr>
						<td><label>Senha:</label></td>
						<td><input type="password" name="txtsenha" value="<%= usuario.getSenha() %>" maxlength="12" placeholder="Senha até 12 digitos" 
							required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" /></td>
					</tr>
					<tr>
						<td><label>Confirme:</label></td>
						<td><input type="password" name="txtconfirma" value="" maxlength="12" placeholder="Senha até 12 digitos" 
							required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td><input type="submit" name="btnenviar" value="Salvar" /></td>
						<td><input type="reset" name="btncancelar" value="Cancelar" /></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>
