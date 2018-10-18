package fr.eni.tp.qcm.bll.manager;

import java.util.List;

import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.QuestionTirage;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface QuestionManager {
	
	List<Question> selectByIdTest(int id, int idEpreuve) throws ManagerException;

	Question selectById(int idTest) throws ManagerException;
	
	QuestionTirage selectByIdTirage(int idEpreuve, int idQuestion) throws ManagerException;
	
	List<QuestionTirage> selectByIdEpreuve(int idEpreuve) throws ManagerException;
}
