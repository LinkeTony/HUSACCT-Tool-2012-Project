package husacct.analyse.abstraction.analyser.java;

import husacct.analyse.abstraction.analyser.AbstractAnalyser;
import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.infrastructure.antlr.JavaParser;
import java.util.ArrayList;
import java.util.List;

public class JavaAnalyser extends AbstractAnalyser{
	
	public List<FamixObject> generateModelFromSource(String sourceFilePath) {
		List<FamixObject> famixObject = new ArrayList<FamixObject>();
		JavaTreeParserBuilder javaTreeParserBuilder = new JavaTreeParserBuilder();
		JavaTreeConvertController javaTreeParserDelegater = new JavaTreeConvertController();
		JavaParser javaParser;
		try {
			javaParser = javaTreeParserBuilder.buildTreeParser(sourceFilePath);
			famixObject = javaTreeParserDelegater.delegateFamixObjectGenerators(javaParser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return famixObject;
	}
	
	@Override
	public String getProgrammingLanguage(){
		return "Java";
	}

	@Override
	public String getFileExtension() {
		return ".java";
	}	
}		

