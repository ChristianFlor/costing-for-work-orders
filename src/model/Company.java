/**
 *  
 */
package model;

/**
 * @author Natalia Isabel Gonzalez Murillo
 * @author Christian David Flor
 *
 */
public class Company {
	
////////CONTANTS//////////
	
	/**
	 * una contante para defnir los terminos de la base, si esta defenida por dinero
	 */
	public final static String MONEY = "$";
	/**
	 * una contante para defnir los terminos de la base, si esta definida en horas
	 */
	public final static String HOURS = "horas";

////////RELATIONS//////////
	
	/**
	 * una relacion que representa el registro de las ordenes de la empresa
	 */
	public Registry registry;
	
////////ATRUBUTES//////////
	
	/**
	 * representa el nombre de la compañia
	 */
	private String name;
	/**
	 * es la descripcion acerca del enfoque de la empresa
	 */
	private String description;
	/**
	 * representa el valor de la base
	 */
	private double base;
	/**
	 * representa el tipo de base (dinero u horas)
	 */
	private String baseType;
	/**
	 * representa el cif presupuestado
	 */
	private double budgtedCif;

////////CONSTRUCTOR//////////
	
	/**
	 * permite crear un objeto de tipo Company
	 */
	public Company() {
		
	}
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * @return the company's registry
	 */
	public Registry getRegistry() {
		return registry;
	}
	
	/**
	 * @return the company's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Change the company's names
	 * @param name is the new name for the company
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the base*******
	 */
	public double getBase() {
		return base;
	}
	/**
	 * Change the base
	 * @param base is the new base
	 */
	public void setBase(double base) {
		this.base = base;
	}
	
	/**
	 * @return the company's description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Change the company's description
	 * @param description is the new description for the company
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the base type
	 */
	public String getBaseType() {
		return baseType;
	}
	/**
	 * Change the base type
	 * @param baseType is the new company's base type 
	 */
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}
	
	/**
	 * @return the budgeted CIF
	 */
	public double getBudgtedCif() {
		return budgtedCif;
	}
	/**
	 * Change the budgeted CIF
	 * @param busgetedCif is the new company's budgeted CIF
	 */
	public void setBudgtedCif(double budgtedCif) {
		this.budgtedCif = budgtedCif;
	}
	
	
}
