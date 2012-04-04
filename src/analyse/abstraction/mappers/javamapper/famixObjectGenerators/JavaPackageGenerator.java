package analyse.abstraction.mappers.javamapper.famixObjectGenerators;

import javax.naming.directory.InvalidAttributesException;

import org.antlr.runtime.tree.CommonTree;

import analyse.domain.famix.FamixPackage;

public class JavaPackageGenerator {
	
	String token = "";
	String belongsToPackage = "";
	String packageName = "";
	Boolean tokenSet = false;
	FamixPackage famixPackage = new FamixPackage();
	
	public FamixPackage generateFamixPackage(CommonTree tree){
		if (tree != null) {
			if(tree.getType() == 84){
				if(tree.getChild(0).getType() != 15){
					token = tree.getChild(0).toString();
				}else{
					generateFamixPackage((CommonTree) tree.getChild(0));
				}
			}else if(tree.getChild(0) != null && tree.getChild(0).getType() == 164 && tokenSet != true){
				System.out.println("1 packages");	
				belongsToPackage = tree.getChild(0).toString();
				token = tree.getChild(1).toString();
				tokenSet = true;
			}else if(tree.getChild(0) != null && tree.getChild(0).getType() == 15 && tokenSet != true){
				token = tree.getChild(1).toString();
				tokenSet = true;
				generateFamixPackage((CommonTree) tree.getChild(0));				
			}else if (tree.getChild(0) != null && (tree.getChild(0).getType() == 164 || tree.getChild(0).getType() == 15) ){
				if(tree.getChild(0).getType() == 15){
					belongsToPackage = tree.getChild(1).toString() + "." + belongsToPackage; 
					generateFamixPackage((CommonTree) tree.getChild(0));	
				}else{
					belongsToPackage = tree.getChild(1).toString() + "." + belongsToPackage; 
					belongsToPackage = tree.getChild(0).toString() + "." + belongsToPackage; 
				}
			}
			famixPackage.setName(token);
			famixPackage.setUniqueName(belongsToPackage+token);
			famixPackage.setBelongsToPackage(belongsToPackage.toString());
			
		}
		return famixPackage;
	
        	
    }
}
