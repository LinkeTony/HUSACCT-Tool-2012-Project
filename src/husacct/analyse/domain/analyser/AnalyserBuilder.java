package husacct.analyse.domain.analyser;

import husacct.analyse.abstraction.analyser.AbstractAnalyser;
import husacct.analyse.abstraction.analyser.csharp.CSharpAnalyser;
import husacct.analyse.abstraction.analyser.java.JavaAnalyser;

class AnalyserBuilder{
	
	public AbstractAnalyser getAnalyser(String language){
		AbstractAnalyser applicationAnalyser;
		if(language.equals(new JavaAnalyser().getProgrammingLanguage())){
			applicationAnalyser = new JavaAnalyser();
		}
		else if(language.equals(new CSharpAnalyser().getProgrammingLanguage())){
			applicationAnalyser = new CSharpAnalyser();
		}
		else{
			applicationAnalyser = null;
			//TODO Throw analyserNotFoundException
		}
		return applicationAnalyser;
	}
}
