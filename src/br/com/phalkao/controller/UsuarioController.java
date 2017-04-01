package br.com.phalkao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.phalkao.entidades.Usuario;
import br.com.phalkao.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Captura parametro da tela
		String acao = request.getParameter("acao");
		UsuarioDAO  usuarioDAO = new UsuarioDAO();

		if(acao != null && acao.equals("exc")){
			//Captura parametro da tela
			String id = request.getParameter("id");
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usuario);
			
			//Redirecionando pelo cliente (browser)
			response.sendRedirect("usucontroler.do?acao=lis");
		}
		
		if(acao != null && acao.equals("alt")){
			//Captura parametro da tela
			String id = request.getParameter("id");
			
			//Buscar objeto usuário no banco
			Usuario usuario = usuarioDAO.buscaPorId(Integer.parseInt(id));
			
			//Seta atributo no request com objeto usuário
			request.setAttribute("usuario",usuario);
			
			//Encaminha objeto para a tela
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp"); 
			saida.forward(request, response);
		}

		if(acao != null && acao.equals("cad")){
			//Criar objeto usuário
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			
			//Seta atributo no request com objeto usuário
			request.setAttribute("usuario",usuario);
			
			//Encaminha objeto para a tela
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp"); 
			saida.forward(request, response);
		}

		if(acao != null && acao.equals("lis")){
			//Obter lista de Usuários
			List<Usuario> lista = usuarioDAO.buscaTodos();
			
			//Setar o objeto lista como atributo do request
			request.setAttribute("lista", lista);
			
			//Encaminhar para o JSP
			RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp"); 
			saida.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		Usuario usuario = new Usuario();
		if(id!="" && id!="0"){
			usuario.setId(Integer.parseInt(id));
		}
			
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		//response.getWriter("Usuário cadastrado");
		
		doGet(request, response);
	}

}
