package fr.eni.tp.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.tp.qcm.bo.Theme;
import fr.eni.tp.qcm.dal.dao.ThemeDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class ThemeDAOImpl implements ThemeDAO {
	
	private final String SELECT_THEME_BY_ID = "SELECT idTheme, libelle FROM THEME WHERE idTheme = ?";
	
    private static ThemeDAOImpl instance;
    
    public static ThemeDAOImpl getInstance() {
        if(instance == null) {
            instance = new ThemeDAOImpl();
        }
        return instance;
    }
	@Override
	public Theme insert(Theme element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Theme element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Theme selectById(Integer id) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Theme theme = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_THEME_BY_ID);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				theme = new Theme();
				theme.setIdTheme(resultSet.getInt("idTheme"));
				theme.setLibelle(resultSet.getString("libelle"));
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return theme;
	}

	@Override
	public List<Theme> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
