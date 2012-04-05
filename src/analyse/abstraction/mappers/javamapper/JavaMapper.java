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
		String filePath = "/Users/Thijmen/Documents/project/salarySystem_refactored/src/Employees/ExEmployees/test/test2/test3/Test3.java";
		
		
		try {
			CommonTree ast = astGenerator.generateAST(filePath);
			astScanner.generateFamixModelFromAST(ast);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
