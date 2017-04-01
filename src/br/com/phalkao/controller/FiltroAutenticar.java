package br.com.phalkao.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutenticar
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAutenticar implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutenticar() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		//Feito um cast no ServletRequest para HttpŚervletRequest
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		//Captura caminho completo da pagina
		String url = httpServletRequest.getRequestURI();
		
		//Captura sessao
		HttpSession sessao = httpServletRequest .getSession();
		
		if(sessao.getAttribute("usuLogado")!=null || url.lastIndexOf("login.html") >-1 || url.lastIndexOf("autcontroller.do") > -1){
			//Continua o fluxo
			chain.doFilter(request, response);
		}else{
			//Redireciona para pagina de login
			((HttpServletResponse) response) .sendRedirect("login.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
