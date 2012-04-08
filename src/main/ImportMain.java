package main;

import javax.swing.UIManager;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaImportGenerator;
import husacct.analyse.domain.famix.FamixImport;
import husacct.analyse.infrastructure.antlr.JavaLexer;
import husacct.analyse.infrastructure.antlr.JavaParser;
import husacct.analyse.infrastructure.antlr.JavaParser.compilationUnit_return;
import husacct.analyse.presentation.ApplicationNavigator;

public class ImportMain {

	public static void main(String[] args){
		try {
			testImport("benchmark_application/presentation/annotations/Copyright.java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testImport(String filePath) throws Exception{
		CommonTree completeFileTree = generateTree(filePath);
		JavaImportGenerator importGenerator = new JavaImportGenerator();
		CommonTree importTree = (CommonTree)completeFileTree.getFirstChildWithType(JavaImportGenerator.nodeType);
		FamixImport importObject = importGenerator.generateFamixImport(importTree);
		System.out.println(importObject.toString());
		System.out.println();
		System.out.println(importObject.getTestDetails(true));
	}
	
	//--------Onderstaand gedeelte gaat later weg, is alleen om de tree op te bouwen---//
	
	public static CommonTree generateTree(String filePath){
		try{
			CharStream c = new ANTLRFileStream(filePath,"UTF-8");
	        Lexer lexer = new JavaLexer(c);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        JavaParser parser = new JavaParser(tokens);
	        parser.setTreeAdaptor(adaptor);
	        compilationUnit_return importAst = parser.compilationUnit();
	        return (CommonTree) importAst.getTree();
		}
		catch(Exception e){
			System.out.println("Something went wrong...\n\n" + e.getMessage());
			return null;
		}
	}
	
	static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(int tokenType, Token payload) {
            CommonTree tree = new CommonTree(payload);
            return tree;
        }
    };
    
    private static void startUI() throws Exception{
    	try {
        	javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        	 //todo noting
        }
		new ApplicationNavigator();
    }
	
}
