package fr.eni.tp.qcm.bll.manager;

import java.util.List;

import fr.eni.tp.qcm.bo.Test;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface TestManager {

	List<Test> selectAll() throws ManagerException;
	
	Test selectById(int id) throws ManagerException;
}
