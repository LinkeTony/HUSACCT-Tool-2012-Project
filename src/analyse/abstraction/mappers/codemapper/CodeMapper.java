package analyse.abstraction.mappers.codemapper;

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
//		ApplicationDetailDTO details = defineService.getApplicationDetails();
//		return details.language;
		return "";
	}
	
	public static void main(String[] args){
		
		String packagePath = CodeMapper.class.getPackage().getName();
		
		System.out.println("Path: " + packagePath);
	}
	
}
