package fr.eni.tp.qcm.dal.dao;

import java.util.List;

import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.QuestionTirage;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface QuestionDAO extends GenericDAO<Question, Integer> {
	
	List<Question> selectByIdTest(Integer id, Integer idEpreuve) throws DaoException;

	QuestionTirage selectByIdTirage(Integer idEpreuve, Integer idQuestion) throws DaoException;
	
	List<QuestionTirage> selectByIdEpreuve(Integer idEpreuve) throws DaoException;
}
