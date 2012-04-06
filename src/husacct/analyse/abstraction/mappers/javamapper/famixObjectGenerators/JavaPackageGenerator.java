package husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators;

import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.domain.famix.FamixPackage;

import org.antlr.runtime.tree.CommonTree;
public class JavaPackageGenerator implements JavaGenerator{
	
	String token = "";
	String belongsToPackage = "";
	String packageName = "";
	Boolean tokenSet = false;
	FamixPackage famixPackage = new FamixPackage();
	

	@Override
	public FamixObject generateFamix(CommonTree commonTree) {
		if (commonTree != null) {
			if(commonTree.getType() == 84){
				if(commonTree.getChild(0).getType() != 15){
					token = commonTree.getChild(0).toString();
				}else{
					generateFamix((CommonTree) commonTree.getChild(0));
				}
			}else if(commonTree.getChild(0) != null && commonTree.getChild(0).getType() == 164 && tokenSet != true){
				System.out.println("1 packages");	
				belongsToPackage = commonTree.getChild(0).toString();
				token = commonTree.getChild(1).toString();
				tokenSet = true;
			}else if(commonTree.getChild(0) != null && commonTree.getChild(0).getType() == 15 && tokenSet != true){
				token = commonTree.getChild(1).toString();
				tokenSet = true;
				generateFamix((CommonTree) commonTree.getChild(0));				
			}else if (commonTree.getChild(0) != null && (commonTree.getChild(0).getType() == 164 || commonTree.getChild(0).getType() == 15) ){
				if(commonTree.getChild(0).getType() == 15){
					belongsToPackage = commonTree.getChild(1).toString() + "." + belongsToPackage; 
					generateFamix((CommonTree) commonTree.getChild(0));	
				}else{
					belongsToPackage = commonTree.getChild(1).toString() + "." + belongsToPackage; 
					belongsToPackage = commonTree.getChild(0).toString() + "." + belongsToPackage; 
				}
			}
			famixPackage.setName(token);
			famixPackage.setUniqueName(belongsToPackage+token);
			famixPackage.setBelongsToPackage(belongsToPackage.toString());
			
		}
		return famixPackage;

	}
}
