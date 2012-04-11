package husacct.analyse.domain;

import java.util.List;

import husacct.analyse.domain.analyser.ApplicationAnalyser;
import husacct.analyse.domain.famix.FamixObject;
import husacct.common.dto.AnalysedModuleDTO;
import husacct.common.dto.DependencyDTO;

public class AnalyseDomainServiceImpl implements AnalyseDomainService{

	ApplicationAnalyser mapperService; 

	public AnalyseDomainServiceImpl(){
		this.mapperService = new ApplicationAnalyser();
	}
	
	@Override
	public String[] getAvailableLanguages() {
		return mapperService.getAvailableLanguages();
	}
	
	public List<FamixObject> analyseApplication(){
		return mapperService.analyseApplication("benchmark_application");
	}
	
	
	
	
	@Override
	public DependencyDTO[] getDependency(String from, String to) {		
		//TODO 
		return null;
	}

	@Override
	public DependencyDTO[] getDependency(String from) {
		//TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO[] getChildModulesInModule(String from) {
		//TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO[] getChildModulesInModule(String from, int depth) {
		//TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO[] getRootModules() {
		// TODO
		return null;
	}

	@Override
	public AnalysedModuleDTO getParentModuleForModule(String child) {
		// TODO
		return null;
	}

}
