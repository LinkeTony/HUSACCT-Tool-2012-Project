package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaPackageGenerator;
import husacct.analyse.domain.famix.FamixModel;
import husacct.analyse.domain.famix.FamixPackage;
import husacct.analyse.infrastructure.antlr.JavaTreeParser;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.antlr.runtime.tree.CommonTree;


public class ASTScanner {
	
	FamixModel model = FamixModel.getInstance();
	
	public void generateFamixModelFromAST(JavaTreeParser ast) {
	
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
