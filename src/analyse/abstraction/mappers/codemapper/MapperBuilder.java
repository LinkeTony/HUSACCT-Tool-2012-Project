package analyse.abstraction.mappers.codemapper;

import analyse.abstraction.mappers.csharpmapper.CSharpMapper;
import analyse.abstraction.mappers.csharpmapper.CSharpMapperService;
import analyse.abstraction.mappers.javamapper.JavaMapper;
import analyse.abstraction.mappers.javamapper.JavaMapperService;

public class MapperBuilder{
	
	public Object getMapper(String language){
		if(language.equals(JavaMapper.language)){
			JavaMapperService mapper = new JavaMapper();
			return mapper;
		}
		else{
			CSharpMapperService mapper = new CSharpMapper();
			return mapper;
		}
	}
}
