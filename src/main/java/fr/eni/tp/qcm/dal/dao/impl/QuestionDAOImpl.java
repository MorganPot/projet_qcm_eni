package fr.eni.tp.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eni.tp.qcm.bo.Question;
import fr.eni.tp.qcm.bo.QuestionTirage;
import fr.eni.tp.qcm.dal.dao.QuestionDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class QuestionDAOImpl implements QuestionDAO {
	
	private final String SELECT_ALL_QUESTION = "SELECT * FROM Question";
	private final String DELETE_QUESTION_BY_ID = "DELETE FROM Question WHERE idQuestion = ?";
	private final String SELECT_QUESTION_BY_ID = "SELECT idQuestion, idTheme, enonce, media, points FROM Question WHERE idQuestion = ?";
	private final String SELECT_QUESTIONS_BY_ID_TEST = "SELECT idQuestion, Q.idTheme, enonce, media, points, nbQuestionATirer "
													+ "FROM QUESTION Q JOIN THEME T ON Q.idTheme = T.idTheme "
													+ "				   JOIN SECTION_TEST S ON T.idTheme = S.idTheme "
													+ "WHERE S.idTest = ?";
	private final String INSERT_QUESTION_QUERY = "INSERT INTO Question(idTheme, enonce, media, point) VALUES(?, ?, ?, ?)";
	private final String INSERT_QUESTION_TIRAGE_QUERY = "INSERT INTO QUESTION_TIRAGE(idEpreuve, idQuestion, estMarque, numOrdre) VALUES(?, ?, ?, ?)";
	private final String SELECT_QUESTION_TIRAGE_BY_ID = "SELECT idEpreuve, idQuestion, estMarque, numOrdre FROM QUESTION_TIRAGE WHERE idEpreuve = ? AND idQuestion = ?";
	private final String SELECT_QUESTION_TIRAGE_BY_ID_EPREUVE = "SELECT idEpreuve, idQuestion, estMarque, numordre FROM QUESTION_TIRAGE WHERE idEpreuve = ? ORDER BY numordre";
	   
	private static QuestionDAOImpl instance;
    
    public static QuestionDAOImpl getInstance() {
        if(instance == null) {
            instance = new QuestionDAOImpl();
        }
        return instance;
    }
	@Override
	public Question insert(Question element) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(INSERT_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, element.getIdTheme());
			statement.setString(2, element.getEnonce());
			statement.setString(3, element.getMedia());
			statement.setInt(4, element.getPoints());
			

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				
				if (resultSet.next()) {
					element.setIdQuestion(resultSet.getInt(1));
				}
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return element;
	}
	
	public void insertTirage(List<Question> lesQuestions, Integer idEpreuve) throws DaoException {
		
		int nbQuestion = 1;
		
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {			
			for (Question question : lesQuestions) {				
				connexion = MSSQLConnectionFactory.get();
				
				statement = connexion.prepareStatement(INSERT_QUESTION_TIRAGE_QUERY, Statement.RETURN_GENERATED_KEYS);
		
					statement.setInt(1, idEpreuve);
					statement.setInt(2, question.getIdQuestion());
					statement.setBoolean(3, false);
					statement.setInt(4, nbQuestion);	
					nbQuestion++;		
					
		            if (statement.executeUpdate() == 1) {
		                resultSet = statement.getGeneratedKeys();

		            }
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
	}

	@Override
	public void update(Question element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(DELETE_QUESTION_BY_ID);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(statement, connexion);
		}
		
	}

	@Override
	public Question selectById(Integer id) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question question = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_QUESTION_BY_ID);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				question = new Question();
				question.setIdQuestion(resultSet.getInt("idQuestion"));
				question.setIdTheme(resultSet.getInt("idTheme"));
				question.setEnonce(resultSet.getString("enonce"));
				question.setMedia(resultSet.getString("media"));
				question.setPoints(resultSet.getInt("media"));
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return question;
	}
	

	@Override
	public List<Question> selectAll() throws DaoException {
		List<Question> questions = new ArrayList<Question>();
		Question question = null;
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			statement = connexion.prepareStatement(SELECT_ALL_QUESTION);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				question = new Question();
				question.setIdQuestion(resultSet.getInt("idQuestion"));
				question.setIdTheme(resultSet.getInt("idTheme"));
				question.setEnonce(resultSet.getString("enonce"));
				question.setMedia(resultSet.getString("media"));
				question.setPoints(resultSet.getInt("point"));
				questions.add(question);
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return questions;
	}
	
	@Override
	public List<Question> selectByIdTest(Integer id, Integer idEpreuve) throws DaoException {
		List<Question> questions = new ArrayList<Question>();
		List<Question> questionsFinal = new ArrayList<Question>();
		Random r = new Random();
		
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question question = null;
		int nbQuestions = 0;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_QUESTIONS_BY_ID_TEST);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			
			while(resultSet.next()) 
			{				
				nbQuestions = resultSet.getInt("nbQuestionATirer");
				question = new Question();
				question.setIdQuestion(resultSet.getInt("idQuestion"));
				question.setIdTheme(resultSet.getInt("idTheme"));
				question.setEnonce(resultSet.getString("enonce"));
				question.setMedia(resultSet.getString("media"));
				question.setPoints(resultSet.getInt("points"));
				questions.add(question);
			}
			
			while(nbQuestions > 0)
			{
				Question laQuestion = questions.get(r.nextInt(questions.size()));
				while(!questionsFinal.contains(laQuestion))
				{
					questionsFinal.add(laQuestion);
					nbQuestions--;
				}
			}
			
			this.insertTirage(questionsFinal, idEpreuve);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return questionsFinal;
	}
	

	
	@Override
	public QuestionTirage selectByIdTirage(Integer idEpreuve, Integer idQuestion) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		QuestionTirage question = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_QUESTION_TIRAGE_BY_ID);
			statement.setInt(1, idEpreuve);
			statement.setInt(2, idQuestion);

			resultSet = statement.executeQuery();
			
			while(resultSet.next()) 
			{				
				question = new QuestionTirage();
				question.setIdEpreuve(resultSet.getInt("idEpreuve"));
				question.setIdQuestion(resultSet.getInt("idQuestion"));
				question.setEstMarquee(resultSet.getBoolean("estMarque"));
				question.setNumOrdre(resultSet.getInt("numordre"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		return question;
	}
	@Override
	public List<QuestionTirage> selectByIdEpreuve(Integer idEpreuve) throws DaoException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		QuestionTirage question = null;
		List<QuestionTirage> lesQuestions = new ArrayList<QuestionTirage>();
		
		try {
			connexion = MSSQLConnectionFactory.get();
			
			statement = connexion.prepareStatement(SELECT_QUESTION_TIRAGE_BY_ID_EPREUVE);
			statement.setInt(1, idEpreuve);

			resultSet = statement.executeQuery();
			
			while(resultSet.next()) 
			{				
				question = new QuestionTirage();
				question.setIdEpreuve(resultSet.getInt("idEpreuve"));
				question.setIdQuestion(resultSet.getInt("idQuestion"));
				question.setEstMarquee(resultSet.getBoolean("estMarque"));
				question.setNumOrdre(resultSet.getInt("numOrdre"));
				lesQuestions.add(question);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		return lesQuestions;
	}
}
