package husacct.analyse.task;

import husacct.analyse.abstraction.mappers.codemapper.CodeMapper;
import husacct.analyse.abstraction.mappers.codemapper.CodeMapperService;
import husacct.analyse.domain.analyseservice.AnalyseDomainServiceImpl;
import husacct.analyse.domain.analyseservice.AnalyseDomainService;
import husacct.common.dto.AnalysedModuleDTO;
import husacct.common.dto.DependencyDTO;

public class AnalyseControlerServiceImpl implements AnalyseControlService{

	private AnalyseDomainService domainService;
	private CodeMapperService mapperService;
	
	public AnalyseControlerServiceImpl(){
		this.domainService = new AnalyseDomainServiceImpl();
		this.mapperService = new CodeMapper();
	}
	
	@Override
	public void analyseApplication() {
		//TODO Path from defineservice! (getApplicatioDetails())
		mapperService.analyseApplication("benchmark_application");
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
