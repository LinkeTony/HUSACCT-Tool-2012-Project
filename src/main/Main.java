package main;

import husacct.analyse.AnalyseServiceImpl;
import husacct.analyse.IAnalyseService;

public class Main {

    public static void main(String[] args) throws Exception {
    	IAnalyseService analyseService = new AnalyseServiceImpl();
    	System.out.println("All possible languages:");
    	for(String lang : analyseService.getAvailableLanguages()){
    		System.out.println(lang);
    	}
    	System.out.println();
    	analyseService.analyseApplication();
    }
    
}