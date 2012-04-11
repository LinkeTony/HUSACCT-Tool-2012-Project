package husacct.analyse.task;

import java.util.List;
import husacct.analyse.domain.AnalyseDomainService;
import husacct.analyse.domain.AnalyseDomainServiceImpl;
import husacct.analyse.domain.analyser.ApplicationAnalyser;
import husacct.analyse.domain.famix.FamixObject;
import husacct.common.dto.AnalysedModuleDTO;
import husacct.common.dto.DependencyDTO;

public class AnalyseControlerServiceImpl implements AnalyseControlService{

	private AnalyseDomainService domainService;
	
	public AnalyseControlerServiceImpl(){
		this.domainService = new AnalyseDomainServiceImpl();
	}
	
	@Override
	public List<FamixObject> analyseApplication() {
		return domainService.analyseApplication();
	}
	
	@Override
	public String[] getAvailableLanguages() {
		return domainService.getAvailableLanguages();
	}
	
	
	
	

	@Override
	public DependencyDTO[] getDependency(String from, String to) {
		// TODO 
		return null;
	}

	@Override
	public DependencyDTO[] getDependency(String from) {
		// TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO[] getRootModules() {
		// TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO[] getChildModulesInModule(String from) {
		// TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO[] getChildModulesInModule(String from, int depth) {
		// TODO 
		return null;
	}

	@Override
	public AnalysedModuleDTO getParentModuleForModule(String child) {
		// TODO 
		return null;
	}
}
