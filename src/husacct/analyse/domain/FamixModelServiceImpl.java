package husacct.analyse.domain;

import javax.naming.directory.InvalidAttributesException;

import husacct.analyse.domain.famix.FamixClass;
import husacct.analyse.domain.famix.FamixImport;
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
	
	@Override
	public void createClass(String uniqueName, String name, String belongsToPackage, boolean isAbstract, boolean isInnerClass) {
		FamixClass fClass = new FamixClass();
		fClass.setUniqueName(uniqueName);
		fClass.setAbstract(isAbstract);
		fClass.setBelongsToPackage(belongsToPackage);
		fClass.setIsInnerClass(isInnerClass);
		fClass.setName(name);
		addToModel(fClass);
	}

	@Override
	public void createClass(String uniqueName, String name, String belongsToPackage, boolean isAbstract, boolean isInnerClass, String belongsToClass) {
		FamixClass fClass = new FamixClass();
		fClass.setUniqueName(uniqueName);
		fClass.setAbstract(isAbstract);
		fClass.setBelongsToPackage(belongsToPackage);
		fClass.setIsInnerClass(isInnerClass);
		fClass.setName(name);
		fClass.setBelongsToClass(belongsToClass);
		addToModel(fClass);
	}

	@Override
	public void createImport(String importingClass, String importedModule, String completeImportString, boolean importsCompletePackage) {
		FamixImport fImport = new FamixImport();
		fImport.setImportingClass(importingClass);
		fImport.setCompleteImportString(completeImportString);
		fImport.setImportedModule(completeImportString);
		fImport.setImportsCompletePackage(importsCompletePackage);
		addToModel(fImport);
	}
	
	private boolean addToModel(FamixObject newObject){
		try {
			model.addObject(newObject);
			return true;
		} catch (InvalidAttributesException e) {
			return false;
		}
	}
	
	public FamixModel getModel(){
		return model;
	}
}
