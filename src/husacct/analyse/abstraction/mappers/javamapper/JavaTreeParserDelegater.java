package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.domain.famix.FamixModel;
import husacct.analyse.infrastructure.antlr.JavaTreeParser;


public class JavaTreeParserDelegater {
	
	FamixModel model = FamixModel.getInstance();
	
	public void delegateFamixObjectGenerators(JavaTreeParser ast) {
	
//		List<CommonTree> children = ast.getChildren();
//		for(CommonTree child : children){
//			if(child.getType() == 84){
//				JavaPackageGenerator generator = new JavaPackageGenerator();
//				FamixPackage famixPackageObject = generator.generateFamixPackage(child);
//				System.out.println(famixPackageObject.toString());
//				try
//				{
//					// TODO Auto-generated catch block
//					model.addObject(famixPackageObject);
//				}
//				catch (InvalidAttributesException e)
//				{
//					
//				}
//			}
		//}
	}
}
