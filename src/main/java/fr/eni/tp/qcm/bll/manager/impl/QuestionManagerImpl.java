package fr.eni.tp.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.tp.qcm.bll.manager.QuestionManager;
import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.QuestionTirage;
import fr.eni.tp.qcm.dal.dao.QuestionDAO;
import fr.eni.tp.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class QuestionManagerImpl implements QuestionManager {
	
	private QuestionDAO questionDAO = DAOFactory.questionDAO();
	
    private static QuestionManagerImpl instance;
    
    public static QuestionManagerImpl getInstance() {
        if(instance == null) {
            instance = new QuestionManagerImpl();
        }
        return instance;
    }

	@Override
	public List<Question> selectByIdTest(int id, int idEpreuve) throws ManagerException {
		
		List<Question> listeQuestion = new ArrayList<Question>();
		
		try {
			listeQuestion = questionDAO.selectByIdTest(id, idEpreuve);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return listeQuestion;
	}

	@Override
	public Question selectById(int idTest) throws ManagerException {
		
		Question question = new Question();
		
		try {
			question = questionDAO.selectById(idTest);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return question;
	}

	@Override
	public QuestionTirage selectByIdTirage(int idEpreuve, int idQuestion) throws ManagerException {
		
		QuestionTirage question = new QuestionTirage();
		
		try {
			question = questionDAO.selectByIdTirage(idEpreuve, idQuestion);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return question;
	}

	@Override
	public List<QuestionTirage> selectByIdEpreuve(int idEpreuve) throws ManagerException {
		
		List<QuestionTirage> questions = new ArrayList<QuestionTirage>();
		
		try {
			questions = questionDAO.selectByIdEpreuve(idEpreuve);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return questions;
	}
}
