package fr.eni.tp.qcm.bll.manager;

import java.sql.SQLException;
import java.util.List;

import fr.eni.tp.qcm.bo.Proposition;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.ReponseTirage;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface PropositionManager {
	Proposition getProposition(int idProposition) throws ManagerException;
	
	List<Proposition> getPropositions (int idQuestion) throws ManagerException;
	
	void insertRepTirage(int idEpreuve, int idProp) throws ManagerException;

	ReponseTirage selectByIdRep(int idProp, int idEpreuve) throws ManagerException;
	
	void deleteTirage(int idProp, int idEpreuve) throws ManagerException;
}
