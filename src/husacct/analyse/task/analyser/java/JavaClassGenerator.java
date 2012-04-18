package husacct.analyse.task.analyser.java;

import husacct.analyse.infrastructure.antlr.JavaParser;
import org.antlr.runtime.tree.CommonTree;

class JavaClassGenerator{
	
	private static int classNode = JavaParser.CLASS;
	
	public String packageName = "";
	public String name = "";
	public String uniqueName = "";
	public String belongsToPackage = "";
	public String belongsToClass = "";
	public boolean isInnerClass = false;
	public boolean isAbstract = false; //TODO Implementeren
	
	public JavaClassGenerator(String uniquePackageName){
		this.packageName = uniquePackageName;
	}
	
	public void generateFamix(CommonTree commonTree) {
		this.name = commonTree.getChild(1).toString();
		this.isAbstract = false;
		this.belongsToPackage = this.packageName;
		this.uniqueName = uniqueName + "." + commonTree.getChild(1).toString();
		this.isInnerClass = isInnerClass(commonTree);
	}
	
	
	private boolean hasInnerClasses(CommonTree classTree){
		return classTree.getFirstChildWithType(classNode) != null;
	}
	
	private boolean isInnerClass(CommonTree classTree){
		//TODO Implementeren
		return false;
	}
}
