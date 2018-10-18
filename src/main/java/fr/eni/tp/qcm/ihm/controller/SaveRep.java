package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.qcm.bll.factory.ManagerFactory;
import fr.eni.tp.qcm.bll.manager.EpreuveManager;
import fr.eni.tp.qcm.bll.manager.PropositionManager;
import fr.eni.tp.qcm.bll.manager.QuestionManager;
import fr.eni.tp.qcm.bll.manager.ThemeManager;
import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.ReponseTirage;
import fr.eni.tp.qcm.bo.Theme;

/**
 * Servlet implementation class SaveRep
 */
@WebServlet("/SaveRep")
public class SaveRep extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PropositionManager propositionManager = ManagerFactory.propositionManager();
	private ReponseTirage rep = new ReponseTirage();
	public static final String LISTE  = "/WEB-INF/jsp/restreint/afficheQuestion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveRep() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int idProp = Integer.valueOf(req.getParameter("idProp"));
			int idEpreuve = Integer.valueOf(req.getParameter("idEpreuve"));
			
			rep = propositionManager.selectByIdRep(idProp);
			
			if(rep == null)
			{
				propositionManager.insertRepTirage(idEpreuve, idProp);
				req.setAttribute("repExiste", false);
			}
			
			req.getRequestDispatcher(LISTE).forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
