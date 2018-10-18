package fr.eni.tp.qcm.bll.manager;

import fr.eni.tp.qcm.bo.Theme;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface ThemeManager {
	
	Theme selectById(int id) throws ManagerException;
}
