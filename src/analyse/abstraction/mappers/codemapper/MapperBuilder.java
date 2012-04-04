package analyse.abstraction.mappers.codemapper;

import analyse.abstraction.mappers.csharpmapper.CSharpMapper;
import analyse.abstraction.mappers.javamapper.JavaMapper;

public class MapperBuilder{
	
	public GenericMapper getMapper(String language){
		GenericMapper mapper;
		if(language.toLowerCase().equals(JavaMapper.programmingLanguage.toLowerCase())){
			mapper = new JavaMapper();
			return mapper;
		}
		else{
			mapper = new CSharpMapper();
			return mapper;
		}
	}
}
