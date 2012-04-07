package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaClassGenerator;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaPackageGenerator;
import husacct.analyse.domain.famix.FamixClass;
import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.domain.famix.FamixPackage;
import husacct.analyse.infrastructure.antlr.JavaParser;
import husacct.analyse.infrastructure.antlr.JavaParser.compilationUnit_return;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;


public class JavaTreeParserDelegater {
	FamixPackage  famixPackageObject;
	FamixClass famixClassObject;
	List<FamixObject> famixObjects = new ArrayList<FamixObject>();
	public List<FamixObject> delegateFamixObjectGenerators(JavaParser javaParser) throws RecognitionException {
		
		
		
		compilationUnit_return compilationUnit = javaParser.compilationUnit();
		CommonTree compilationUnitTree = (CommonTree) compilationUnit.getTree();
		List<CommonTree> children = compilationUnitTree.getChildren();
		for(CommonTree child : children){
			checkChildren(child);
		}
		return famixObjects;
	}
	public void checkChildren(CommonTree tree){
		System.out.println(tree.getText());
		if(tree.getText().equals("ANNOTATION_LIST")){
			//iets
		}
		if(tree.getText().equals("package")){
			JavaPackageGenerator javaPackageGenerator = new JavaPackageGenerator();
			famixPackageObject = javaPackageGenerator.generateFamix((CommonTree) tree.getChild(0));
			famixObjects.add(famixPackageObject);
		}
		if(tree.getText() == "class"){
			JavaClassGenerator javaClassGenerator = new JavaClassGenerator();
			javaClassGenerator.setPackageNameAndUniqueName(famixPackageObject.getName(), famixPackageObject.getUniqueName());
			famixClassObject = javaClassGenerator.generateFamix((CommonTree) tree);
			famixObjects.add(famixClassObject);
			checkChildren((CommonTree)tree.getChild(2));
			
		}
		if(tree.getText() == "CLASS_TOP_LEVEL_SCOPE"){
			
		}
		
			
	}
		
}
