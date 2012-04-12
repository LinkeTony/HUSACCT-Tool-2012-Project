package husacct.analyse.task.analyser;

import husacct.analyse.domain.famix.FamixObject;
import java.util.List;

public abstract class AbstractAnalyser {
	
	public List<FamixObject> analyseApplication(String sourceFilePath){
		return generateModelFromSource(sourceFilePath);
	}
	
	public abstract List<FamixObject> generateModelFromSource(String sourceFilePath);
	public abstract String getProgrammingLanguage();
	public abstract String getFileExtension();
}
