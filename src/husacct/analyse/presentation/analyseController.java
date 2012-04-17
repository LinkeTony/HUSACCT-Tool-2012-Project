package husacct.analyse.presentation;

import husacct.analyse.AnalyseServiceStub;
import husacct.analyse.domain.famix.FamixModel;
import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.domain.famix.FamixPackage;
import husacct.analyse.task.AnalyseControlService;
import husacct.analyse.task.AnalyseControlerServiceImpl;
import husacct.common.dto.AnalysedModuleDTO;
import husacct.common.dto.DependencyDTO;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

public class analyseController {

	
	private AnalyseControlService service = new AnalyseControlerServiceImpl();
	private AnalyseServiceStub stub;
	private FamixModel model;

	public analyseController(){
		stub = new AnalyseServiceStub();
		model = FamixModel.getInstance();
	}
 
	public String[] getAvailableLanguages() {
		return service.getAvailableLanguages();
	}
 
	public String  analyseApplication() {
		//Fill with Stub.. Should be filled with actual data
		
		List<FamixObject> famixObjects = new ArrayList<FamixObject>();
		try {
			for (FamixObject famixObject : famixObjects) {
				
				if(famixObject instanceof FamixPackage){
//					 System.out.println(famixObject.toString());
				} 
				model.addObject(famixObject);
			}
//			System.out.println(famixModel);
		} catch (InvalidAttributesException e) {
			e.printStackTrace();
		}
		
		return model.toString();
	}

 
	 
	public FamixModel getCompleteModel(){
		return model;
	}

	
}
