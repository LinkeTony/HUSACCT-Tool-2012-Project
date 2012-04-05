package main;

import husacct.analyse.AnalyseServiceImpl;
import husacct.analyse.IAnalyseService;
import husacct.analyse.abstraction.mappers.codemapper.CodeMapper;
import husacct.analyse.abstraction.mappers.codemapper.CodeMapperService;

public class Main {

    public static void main(String[] args) throws Exception {
    	IAnalyseService analyseService = new AnalyseServiceImpl();
    	analyseService.analyseApplication();
    }
    
}