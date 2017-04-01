package br.com.phalkao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.phalkao.entidades.Usuario;

public class UsuarioDAO {
	
	private Connection conn = Conexao.getConnection();
	
	public void cadastrar(Usuario usuario){
		String sSQL = "INSERT INTO USUARIO (NOME, LOGIN, SENHA) "
					+ "	VALUES (?,?,MD5(?))";
		try {
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário: " + e.getMessage());
		}
	}

	public void alterar(Usuario usuario){
		String sSQL = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = MD5(?) "
				+ " WHERE ID = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Alterado com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao alterar usuário: " + e.getMessage());
		}
	}


	public void excluir(Usuario usuario){
		String sSQL = "DELETE FROM USUARIO WHERE ID = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			
			preparador.setInt(1, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Excluído com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao excluir usuário: " + e.getMessage());
		}
	}

	
	public List<Usuario> buscaTodos(){
		String sSQL = "SELECT * FROM USUARIO";

		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			
			ResultSet resultado = preparador.executeQuery();
					
			while (resultado.next()){
				
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("ID"));
				usu.setNome(resultado.getString("NOME"));
				usu.setLogin(resultado.getString("LOGIN"));
				usu.setSenha(resultado.getString("SENHA"));
				
				lista.add(usu);
			}
			preparador.close();
			
			
			System.out.println("Exibidos com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao exibir usuários: " + e.getMessage());
		}
		
		return lista;
	}
	
	public Usuario buscaPorId(Integer id){
		String sSQL = "SELECT * FROM USUARIO WHERE ID = ?";
		
		Usuario usu = null;
		
		try{
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usu = new Usuario();
				
				usu.setId(resultado.getInt("ID"));
				usu.setNome(resultado.getString("NOME"));
				usu.setLogin(resultado.getString("LOGIN"));
				usu.setSenha(resultado.getString("SENHA"));
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}

		return usu;
		
	}

	public List<Usuario> buscaPorNome(String nome){
		String sSQL = "SELECT * FROM USUARIO WHERE UPPER(NOME) LIKE ?";

		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			preparador.setString(1, "%" + nome.toUpperCase() + "%");
			
			ResultSet resultado = preparador.executeQuery();
					
			while (resultado.next()){
				
				Usuario usu = new Usuario();
				
				usu.setId(resultado.getInt("ID"));
				usu.setNome(resultado.getString("NOME"));
				usu.setLogin(resultado.getString("LOGIN"));
				usu.setSenha(resultado.getString("SENHA"));
				
				lista.add(usu);
			}
			preparador.close();
			
			
			System.out.println("Exibidos com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao exibir usuários: " + e.getMessage());
		}
		
		return lista;
	}

	/**
	 * 
	 * Realiza a busca no Banco de Dados, por login e senha do usuário.
	 * @param usuario Objeto contendo o login e senha a ser consultado no banco.
	 * @return NULL quando não encontrar no banco ou um Ponteiro a um objeto usuário 
	 * completo quando encontrado.
	 * @author Júlio César Santos
	 * 
	 */
	public Usuario autenticar(Usuario usuario){
		String sSQL = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = MD5(?)";
		
		Usuario usuarioRetorno = null;
		
		try{
			PreparedStatement preparador = conn.prepareStatement(sSQL);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				usuarioRetorno = new Usuario();
				
				usuarioRetorno.setId(resultado.getInt("ID"));
				usuarioRetorno.setNome(resultado.getString("NOME"));
				usuarioRetorno.setLogin(resultado.getString("LOGIN"));
				usuarioRetorno.setSenha(resultado.getString("SENHA"));
			}
		}catch (SQLException e) {
			System.out.println("Erro ao autenticar usuário: " + e.getMessage());
			
		}

		return usuarioRetorno;
		
	}
	
	public void salvar(Usuario usuario){
		
		if(usuario.getId()!=null && usuario.getId()!=0){
			alterar(usuario);
		}else{
			cadastrar(usuario);
		}
	}
	
}
