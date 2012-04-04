package analyse.abstraction.codemapper;

public class CodeMapper implements CodeMapperService{

	private MapperBuilder builder;
	
	public CodeMapper(){
		this.builder = new MapperBuilder();
	}
	
	@Override
	public void analyseApplication() {
		String applicationLanguage = getApplicationService();
		Object mapper = builder.getMapper("java");
	}

	@Override
	public String[] getAvailableLanguages() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getApplicationService(){
		ApplicationDetailDTO details = defineService.getApplicationDetails();
		return details.language;
	}
	
}
