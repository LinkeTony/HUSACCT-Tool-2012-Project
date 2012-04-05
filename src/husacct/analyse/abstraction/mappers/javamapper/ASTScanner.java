package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaPackageGenerator;
import husacct.analyse.domain.famix.FamixModel;
import husacct.analyse.domain.famix.FamixPackage;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.antlr.runtime.tree.CommonTree;


public class ASTScanner {
	
	FamixModel model = new FamixModel();
	
	public void generateFamixModelFromAST(CommonTree ast) {
	
		List<CommonTree> children = ast.getChildren();
		for(CommonTree child : children){
			if(child.getType() == 84){
				JavaPackageGenerator generator = new JavaPackageGenerator();
				FamixPackage famixPackageObject = generator.generateFamixPackage(child);
				System.out.println(famixPackageObject.toString());
				try
				{
					// TODO Auto-generated catch block
					model.addObject(famixPackageObject);
				}
				catch (InvalidAttributesException e)
				{
					
				}
			}
		}
	}
}
