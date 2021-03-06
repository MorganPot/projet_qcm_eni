package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deconnexion
 */
@WebServlet("/deconnexion")
public class Deconnexion extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -3323461404142432904L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static final String URL_REDIRECTION = "https://www.youtube.com/watch?v=FaswDILZU8c";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* R�cup�ration et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        /* Redirection vers le Site du Z�ro ! */
        response.sendRedirect( URL_REDIRECTION );
    }

}
