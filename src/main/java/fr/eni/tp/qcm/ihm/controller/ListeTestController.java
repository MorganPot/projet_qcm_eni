package fr.eni.tp.qcm.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.qcm.bll.factory.ManagerFactory;
import fr.eni.tp.qcm.bll.manager.TestManager;
import fr.eni.tp.qcm.bo.Test;

/**
 * Servlet implementation class ListeTestController
 */
@WebServlet("/ListeTestController")
public class ListeTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TestManager testManager = ManagerFactory.testManager();
	public static final String LISTE  = "/WEB-INF/jsp/restreint/listeTest.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Test> tests = testManager.selectAll();
			
			req.setAttribute("liste", tests);
			req.getRequestDispatcher(LISTE).forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Test> tests = testManager.selectAll();
			
			req.setAttribute("liste", tests);
			req.getRequestDispatcher(LISTE).forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
		//		try {			
//			req.setCharacterEncoding("UTF-8");
//			int id = Integer.parseInt(req.getParameter("idTest"));
//			ValidationUtil.checkNotNull(id);
//			
//			Test test = testManager.selectById(id);
//			ValidationUtil.checkNotNull(test);
//			
//			req.setAttribute("test", test);
//			req.getRequestDispatcher("ShowTest").forward(req, resp);
//		}
//		catch (IllegalArgumentException f) {
//			resp.sendError(400);
//		}
//		catch (Exception e) {
//			resp.sendError(500);
//		}
	}

}
