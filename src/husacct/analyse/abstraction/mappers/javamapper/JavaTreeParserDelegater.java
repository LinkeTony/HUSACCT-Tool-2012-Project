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
import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;


public class JavaTreeParserDelegater {
	FamixPackage  famixPackageObject;
	FamixClass famixClassObject;
	List<FamixObject> famixObjects = new ArrayList<FamixObject>();
	final int packageType = 84;
	final int classType = 61;
	final int classTopLevelScopeType = 123;
	final int importToken = 15;
	Tree packageTree;
	Tree classTree;
	Tree classTopLevelScopeTree;
	public List<FamixObject> delegateFamixObjectGenerators(JavaParser javaParser) throws RecognitionException {
		
		
		
		compilationUnit_return compilationUnit = javaParser.compilationUnit();
		CommonTree compilationUnitTree = (CommonTree) compilationUnit.getTree();
		//List<CommonTree> children = compilationUnitTree.getChildren();
		packageTree = compilationUnitTree.getFirstChildWithType(packageType);
		classTree = compilationUnitTree.getFirstChildWithType(classType);
//		for(CommonTree child : children){
//			checkChildren(child);
//		}
		if(packageTree != null){
			delegatePackageTree(packageTree);
		}
		if(classTree != null){
			delegateClassTree(classTree);
		}
		if(classTopLevelScopeTree != null){
			
		}
		return famixObjects;
	}
	public void delegatePackageTree(Tree packageTree){
		JavaPackageGenerator javaPackageGenerator = new JavaPackageGenerator();
		famixPackageObject = javaPackageGenerator.generateFamix((CommonTree) packageTree.getChild(0));
		famixObjects.add(famixPackageObject);
	}
	public void delegateClassTree(Tree classTree){
		JavaClassGenerator javaClassGenerator = new JavaClassGenerator();
		javaClassGenerator.setPackageNameAndUniqueName(famixPackageObject.getName(), famixPackageObject.getUniqueName());
		famixClassObject = javaClassGenerator.generateFamix((CommonTree) classTree);
		famixObjects.add(famixClassObject);
		Tree classTopLevelScopeTreeChild = ((BaseTree) classTree).getFirstChildWithType(classTopLevelScopeType);
		if(classTopLevelScopeTree != null){
			classTopLevelScopeTree = classTopLevelScopeTreeChild;
		}
		
		//checkChildren((CommonTree)classTree.getChild((classTree.getChildCount()-1)));
	}
	public void checkChildren(Tree tree){
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
			
			
		}
		if(tree.getText() == "CLASS_TOP_LEVEL_SCOPE"){
			
		}
		
			
	}
		
}
