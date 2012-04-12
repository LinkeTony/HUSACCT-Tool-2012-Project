package main;

import husacct.analyse.AnalyseServiceImpl;
import husacct.analyse.IAnalyseService;
import husacct.analyse.domain.AnalyseDomainService;
import husacct.analyse.domain.AnalyseDomainServiceImpl;
import husacct.analyse.domain.FamixModelServiceImpl;
import husacct.analyse.domain.ModelService;
import husacct.analyse.task.AnalyseControlerServiceImpl;

public class TestObserver {

	public static void main(String[] args) throws Exception {
		AnalyseDomainService service = new AnalyseDomainServiceImpl();
    	ModelService modelManager = new FamixModelServiceImpl();
    	modelManager.createPackage("YeaBitchUniq", "Facking hell", "MyFackingName");
    	modelManager.createPackage("YeaBitchUniq", "Facking hell", "MyFackingName");
	}
}
