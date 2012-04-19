package husacct.analyse.task.analyser.java;

import husacct.analyse.domain.FamixModelServiceImpl;
import husacct.analyse.domain.ModelService;
import husacct.analyse.infrastructure.antlr.JavaParser;
import org.antlr.runtime.tree.CommonTree;

class JavaClassGenerator{
	
	private ModelService modelService = new FamixModelServiceImpl();
	private static int classNode = JavaParser.CLASS;
	
	private String name = "";
	private String uniqueName = "";
	private String belongsToPackage = "";
	
	private String belongsToClass = "";
	private boolean isInnerClass = false; //TODO Goed implementeren. 
	private boolean isAbstract = false; //TODO Implementeren
	
	public JavaClassGenerator(String uniquePackageName){
		this.belongsToPackage = uniquePackageName;
	}
	
	public void generateFamix(CommonTree commonTree) {
		this.name = commonTree.getChild(1).toString();
		this.uniqueName = belongsToPackage + "." + commonTree.getChild(1).toString();
		this.isInnerClass = isInnerClass(commonTree);
		if(isInnerClass){
			modelService.createClass(uniqueName, name, belongsToPackage, isAbstract, isInnerClass);
		}else{
			modelService.createClass(uniqueName, name, belongsToPackage, isAbstract, isInnerClass);
		}
	}
	
	@SuppressWarnings("unused")
	private boolean hasInnerClasses(CommonTree classTree){
		return classTree.getFirstChildWithType(classNode) != null;
	}
	
	private boolean isInnerClass(CommonTree classTree){
		return false;
	}
}
