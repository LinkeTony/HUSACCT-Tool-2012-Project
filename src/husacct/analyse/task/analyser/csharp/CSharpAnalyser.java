package husacct.analyse.task.analyser.csharp;

import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.task.analyser.AbstractAnalyser;

import java.util.ArrayList;
import java.util.List;

public class CSharpAnalyser extends AbstractAnalyser{
	
	public List<FamixObject> generateModelFromSource(String sourceFilePath) {
		List<FamixObject> famixObject = new ArrayList<FamixObject>();
		
		//TODO Implement CSharp Logic
		
		return famixObject;
	}

	@Override
	public String getProgrammingLanguage(){
		return "C#";
	}
	
	@Override
	public String getFileExtension() {
		return ".cs";
	}	
	
	
}		

