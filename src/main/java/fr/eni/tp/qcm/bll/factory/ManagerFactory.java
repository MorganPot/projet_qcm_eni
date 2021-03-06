package fr.eni.tp.qcm.bll.factory;

import fr.eni.tp.qcm.bll.manager.EpreuveManager;
import fr.eni.tp.qcm.bll.manager.PropositionManager;
import fr.eni.tp.qcm.bll.manager.QuestionManager;
import fr.eni.tp.qcm.bll.manager.TestManager;
import fr.eni.tp.qcm.bll.manager.ThemeManager;
import fr.eni.tp.qcm.bll.manager.impl.EpreuveManagerImpl;
import fr.eni.tp.qcm.bll.manager.impl.PropositionManagerImpl;
import fr.eni.tp.qcm.bll.manager.impl.QuestionManagerImpl;
import fr.eni.tp.qcm.bll.manager.impl.TestManagerImpl;
import fr.eni.tp.qcm.bll.manager.impl.ThemeManagerImpl;

public class ManagerFactory {

    public static EpreuveManager epreuveManager() {
        return EpreuveManagerImpl.getInstance();
    }
    
    public static TestManager testManager() {
        return TestManagerImpl.getInstance();
    }
    
    public static QuestionManager questionManager() {
        return QuestionManagerImpl.getInstance();
    }
    
    public static ThemeManager themeManager() {
        return ThemeManagerImpl.getInstance();
    }
    
    public static PropositionManager propositionManager() {
        return PropositionManagerImpl.getInstance();
    }
}
