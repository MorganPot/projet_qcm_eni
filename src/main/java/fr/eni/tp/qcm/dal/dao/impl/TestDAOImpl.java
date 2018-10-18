package fr.eni.tp.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tp.qcm.bo.Test;
import fr.eni.tp.qcm.dal.dao.TestDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class TestDAOImpl implements TestDAO {
	
	private static final String SELECT_ALL_QUERY = "SELECT idTest, libelle, description, duree, seuil_haut, seuil_bas FROM TEST WHERE idTest != 1";
	private static final String SELECT_BY_ID_TEST_QUERY = "SELECT idTest, libelle, description, duree, seuil_haut, seuil_bas FROM TEST WHERE idTest = ?";
	
    private static TestDAOImpl instance;
    
    public static TestDAOImpl getInstance() {
        if(instance == null) {
            instance = new TestDAOImpl();
        }
        return instance;
    }
	
	@Override
	public Test insert(Test element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Test element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Test selectById(Integer id) throws DaoException {
		Test test = null;
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_BY_ID_TEST_QUERY);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				test = new Test();
				test = preparedTest(test, resultSet);
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return test;
	}

	@Override
	public List<Test> selectAll() throws DaoException {
		List<Test> listeTest = new ArrayList<Test>();
		Test test = null;
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			statement = connexion.prepareStatement(SELECT_ALL_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				test = new Test();
				test = preparedTest(test, resultSet);
				listeTest.add(test);
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return listeTest;
	}

	
	public Test preparedTest(Test test, ResultSet resultSet) throws SQLException	{
		test.setIdTest(resultSet.getInt("idTest"));
		test.setLibelle(resultSet.getString("libelle"));
		test.setDescription(resultSet.getString("description"));
		test.setDuree(resultSet.getFloat("duree"));
		test.setSeuil_haut(resultSet.getInt("seuil_haut"));
		test.setSeuil_bas(resultSet.getInt("seuil_bas"));
		return test;
	}
}
