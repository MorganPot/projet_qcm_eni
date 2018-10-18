package fr.eni.tp.qcm.dal.dao.impl;

import java.util.List;

import fr.eni.tp.qcm.bo.Utilisateur;
import fr.eni.tp.qcm.dal.dao.UtilisateurDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	private static final String SELECT_ALL_QUERY = "SELECT U.idUtilisateur, U.codeProfil, U.nom, U.prenom, U.email, U.password FROM USTILISATEUR U ORDER BY U.email DESC";
    private static final String SELECT_ONE_USER_QUERY = "SELECT U.idUtilisateur as utilisateur_id, U.codeProfil as code_profil, U.nom as nom, U.prenom as prenom, U.email as email, U.password as password FROM UTILISATEUR U where U.idUtilisateur = ?";
    private static final String SELECT_ONE_USER_BY_MAIL_QUERY = "SELECT U.idUtilisateur FROM UTLISATEUR U where U.email = ?";
    private static final String INSERT_USER_QUERY = "INSERT INTO UTILISATEUR(U, created_at, content) VALUES (?, ?, ?)";
    private static final String DELETE_USER_QUERY = "DELETE FROM note WHERE id = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE note SET nom = ?, content = ? WHERE id = ?";

	@Override
	public Utilisateur insert(Utilisateur element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
