package husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators;

import husacct.analyse.domain.famix.FamixPackage;

import org.antlr.runtime.tree.CommonTree;
public class JavaPackageGenerator extends JavaGenerator{
	
	String name = "";
	String belongsToPackage = "";
	String packageName = "";
	Boolean tokenSet = false;
	FamixPackage famixPackage = new FamixPackage();
	

	public FamixPackage generateFamix(CommonTree packageNode) {
		System.out.println(packageNode.getChild(0));
		if (packageNode != null) {
			if(packageNode.getChild(0).getType() != 15){
				name = packageNode.getChild(0).toString();
			}else{
				generateFamix((CommonTree) packageNode.getChild(0));
			}
			if(packageNode.getChild(0) != null && packageNode.getChild(0).getType() == 164 && tokenSet != true){
				belongsToPackage = packageNode.getChild(0).toString();
				name = packageNode.getChild(1).toString();
				tokenSet = true;
			}else if(packageNode.getChild(0) != null && packageNode.getChild(0).getType() == 15 && tokenSet != true){
				name = packageNode.getChild(1).toString();
				tokenSet = true;
				generateFamix((CommonTree) packageNode.getChild(0));				
			}else if (packageNode.getChild(0) != null && (packageNode.getChild(0).getType() == 164 || packageNode.getChild(0).getType() == 15) ){
				if(packageNode.getChild(0).getType() == 15){
					belongsToPackage = packageNode.getChild(1).toString() + "." + belongsToPackage; 
					generateFamix((CommonTree) packageNode.getChild(0));	
				}else{
					belongsToPackage = packageNode.getChild(1).toString() + "." + belongsToPackage; 
					belongsToPackage = packageNode.getChild(0).toString() + "." + belongsToPackage; 
				}
			}
			famixPackage.setName(name);
			if(belongsToPackage.equals("")){
				famixPackage.setUniqueName(belongsToPackage+"."+name);
			}else{
				famixPackage.setUniqueName(belongsToPackage+"."+name);
			}
			
			famixPackage.setBelongsToPackage(belongsToPackage.toString());
			
		}
		return famixPackage;

	}
}
