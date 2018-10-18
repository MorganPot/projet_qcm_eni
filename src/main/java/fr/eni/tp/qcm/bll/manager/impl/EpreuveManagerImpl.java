package fr.eni.tp.qcm.bll.manager.impl;

import java.util.Date;

import fr.eni.tp.qcm.bll.manager.EpreuveManager;
import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.qcm.dal.dao.EpreuveDAO;
import fr.eni.tp.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class EpreuveManagerImpl implements EpreuveManager {
	
	private EpreuveDAO epreuveDAO = DAOFactory.epreuveDAO();
    
    private static EpreuveManagerImpl instance;
    
    public static EpreuveManagerImpl getInstance() {
        if(instance == null) {
            instance = new EpreuveManagerImpl();
        }
        return instance;
    }

	@Override
	public Epreuve insert(Integer idTest) throws ManagerException {
		
		Epreuve epreuve = new Epreuve();
		Date date = new Date();
		
		epreuve.setIdUtilisateur(2);
		epreuve.setIdTest(idTest);
		epreuve.setDebut(date.getTime());
		epreuve.setFin(date.getTime() + 1);
		epreuve.setEtat("EA");
		
		try {
			epreuve = epreuveDAO.insert(epreuve);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return epreuve;
	}
}
