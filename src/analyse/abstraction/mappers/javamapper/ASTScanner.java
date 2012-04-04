package analyse.abstraction.mappers.javamapper;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.antlr.runtime.tree.CommonTree;

import analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaPackageGenerator;
import analyse.domain.famix.FamixModel;
import analyse.domain.famix.FamixPackage;

public class ASTScanner {
	FamixModel model = new FamixModel();
	public void generateFamixModelFromAST(CommonTree ast) {
		List<CommonTree> Children = ast.getChildren();
		for(CommonTree child : Children){
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
