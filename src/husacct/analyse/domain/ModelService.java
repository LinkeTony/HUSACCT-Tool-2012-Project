package husacct.analyse.domain;

public interface ModelService {
	
	public void createPackage(String uniqieName, String belongsToPackage, String name);
	public void createImport(String uniqueName, String belongsTo, String name);
}
