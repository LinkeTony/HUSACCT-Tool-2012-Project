package husacct.analyse.abstraction.mappers.javamapper.famixObjectGenerators;

import husacct.analyse.domain.famix.FamixObject;

import org.antlr.runtime.tree.CommonTree;

public interface JavaGenerator {
	public FamixObject generateFamix(CommonTree commonTree);
}
