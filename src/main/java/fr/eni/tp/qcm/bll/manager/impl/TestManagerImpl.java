package fr.eni.tp.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.tp.qcm.bll.manager.TestManager;
import fr.eni.tp.qcm.bo.Test;
import fr.eni.tp.qcm.dal.dao.TestDAO;
import fr.eni.tp.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class TestManagerImpl implements TestManager {
	
	private TestDAO testDAO = DAOFactory.testDAO();
    
    private static TestManagerImpl instance;
    
    public static TestManagerImpl getInstance() {
        if(instance == null) {
            instance = new TestManagerImpl();
        }
        return instance;
    }

	@Override
	public List<Test> selectAll() throws ManagerException {
		List<Test> listeTest = new ArrayList<Test>();
		
		try {
			listeTest = testDAO.selectAll();
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return listeTest;
	}

	@Override
	public Test selectById(int id) throws ManagerException {	
		Test test = null;
		
		try {
			test = testDAO.selectById(id);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		
		return test;
	}
}
