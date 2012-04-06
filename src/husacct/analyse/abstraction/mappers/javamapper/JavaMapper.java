package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.codemapper.GenericMapper;


public class JavaMapper implements GenericMapper{
	public static String programmingLanguage = "Java";
	JavaASTGenerator astGenerator = new JavaASTGenerator();
	
	@Override
	public void analyseApplication(String workspacePath) {
		try {
			WorkspaceAnalyser workspaceAnalyser = new WorkspaceAnalyser();
			workspaceAnalyser.analyse(workspacePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
	

}
