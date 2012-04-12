package husacct.analyse.task.analyser.java;

import java.util.ArrayList;
import java.util.List;

import husacct.analyse.domain.FamixModelServiceImpl;
import husacct.analyse.domain.ModelService;
import husacct.analyse.domain.famix.FamixClass;
import husacct.analyse.infrastructure.antlr.JavaParser;
import org.antlr.runtime.tree.CommonTree;

class JavaClassGenerator{
	
	FamixClass famixClass = new FamixClass();
	String packageName = "";
	String uniqueName = "";
	static int classNode = JavaParser.CLASS;
		
	public FamixClass generateFamix(CommonTree commonTree) {
		famixClass.setName(commonTree.getChild(1).toString());
		famixClass.setAbstract(false);
		famixClass.setBelongsToPackage(this.packageName);
		famixClass.setUniqueName(uniqueName+"."+ commonTree.getChild(1).toString());
		famixClass.setInnerClasses(createInnerClasses(commonTree));
		return famixClass;
	}
	
	private List<FamixClass> createInnerClasses(CommonTree classTree){
		List<FamixClass> innerClassList = new ArrayList<FamixClass>();
		if(hasInnerClasses(classTree)){
			CommonTree innerClassTree = (CommonTree)classTree.getFirstChildWithType(classNode);
			FamixClass innerClassObject = generateFamix(innerClassTree);
			innerClassObject.setIsInnerClass(true);
			innerClassList.add(innerClassObject);
			classTree.deleteChild(innerClassTree.childIndex);
			for(FamixClass otherInnerClass:createInnerClasses(classTree)){
				innerClassList.add(otherInnerClass);
			}
		}
		return innerClassList;
	}
	
	private boolean hasInnerClasses(CommonTree classTree){
//		System.out.println(classTree.toStringTree());
		return classTree.getFirstChildWithType(classNode) != null;
//		List<CommonTree> treeDetails = classTree.getChildren();
//		System.out.println(treeDetails);
//		for(CommonTree detailTree : treeDetails){
//			if(detailTree.getChildren() != null){
//				for(CommonTree moreDetailedTree: (List<CommonTree>)detailTree.getChildren()){
//					System.out.println(moreDetailedTree);
//				}
//			}
//		}
//		return false;
	}
	
	public void setPackageNameAndUniqueName(String packageName, String uniqueName){
		this.packageName = packageName;
		this.uniqueName = uniqueName;
	}
}
