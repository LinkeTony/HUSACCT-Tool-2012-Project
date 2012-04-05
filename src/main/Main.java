package main;

import analyse.abstraction.mappers.codemapper.CodeMapper;
import analyse.abstraction.mappers.codemapper.CodeMapperService;

public class Main {

    public static void main(String[] args) throws Exception {
    	CodeMapperService mapper = new CodeMapper();
    	mapper.analyseApplication();
    }
    
}