package analyse.abstraction.mappers.codemapper;

public interface CodeMapperService {
	
	public void analyseApplication(String workspacePath);
	public String[] getAvailableLanguages();
	
}
