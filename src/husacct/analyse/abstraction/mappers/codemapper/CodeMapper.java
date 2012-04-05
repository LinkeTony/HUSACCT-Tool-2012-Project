package husacct.analyse.abstraction.mappers.codemapper;

import husacct.analyse.abstraction.mappers.csharpmapper.CSharpMapper;
import husacct.analyse.abstraction.mappers.javamapper.JavaMapper;

public class CodeMapper implements CodeMapperService{

	private MapperBuilder builder;
	
	public CodeMapper(){
		this.builder = new MapperBuilder();
	}
	
	@Override
	public void analyseApplication(String workspacePath) {
		//TODO get applicationdetails from define-service and replace hard-coded "java"
		GenericMapper mapper = builder.getMapper(JavaMapper.programmingLanguage);
		mapper.analyseApplication(workspacePath);
		//todo mapper.doWork()
	}

	@Override
	public String[] getAvailableLanguages() {
		//TODO Add other functionality to dynamically load all possible languages. 
		String[] availableLanguages = new String[]{
			JavaMapper.programmingLanguage,
			CSharpMapper.programmingLanguage
		};
		return availableLanguages;
	}
}
