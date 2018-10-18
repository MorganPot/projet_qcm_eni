package fr.eni.tp.qcm.bll.manager;

import fr.eni.tp.qcm.bo.Epreuve;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface EpreuveManager {

	Epreuve insert(Integer idTest) throws ManagerException;
}
