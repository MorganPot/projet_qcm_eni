package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.qcm.beans.beanLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Passage  d'une chaine de caratère à la vue
		String paramAuteur = request.getParameter("auteur");
		String message = "Passage de variable: OK ! " + paramAuteur;
		request.setAttribute("message", message);
		
		//Création du bean
		beanLogin premierBean = new beanLogin(); 
		premierBean.setPseudo("Sabreleur");
		premierBean.setMotPasse("password");
		request.setAttribute("bean", premierBean);
		
		//Route d'accès au servelt
		this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/login.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
