package br.com.phalkao.teste;

import java.util.List;

import br.com.phalkao.entidades.Usuario;
import br.com.phalkao.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {

		// testeCadastrar();
		// testeAlterar();
		// testeExcluir();
		// testeBuscarTodos();
		// testeBuscaPorId(3);
		// testeBuscaPorNome("i");
		testeAutenticar("jmsantos", "441586");

	}

	private static void testeCadastrar() {
		Usuario usu = new Usuario();

		usu.setNome("Julio Miguel");
		usu.setLogin("jmsantos");
		usu.setSenha("441586");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
	}

	private static void testeAlterar() {
		Usuario usu = new Usuario();

		usu.setId(2);
		usu.setNome("Julio Miguel");
		usu.setLogin("jmsantos");
		usu.setSenha("441586");

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
	}

	private static void testeExcluir() {
		Usuario usu = new Usuario();

		usu.setId(2);

		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
	}

	private static void testeBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();

		List<Usuario> listaResultado = usuDAO.buscaTodos();

		for (Usuario u : listaResultado) {
			System.out.println("Usuario: | " + u.getId() + " | " + u.getNome() + " | " + u.getLogin() + " | "
					+ u.getSenha() + " | ");
		}
	}

	private static void testeBuscaPorId(Integer id) {
		UsuarioDAO usuDAO = new UsuarioDAO();

		Usuario usu = usuDAO.buscaPorId(id);

		System.out.println("Usuario: | " + usu.getId() + " | " + usu.getNome() + " | " + usu.getLogin() + " | "
				+ usu.getSenha() + " | ");
	}

	private static void testeAutenticar(String login, String senha) {

		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDAO usuDAO = new UsuarioDAO();

		System.out.println(usuDAO.autenticar(usuario));

	}

	private static void testeBuscaPorNome(String nome) {
		UsuarioDAO usuDAO = new UsuarioDAO();

		List<Usuario> listaResultado = usuDAO.buscaPorNome(nome);

		for (Usuario u : listaResultado) {
			System.out.println("Usuario: | " + u.getId() + " | " + u.getNome() + " | " + u.getLogin() + " | "
					+ u.getSenha() + " | ");
		}
	}

}
