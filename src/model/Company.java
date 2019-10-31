/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * This class represents a company
 */
public class Company {
	
////////CONTANTS//////////
	public static final String DATA_PATH = "data"+File.separator+"companies.dat";
	/**
	 * It is a constant for define the base term (if it is defined for money)
	 */
	public final static String MONEY = "$";
	/**
	 * It is a constant for define the base term (if it is defined for hours)
	 */
	public final static String HOURS = "horas";

////////RELATIONS//////////
	
	/**
	 * It is a relation that represents the company's registry
	 */
	public Registry registry;
	
////////ATRUBUTES//////////
	
	/**
	 * Is the company's names
	 */
	private String name;
	/**
	 * Is the description about the company's approach
	 */
	private String description;
	/**
	 * Is the base value
	 */
	private double base;
	/**
	 * Is the base type (money or hours)
	 */
	private String baseType;
	/**
	 * Is the budget CIF
	 */
	private double budgtedCif;

////////CONSTRUCTOR//////////
	
	/**
	 * Create an object of Company type
	 */
	public Company( String name, String description, String baseType, double base , double budgtedCif) {
		super();
		registry = new Registry();
		this.name = name;
		this.description = description;
		this.base = base;
		this.baseType = baseType;
		this.budgtedCif = budgtedCif;
	}
	
	public void save(String path) throws IOException {
		PrintWriter pw = new PrintWriter(new File(path));
		String data = "name"+ name+"\n"+"description: "+description;
		
		pw.print(data);
		pw.close();
		File f = new File(DATA_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(registry);
		oos.close();
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
