package husacct.common.dto;

import java.util.List;

public class AnalysedModuleDTO extends AbstractDTO{
	
	public String uniqueName;
	public String name;
	public String type;
	public List<AnalysedModuleDTO> subModules;
	
	public AnalysedModuleDTO(String uniqueName, String name){
		this.uniqueName = uniqueName;
		this.name = name;
	}
	
	public AnalysedModuleDTO(String uniqueName, String name, List<AnalysedModuleDTO> subModules){
		this.uniqueName = uniqueName;
		this.name = name;
		this.subModules = subModules;
	}
}
