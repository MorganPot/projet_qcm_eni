package fr.eni.tp.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.tp.qcm.bll.manager.ThemeManager;
import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.Theme;
import fr.eni.tp.qcm.dal.dao.ThemeDAO;
import fr.eni.tp.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class ThemeManagerImpl implements ThemeManager {
	
	private ThemeDAO themeDAO = DAOFactory.themeDAO();   
	
    private static ThemeManagerImpl instance;
    
    public static ThemeManagerImpl getInstance() {
        if(instance == null) {
            instance = new ThemeManagerImpl();
        }
        return instance;
    }

	@Override
	public Theme selectById(int id) throws ManagerException {
		
		Theme leTheme = new Theme();
		
		try {
			leTheme = themeDAO.selectById(id);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
	
		return leTheme;
	}

}
