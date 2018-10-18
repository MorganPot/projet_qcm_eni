package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.qcm.bll.factory.ManagerFactory;
import fr.eni.tp.qcm.bll.manager.PropositionManager;
import fr.eni.tp.qcm.bll.manager.QuestionManager;
import fr.eni.tp.qcm.bll.manager.ThemeManager;
import fr.eni.tp.qcm.bo.Proposition;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.QuestionTirage;
import fr.eni.tp.qcm.bo.Theme;

/**
 * Servlet implementation class AffichageQuestion
 */
@WebServlet("/AffichageQuestion")
public class AffichageQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionManager questionManager = ManagerFactory.questionManager();
	private ThemeManager themeManager = ManagerFactory.themeManager();
	private PropositionManager propositionManager = ManagerFactory.propositionManager();
	public static final String QUESTION  = "/WEB-INF/jsp/restreint/afficheQuestion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int idQuestion = Integer.valueOf(req.getParameter("idQuestion"));
			int idEpreuve = Integer.valueOf(req.getParameter("idEpreuve"));
			String action = req.getParameter("idEpreuve");
			QuestionTirage tirage = new QuestionTirage();
			Boolean tire = false;
			
			Question question = questionManager.selectById(idQuestion);
			Theme theme = themeManager.selectById(question.getIdTheme());
			List<Proposition> lesPropositions = propositionManager.getPropositions(idQuestion);
			List<QuestionTirage> lesTirages = questionManager.selectByIdEpreuve(idEpreuve);
			QuestionTirage questionTirage = questionManager.selectByIdTirage(idEpreuve, question.getIdQuestion());
//		
//			for (QuestionTirage questionTire : lesTirages) {
//				if(tire == true)
//				{
//					if(action == "suiv")
//					{
//						question = questionManager.selectById(tirage.getIdQuestion());
//					}
//				}
//				if(questionTire.getIdQuestion() == question.getIdQuestion())
//				{
//					tire = true;
//					if(action == "prec")
//					{
//						question = questionManager.selectById(tirage.getIdQuestion());
//					}
//				}
//				tirage = questionTire;
//			}
				
			
			req.setAttribute("listeProp", lesPropositions);
			req.setAttribute("theme", theme.getLibelle());
			req.setAttribute("idEpreuve", idEpreuve);
			req.setAttribute("question", question);
			req.setAttribute("questionTirage", questionTirage);
			req.setAttribute("lesTirages", lesTirages);
			req.getRequestDispatcher(QUESTION).forward(req, resp);
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
