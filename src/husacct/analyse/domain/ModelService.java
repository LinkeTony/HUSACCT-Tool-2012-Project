package husacct.analyse.domain;

public interface ModelService {
	
	public void createPackage(String uniqieName, String belongsToPackage, String name);
	public void createImport(String uniqueName, String belongsTo, String name);
	public void createClass(String uniqueName, String name, String belongsToPackage, boolean isAbstract, boolean isInnerClass);
	public void createClass(String uniqueName, String name, String belongsToPackage, boolean isAbstract, boolean isInnerClass, String belongsToClass);
	
}
