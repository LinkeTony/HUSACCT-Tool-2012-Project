package husacct.analyse.abstraction.mappers.javamapper;

import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaClassGenerator;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaGenerator;
import husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators.JavaPackageGenerator;
import husacct.analyse.domain.famix.FamixObject;
import husacct.analyse.infrastructure.antlr.JavaTreeParser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;


public class JavaTreeParserDelegater {
	public List<FamixObject> delegateFamixObjectGenerators(JavaTreeParser javaTreeParser) {
		List<FamixObject> famixObjects = new ArrayList<FamixObject>();

		JavaGenerator javaGenerator = new JavaPackageGenerator();
		famixObjects.add(javaGenerator.generateFamix(new CommonTree()));
		javaGenerator = new JavaClassGenerator();
		famixObjects.add(javaGenerator.generateFamix(new CommonTree()));
		return famixObjects;
	}
}
