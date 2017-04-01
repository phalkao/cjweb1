<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Usu&aacute;rio</title>
</head>
<body>
	<div id="div" align="center" >
		<form action="usucontroller.do" method="post">
			<table>
				<thead>Cadastro</thead>
				<tbody>
					<tr>
						<td><label>C&oacute;digo:</label></td>
						<td><input type="text" name="txtid" readonly value="${requestScope.usuario.id}" placeholder="C&oacute;digo do Usuário" min="0" /></td>
					</tr>
					<tr>
						<td><label>Nome:</label></td>
						<td><input type="text" name="txtnome" value="${requestScope.usuario.nome}" placeholder="Digite o nome" required size="30" /></td>
					</tr>
					<tr>
						<td><label>Login:</label></td>
						<td><input type="text" name="txtlogin" value="${requestScope.usuario.login}" placeholder="Nome de usuário ou email" required size="30" /></td>
					</tr>
					<tr>
						<td><label>Senha:</label></td>
						<td><input type="password" name="txtsenha" value="${requestScope.usuario.senha}" maxlength="12" placeholder="Senha até 12 digitos" 
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
