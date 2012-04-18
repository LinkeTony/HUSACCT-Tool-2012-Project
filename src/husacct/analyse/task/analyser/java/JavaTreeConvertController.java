package husacct.analyse.task.analyser.java;

import husacct.analyse.domain.FamixModelServiceImpl;
import husacct.analyse.domain.ModelService;
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

class JavaTreeConvertController {
	
	private ModelService modelService = new FamixModelServiceImpl();
	private String theClass = null;
	private String thePackage = null;
	
	FamixPackage  famixPackageObject;
	FamixClass famixClassObject;
	FamixMethod famixMethodObject;
	List<FamixObject> famixObjects = new ArrayList<FamixObject>();
	
	Tree packageTree;
	Tree classTree;
	Tree importTree;
	Tree classTopLevelScopeTree;
	Tree methodTree;
	
	public void delegateFamixObjectGenerators(JavaParser javaParser) throws RecognitionException {
		
		compilationUnit_return compilationUnit = javaParser.compilationUnit();
		CommonTree compilationUnitTree = (CommonTree) compilationUnit.getTree();

		packageTree = compilationUnitTree.getFirstChildWithType(JavaParser.PACKAGE);
		classTree = compilationUnitTree.getFirstChildWithType(JavaParser.CLASS);
		
		if(packageTree != null){
			delegatePackage(packageTree);
		}
		
		if(classTree != null){
			delegateClass(classTree);
		}
		
//		if (hasMethodes(classTree)){
//			methodTree = classTree.getChild(2).getChild(1);
//		}
		
		//TODO : skipping interface and annotations, need to added later
//		if(classTree != null && hasType(compilationUnitTree, JavaParser.IMPORT)){
//			List<CommonTree> importTrees = this.getAllImportTrees(compilationUnitTree);
//			for(CommonTree importTree : importTrees){
//				delegateImport(importTree, famixClassObject.getUniqueName());
//			}
//		}
//		
//		if(classTopLevelScopeTree != null){
//			delegateTopLevelScopeTree(classTopLevelScopeTree);
//		}
//	
//                if (methodTree != null){
//                        delegateMethodTree(methodTree);
//                }
	
	}
	
	private List<CommonTree> getAllImportTrees(CommonTree baseTree){
		List<CommonTree> importTrees = new ArrayList<CommonTree>();
		CommonTree importTree = (CommonTree)baseTree.getFirstChildWithType(JavaParser.IMPORT);
		if(importTree != null){
			importTrees.add(importTree);
			baseTree.deleteChild(importTree.childIndex);
			if(hasType(baseTree, JavaParser.IMPORT)){
				List<CommonTree> otherImportTrees = getAllImportTrees(baseTree);
				for(CommonTree importNode: otherImportTrees){
					importTrees.add(importNode);
				}
			}
		}
		return importTrees;
	}
	
	public void delegatePackage(Tree packageTree){
		JavaPackageGenerator javaPackageGenerator = new JavaPackageGenerator();
		javaPackageGenerator.generateFamix((CommonTree)packageTree);
		String unique = javaPackageGenerator.getUniqueName();
		String name = javaPackageGenerator.getName();
		String belongsToPackage = javaPackageGenerator.belongsToPackage;
		this.thePackage = belongsToPackage;
		modelService.createPackage(unique, belongsToPackage, name);
	}
	
	public void delegateClass(Tree classTree){
		JavaClassGenerator javaClassGenerator = new JavaClassGenerator(thePackage);
		javaClassGenerator.generateFamix((CommonTree)classTree);
		String belongsToPackage = javaClassGenerator.belongsToPackage;
		String uniqueName = javaClassGenerator.uniqueName;
		String name = javaClassGenerator.name;
		boolean isInnerClass = javaClassGenerator.isInnerClass;
		boolean isAbstract = javaClassGenerator.isAbstract;
		if(isInnerClass){
			String belongsToClass = javaClassGenerator.belongsToClass;
			modelService.createClass(uniqueName, name, belongsToPackage, isAbstract, isInnerClass, belongsToClass);
		}
		else{
			modelService.createClass(uniqueName, name, belongsToPackage, isAbstract, isInnerClass);
		}
//		Tree classTopLevelScopeTreeChild = ((BaseTree) classTree).getFirstChildWithType(JavaParser.CLASS_TOP_LEVEL_SCOPE);
//		if(classTopLevelScopeTree != null){
//			classTopLevelScopeTree = classTopLevelScopeTreeChild;
//		}
	}
	
	public void delegateImport(CommonTree importTree, String belongsToClass){
		JavaImportGenerator javaImportGenerator = new JavaImportGenerator();
		
//		FamixObject importObject = javaImportGenerator.generateFamixImport(importTree, belongsToClass);
//		famixObjects.add(importObject);
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

	public void delegateAttribute(Tree scopeTree, FamixClass classObject){
		@SuppressWarnings("unused")
		JavaAttributeGenerator javaAttributeGenerator = new JavaAttributeGenerator();
		//TODO Implement Attribute-generator
		//javaAttributeGenerator.generateFamix(scopeTree);
	}

	public void delegateTopLevelScopeTree(Tree scopeTree){
		System.out.println(scopeTree.getChildCount());
	}	
	
	private boolean hasType(CommonTree completeTree, int nodeType){
		return completeTree.getFirstChildWithType(nodeType) != null;
	}
}
