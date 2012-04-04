package analyse.abstraction.codemapper;

import analyse.abstraction.csharpmapper.CSharpMapper;
import analyse.abstraction.csharpmapper.CSharpMapperService;
import analyse.abstraction.javamapper.JavaMapper;
import analyse.abstraction.javamapper.JavaMapperService;

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
