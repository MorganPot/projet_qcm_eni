package fr.eni.tp.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.tp.qcm.bo.Proposition;
import fr.eni.tp.qcm.bo.ReponseTirage;
import fr.eni.tp.qcm.bo.Theme;
import fr.eni.tp.qcm.dal.dao.PropositionDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class PropositionDAOImpl implements PropositionDAO {
	
	private final String INSERT_REPONSE_TIRAGE_QUERY = "INSERT INTO REPONSE_TIRAGE(idEpreuve, idProposition) VALUES(?, ?)";
	private final String SELECT_REPONSE_BY_ID = "SELECT idEpreuve, idProposition FROM REPONSE_TIRAGE WHERE idProposition = ?";
	  
    private static PropositionDAOImpl instance;
    
    public static PropositionDAOImpl getInstance() {
        if(instance == null) {
            instance = new PropositionDAOImpl();
        }
        return instance;
    }
    
    @Override
	public ArrayList<Proposition> getPropositions(int idQuestion) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Proposition> listeProposition = new ArrayList<Proposition>();
		String requete = "SELECT * FROM PROPOSITION WHERE idQuestion = ?";
		
		try{
			cnx = MSSQLConnectionFactory.get();
			rqt = cnx.prepareStatement(requete);	
			rqt.setInt(1, idQuestion);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				Proposition proposition = new Proposition(
									rs.getInt("idProposition"),
									rs.getInt("idQuestion"),
									rs.getBoolean("estBonne"),
									rs.getString("enonce")
						);
				listeProposition.add(proposition);				
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste des rÃ©ponses : ");
			e.printStackTrace();
			
		}finally{
			if (rs != null) rs.close();
			if (rqt != null) rqt.close();
			if (cnx != null) cnx.close();
		}
		
		return listeProposition;
	}
	
    @Override
	public Proposition getProposition(int idProposition) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Proposition uneProposition = new Proposition();
		String requete = "SELECT * FROM PROPOSITION WHERE idProposition = ?";
		
		try{
			cnx = MSSQLConnectionFactory.get();
			rqt = cnx.prepareStatement(requete);	
			rqt.setInt(1, idProposition);
			rs = rqt.executeQuery();
			
			if (rs.next()){
				uneProposition = new Proposition(
						rs.getInt("idProposition"),
						rs.getInt("idQuestion"),
						rs.getBoolean("estBonne"),
						rs.getString("enonce")
						);
				return uneProposition;			
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de l'execution de la requete de la liste des réponses : ");
			e.printStackTrace();
			
		}finally{
			if (rs != null) rs.close();
			if (rqt != null) rqt.close();
			if (cnx != null) cnx.close();
		}
		
		return uneProposition;
	}

	@Override
	public void insertRepTirage(int idEpreuve, int idProp) throws DaoException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MSSQLConnectionFactory.get();
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(INSERT_REPONSE_TIRAGE_QUERY, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, idEpreuve);
            statement.setInt(2, idProp);

            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
            }
            
            connection.commit();

        } catch(SQLException e) {
        	
        	rollback(connection);
        	
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
	}

	@Override
	public ReponseTirage selectByIdRep(int idProp) throws DaoException {
		
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ReponseTirage rep = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_REPONSE_BY_ID);
			statement.setInt(1, idProp);

			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				rep = new ReponseTirage();
				rep.setIdEpreuve(resultSet.getInt("idEpreuve"));
				rep.setIdProposition(resultSet.getInt("idProposition"));
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return rep;
	}
	
	@Override
	public Proposition insert(Proposition element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Proposition element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proposition selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposition> selectAll() throws DaoException {
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
