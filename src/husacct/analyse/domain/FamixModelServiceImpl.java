package husacct.analyse.domain;

import javax.naming.directory.InvalidAttributesException;

import husacct.analyse.domain.famix.FamixModel;
import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.domain.famix.FamixPackage;

public class FamixModelServiceImpl implements ModelService, ObservableModel{
	
	private static ModelObserver modelObserver;
	private static FamixModel model;
	
	public FamixModelServiceImpl(){
		model = new FamixModel();
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
			notifyObservers();
			return true;
		} catch (InvalidAttributesException e) {
			return false;
		}
	}

	@Override
	public void registerObserver(ModelObserver observer) {
		modelObserver = observer;
	}

	@Override
	public void removeObserver(ModelObserver observer) {
		
	}

	@Override
	public void notifyObservers() {
		modelObserver.updateModel(model);
	}
}
