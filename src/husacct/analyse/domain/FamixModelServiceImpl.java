package husacct.analyse.domain;

import javax.naming.directory.InvalidAttributesException;

import husacct.analyse.domain.famix.FamixModel;
import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.domain.famix.FamixPackage;

public class FamixModelServiceImpl implements ModelService{
	
	private FamixModel model;
	
	public FamixModelServiceImpl(){
		model = FamixModel.getInstance();
	}
	
	public void createPackage(String uniqueName, String belongsToPackage, String name){
		FamixPackage fPackage = new FamixPackage();
		fPackage.setUniqueName(uniqueName);
		fPackage.setBelongsToPackage(belongsToPackage);
		fPackage.setName(name);
		addToModel(fPackage);
	}
	
	public FamixModel getModel(){
		return model;
	}
	
	private boolean addToModel(FamixObject newObject){
		try {
			model.addObject(newObject);
			return true;
		} catch (InvalidAttributesException e) {
			return false;
		}
	}

	@Override
	public void createImport(String uniqueName, String belongsTo, String name) {
		// TODO Auto-generated method stub
		
	}
}
