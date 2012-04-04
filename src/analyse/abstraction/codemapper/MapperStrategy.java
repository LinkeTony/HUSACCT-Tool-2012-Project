package analyse.abstraction.codemapper;

public abstract class MapperStrategy implements CodeMapperService{
		
	public abstract void analyseApplication();
	public abstract String getLanguage();
	
	public String[] getAvailableLanguages(){
		return new String[]{"Java", "C#"};
	}
}
