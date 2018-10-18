package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.qcm.bll.factory.ManagerFactory;
import fr.eni.tp.qcm.bll.manager.EpreuveManager;
import fr.eni.tp.qcm.bll.manager.QuestionManager;
import fr.eni.tp.qcm.bll.manager.ThemeManager;
import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.QuestionTirage;
import fr.eni.tp.qcm.bo.Theme;

/**
 * Servlet implementation class SelectionController
 */
@WebServlet("/SelectionController")
public class SelectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionManager questionManager = ManagerFactory.questionManager();
	private EpreuveManager epreuveManager = ManagerFactory.epreuveManager();
	private ThemeManager themeManager = ManagerFactory.themeManager();
	private Epreuve epreuve = new Epreuve();
	public static final String LISTE  = "/WEB-INF/jsp/restreint/questions.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int idTest = Integer.valueOf(req.getParameter("idTest"));
			List<QuestionTirage> tirage = new ArrayList<QuestionTirage>();
			
			epreuve = epreuveManager.insert(idTest);
			List<Question> questions = questionManager.selectByIdTest(idTest, epreuve.getIdEpreuve());
			Theme theme = themeManager.selectById(questions.get(1).getIdTheme());
			
			for (Question question : questions) {
				tirage.add(questionManager.selectByIdTirage(epreuve.getIdEpreuve(), question.getIdQuestion()));				
			}
			
			req.setAttribute("theme", theme.getLibelle());
			req.setAttribute("liste", questions);
			req.setAttribute("nbQuestions", questions.size());
			req.setAttribute("epreuve", epreuve);
			req.setAttribute("listeTirage", tirage);
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
