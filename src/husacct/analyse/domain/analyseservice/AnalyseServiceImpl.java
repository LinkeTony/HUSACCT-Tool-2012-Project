package husacct.analyse.domain.analyseservice;

import husacct.analyse.AnalyseServiceStub;
import husacct.common.dto.AnalysedModuleDTO;
import husacct.common.dto.DependencyDTO;

public class AnalyseServiceImpl implements AnalyseService{

	private AnalyseServiceStub stub;
	
	public AnalyseServiceImpl(){
		stub = new AnalyseServiceStub();
	}
	
	@Override
	public DependencyDTO[] getDependency(String from, String to) {		
		return stub.getDependency(from, to);
	}

	@Override
	public DependencyDTO[] getDependency(String from) {
		return stub.getDependency(from);
	}

	@Override
	public String[] getAvailableLanguages() {
		return stub.getAvailableLanguages();
	}
	
	@Override
	public AnalysedModuleDTO[] getChildModulesInModule(String from) {
		return stub.getChildModulesInModule(from);
	}

	@Override
	public AnalysedModuleDTO[] getChildModulesInModule(String from, int depth) {
		return stub.getChildModulesInModule(from, depth);
	}

	@Override
	public AnalysedModuleDTO[] getRootModules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnalysedModuleDTO getParentModuleForModule(String child) {
		// TODO Auto-generated method stub
		return null;
	}

}
