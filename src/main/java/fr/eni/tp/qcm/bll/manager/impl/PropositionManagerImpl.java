package fr.eni.tp.qcm.bll.manager.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp.qcm.bll.manager.PropositionManager;
import fr.eni.tp.qcm.bo.Proposition;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.ReponseTirage;
import fr.eni.tp.qcm.dal.dao.PropositionDAO;
import fr.eni.tp.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class PropositionManagerImpl implements PropositionManager   {
	
	private PropositionDAO propositionDAO = DAOFactory.propositionDAO();
	
    private static PropositionManagerImpl instance;
    
    public static PropositionManagerImpl getInstance() {
        if(instance == null) {
            instance = new PropositionManagerImpl();
        }
        return instance;
    }

	@Override
	public Proposition getProposition(int idProposition) throws ManagerException {
		
		Proposition proposition = new Proposition();
		
		try {
			proposition = propositionDAO.getProposition(idProposition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return proposition;
	}

	@Override
	public List<Proposition> getPropositions(int idQuestion) throws ManagerException {
		
		List<Proposition> propositions = new ArrayList<Proposition>();
		
		try {
			propositions = propositionDAO.getPropositions(idQuestion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return propositions;
	}
	
	@Override
	public void insertRepTirage(int idEpreuve, int idProp) throws ManagerException {
		
		try {
			propositionDAO.insertRepTirage(idEpreuve, idProp);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	@Override
	public ReponseTirage selectByIdRep(int idProp, int idEpreuve) throws ManagerException {
		
		ReponseTirage rep = new ReponseTirage();
		
		try {
			rep = propositionDAO.selectByIdRep(idProp, idEpreuve);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return rep;
	}

	@Override
	public void deleteTirage(int idProp, int idEpreuve) throws ManagerException {
		
		try {
			propositionDAO.deleteTirage(idProp, idEpreuve);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	}
}
