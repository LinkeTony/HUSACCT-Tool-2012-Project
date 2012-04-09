package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaAttributeGenerator;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaClassGenerator;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaMethodGenerator;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaPackageGenerator;
import husacct.analyse.domain.famix.FamixClass;
import husacct.analyse.domain.famix.FamixMethod;
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
	FamixMethod famixMethodObject;
	List<FamixObject> famixObjects = new ArrayList<FamixObject>();
	final int packageType = 84;
	final int classType = 61;
	final int classTopLevelScopeType = 123;
	final int importToken = 15;
	final int FUNCTION_METHOD_DECL = 136;
	Tree packageTree;
	Tree classTree;
	Tree classTopLevelScopeTree;
	Tree methodTree;

	public List<FamixObject> delegateFamixObjectGenerators(JavaParser javaParser) throws RecognitionException {
		compilationUnit_return compilationUnit = javaParser.compilationUnit();
		CommonTree compilationUnitTree = (CommonTree) compilationUnit.getTree();

		packageTree = compilationUnitTree.getFirstChildWithType(packageType);
		classTree = compilationUnitTree.getFirstChildWithType(classType);

		if (hasMethodes(classTree)){
			methodTree = classTree.getChild(2).getChild(1);
		}
		if(packageTree != null){
			delegatePackage(packageTree);
		}
		if(classTree != null){
			delegateClass(classTree);
		}
		if(classTopLevelScopeTree != null){
			delegateTopLevelScopeTree(classTopLevelScopeTree);
		}
		if (methodTree != null){
			delegateMethodTree(methodTree);
		}
		return famixObjects;
	}

	private boolean hasMethodes(Tree classTree) {
		if (classTree != null) {
			if (classTree.getChildCount() == 3) {
				if (classTree.getChild(2).getChildCount() > 0){
					return true;
				}
			}
		}
		return false;
	}

	private void delegateMethodTree(Tree methodTree) {
		JavaMethodGenerator javaMethodGenerator = new JavaMethodGenerator();
		javaMethodGenerator.setFamixClassObject(famixClassObject);
		famixMethodObject = javaMethodGenerator.generateFamix((CommonTree) methodTree);
		
		famixObjects.add(famixMethodObject);

	}

	public void delegatePackage(Tree packageTree){
		JavaPackageGenerator javaPackageGenerator = new JavaPackageGenerator();
		famixPackageObject = javaPackageGenerator.generateFamix((CommonTree) packageTree.getChild(0));
		famixObjects.add(famixPackageObject);
	}

	public void delegateClass(Tree classTree){
		JavaClassGenerator javaClassGenerator = new JavaClassGenerator();

		javaClassGenerator.setPackageNameAndUniqueName(famixPackageObject.getName(), famixPackageObject.getUniqueName());
		famixClassObject = javaClassGenerator.generateFamix((CommonTree) classTree);
		famixObjects.add(famixClassObject);
		Tree classTopLevelScopeTreeChild = ((BaseTree) classTree).getFirstChildWithType(classTopLevelScopeType);
		if(classTopLevelScopeTree != null){
			classTopLevelScopeTree = classTopLevelScopeTreeChild;
		}	
	}

	public void delegateAttribute(Tree scopeTree, FamixClass classObject){
		JavaAttributeGenerator javaAttributeGenerator = new JavaAttributeGenerator();
		//javaAttributeGenerator.generateFamix(scopeTree);
	}

	public void delegateTopLevelScopeTree(Tree scopeTree){
		System.out.println(scopeTree.getChildCount());
	}	
}
