package fr.eni.tp.qcm.dal.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.qcm.bo.Proposition;
import fr.eni.tp.qcm.bo.ReponseTirage;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface PropositionDAO extends GenericDAO<Proposition, Integer> {

	ArrayList<Proposition> getPropositions(int idQuestion) throws SQLException;

	Proposition getProposition(int idProposition) throws SQLException;

	void insertRepTirage(int idEpreuve, int idProp) throws DaoException;

	ReponseTirage selectByIdRep(int idProp, int idEpreuve) throws DaoException;

	void deleteTirage(Integer idProp, Integer idEpreuve) throws DaoException;

}
