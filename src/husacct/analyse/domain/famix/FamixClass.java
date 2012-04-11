package husacct.analyse.domain.famix;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Class. A Class represents the definition of a class in source code.
 * What exactly constitutes such a definition is a language dependent issue.
 * Class is a concrete class inheriting from Entity. Besides inherited
 * attributes, it has the following attributes:
 */
public class FamixClass extends FamixEntity
{

	/**
	 * If the class is an inner class in a class
	 */
	boolean isInnerClass = false;
	
	/**
	 * The is abstract. Is a predicate telling whether the class is declared
	 * abstract. Abstract classes are important in OO modelling, but how they
	 * are recognised in source code is a language dependent issue.
	 */
	boolean isAbstract;

	/**
	 * The belongs to package. Is the unique name of the package defining the
	 * scope of the class. A null belongsToPackage is allowed, it means that the
	 * class has global scope. The belongsToPackage concatenated with the name
	 * of the class must provide a unique name for that class within the model.
	 */
	String belongsToPackage;

	/**
	 * A list of inner classes
	 * 
	 * @return list of inner classes
	 */
	public List<FamixClass> innerClasses = new ArrayList<FamixClass>();
	
	/**
	 * Checks if is abstract.
	 * 
	 * @return true, if is abstract
	 */
	public boolean isAbstract()
	{
		return isAbstract;
	}
	
	/**
	 * Sets the abstract.
	 * 
	 * @param isAbstract the new abstract
	 */
	public void setAbstract(boolean isAbstract)
	{
		this.isAbstract = isAbstract;
	}

	/**
	 * Gets the belongs to package.
	 * 
	 * @return the belongs to package
	 */
	public String getBelongsToPackage()
	{
		return belongsToPackage;
	}

	/**
	 * Sets the belongs to package.
	 * 
	 * @param belongsToPackage the new belongs to package
	 */
	public void setBelongsToPackage(String belongsToPackage)
	{
		this.belongsToPackage = belongsToPackage;
	}
	
	/**
	 * Gets the list of inner classes
	 * 
	 */
	public List<FamixClass> getInnerClasses(){
		return this.innerClasses;
	}
	
	/**
	 * Sets the list of inner classes
	 * 
	 * @param innerClassList
	 */
	public void setInnerClasses(List<FamixClass> innerClassList){
		this.innerClasses = innerClassList;
	}
	
	/**
	 * Sets the attribute isInnerClass
	 * 
	 * @param isInnerClass
	 */
	public void setIsInnerClass(boolean isInnerClass){
		this.isInnerClass = isInnerClass;
	}
	
	/**
	 * Checks if the class has inner classes
	 * @return
	 */
	public boolean hasInnerClasses(){
		return innerClasses.size() > 0;
	}
	
	/**
	 * Gets the list of inner classes
	 * 
	 */
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
		if(hasInnerClasses()){
			classRepresentation += "\nInner Classes: \n";
			for(FamixClass fClass: this.getInnerClasses()){
				classRepresentation += "\n" + fClass.toString();
			}
		}
		if(isInnerClass) classRepresentation += "true";
		else classRepresentation += "false";
		classRepresentation += "\n\n";
		return classRepresentation;
	}
}
