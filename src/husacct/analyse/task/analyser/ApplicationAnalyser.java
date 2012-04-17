package husacct.analyse.task.analyser;

import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.task.analyser.csharp.CSharpAnalyser;
import husacct.analyse.task.analyser.java.JavaAnalyser;

import java.util.ArrayList;
import java.util.List;

public class ApplicationAnalyser {
	
	private AnalyserBuilder builder;
	
	public ApplicationAnalyser(){
		this.builder = new AnalyserBuilder();
	}
	
	public void analyseApplication(String workspacePath) {
		//TODO Implement getApplicationDetails from defineservice. 
		String language = "Java";
		
		AbstractAnalyser analyser = builder.getAnalyser(language);
		SourceFileFinder sourceFileFinder = new SourceFileFinder();
		try{
			String sourceFileExtension = getExtensionForLanguage(language);
			List<MetaFile> fileData = sourceFileFinder.getFileInfoFromProject(workspacePath, sourceFileExtension);
			for(MetaFile fileInfo: fileData){
//				List<FamixObject> famixObjects = analyser.generateModelFromSource(fileInfo.getPath());
				analyser.generateModelFromSource(fileInfo.getPath());
			}
		}
		catch(Exception e){
			//TODO Generate Custom Exception
		}
	}

	public String[] getAvailableLanguages() {
		//TODO If possible, add other functionality to dynamically load all possible languages. 
		String[] availableLanguages = new String[]{
			new JavaAnalyser().getProgrammingLanguage(),
			new CSharpAnalyser().getProgrammingLanguage()
		};
		return availableLanguages;
	}
	
	private String getExtensionForLanguage(String language){
		AbstractAnalyser analyser = builder.getAnalyser(language);
		return analyser.getFileExtension();
	}
	
}