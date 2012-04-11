package husacct.analyse.abstraction.analyser.java;

import husacct.analyse.domain.famix.FamixObject;

import org.antlr.runtime.tree.CommonTree;

abstract class JavaGenerator {
	public abstract FamixObject generateFamix(CommonTree Tree);
}
