package husacct.analyse.domain.famix;

/**
 * The Class Class. A Class represents the definition of a class in source code.
 * What exactly constitutes such a definition is a language dependent issue.
 * Class is a concrete class inheriting from Entity. Besides inherited
 * attributes, it has the following attributes:
 */
public class FamixClass extends FamixEntity{

	boolean isInnerClass = false;
	boolean isAbstract;
	String belongsToPackage;
	String belongsToClass = null;
	
	public boolean isAbstract(){
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract){
		this.isAbstract = isAbstract;
	}
	
	public String getBelongsToPackage(){
		return belongsToPackage;
	}
	
	public void setBelongsToPackage(String belongsToPackage)
	{
		this.belongsToPackage = belongsToPackage;
	}
	
	public void setBelongsToClass(String parentsUniqueClassname){
		this.belongsToClass = parentsUniqueClassname;
	}
	
	public String getBelongsToClass(){
		return this.belongsToClass;
	}
	
	public void setIsInnerClass(boolean isInnerClass){
		this.isInnerClass = isInnerClass;
	}
	
	public boolean isInnerClass(){
		return this.isInnerClass;
	}
	
	@Override
	public boolean equals(Object object)
	{
		return object instanceof FamixClass && getUniqueName().equals(((FamixClass) object).getUniqueName());
	}
	
	public String toString(){
		String classRepresentation = "";
		classRepresentation += "\nUnique Name: " + this.getUniqueName();
		classRepresentation += "\nBelongs to Package: " + this.getBelongsToPackage();
		classRepresentation += "\nName: " + this.getName();
		classRepresentation += "\nIs Inner Class: ";
		if(isInnerClass) classRepresentation += "true";
		else classRepresentation += "false";
		classRepresentation += "\n\n";
		return classRepresentation;
	}
}
