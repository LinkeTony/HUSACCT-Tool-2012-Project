package analyse.abstraction.mappers.javamapper;

import org.antlr.runtime.tree.CommonTree;

import analyse.abstraction.mappers.codemapper.GenericMapper;

public class JavaMapper implements GenericMapper{
	
	public static String programmingLanguage = "Java";
	JavaASTGenerator astGenerator = new JavaASTGenerator();
	ASTScanner astScanner = new ASTScanner();
	@Override
	public void analyseApplication() {
		// TODO Recursieve functie om door de gehele applicatie heen te lopen; filePath komt van defineservice
		String filePath = "/Users/Erik/Documents/Hogeschool Utrecht/Jaar 3/Specialisatie/ThemaOpdracht/Soccerapp/Workspace/DefinitionService/src/nl/torpedo/definitionservice/DefinitionService.java";
		
		
		try {
			CommonTree ast = astGenerator.generateAST(filePath);
			astScanner.generateFamixModelFromAST(ast);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
