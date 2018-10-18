package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Restriction
 */
@WebServlet("/restriction")
public class Restriction extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5179118749045000295L;
	public static final String ACCES_PUBLIC     = "/WEB-INF/jsp/accesPublic.jsp";
    public static final String ACCES_RESTREINT  = "/WEB-INF/jsp/restreint/accesRestreint.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        } else {
            /* Affichage de la page restreinte */
            this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
        }
    }

}
