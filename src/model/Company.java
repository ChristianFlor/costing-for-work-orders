/**
 *  
 */
package model;

/**
 * @author 
 *
 */
public class Company {
	
////////CONTANTS//////////
	
	/**
	 * 
	 */
	public final static String MONEY = "$";
	/**
	 * 
	 */
	public final static String HOURS = "horas";

////////RELATIONS//////////
	
	/**
	 * 
	 */
	public Registry registry;
	
////////ATRUBUTES//////////
	
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private double base;
	/**
	 * 
	 */
	private String baseType;
	/**
	 * 
	 */
	private double budgtedCif;

////////CONSTRUCTOR//////////
	
	/**
	 * 
	 */
	public Company() {
		
	}
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * 
	 */
	public Registry getRegistry() {
		return registry;
	}
	
	/**
	 * 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public double getBase() {
		return base;
	}
	/**
	 * 
	 */
	public void setBase(double base) {
		this.base = base;
	}
	
	/**
	 * 
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 */
	public String getBaseType() {
		return baseType;
	}
	/**
	 * 
	 */
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}
	
	/**
	 * 
	 */
	public double getBudgtedCif() {
		return budgtedCif;
	}
	/**
	 * 
	 */
	public void setBudgtedCif(double budgtedCif) {
		this.budgtedCif = budgtedCif;
	}
	
	
}
