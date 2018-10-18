package fr.eni.tp.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.qcm.dal.dao.EpreuveDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class EpreuveDAOImpl implements EpreuveDAO {

    private final String INSERT_EPREUVE_QUERY = "INSERT INTO EPREUVE(idUtilisateur, idTest, dateDebutValidite, dateFinValidite, etat) VALUES(?, ?, ?, ?, ?)";
    
    private static EpreuveDAOImpl instance;
    
    public static EpreuveDAOImpl getInstance() {
        if(instance == null) {
            instance = new EpreuveDAOImpl();
        }
        return instance;
    }

	@Override
	public Epreuve insert(Epreuve element) throws DaoException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnectionFactory.get();
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(INSERT_EPREUVE_QUERY, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, element.getIdUtilisateur());
            statement.setInt(2, element.getIdTest());
            statement.setLong(3, element.getDebut());
            statement.setLong(4, element.getFin());
            statement.setString(5, element.getEtat());

            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    element.setIdEpreuve(resultSet.getInt(1));
                }
            }
            
            connection.commit();

        } catch(SQLException e) {
        	
        	rollback(connection);
        	
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return element;
	}

	@Override
	public void update(Epreuve element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Epreuve selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Epreuve> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}    
	
    private void rollback(Connection connection) throws DaoException {
    	
    	try {
			connection.close();
			
		} catch (SQLException e) {
			throw new DaoException("Could not rollback", e);
		}
    }

}
