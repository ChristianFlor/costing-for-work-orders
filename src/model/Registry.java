/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author 
 *
 */
public class Registry {

////////RELATIONS//////////
	
	/**
	 * 
	 */
	private ArrayList<Period> periods;
	/**
	 * 
	 */
	private ArrayList<Period> ordersNotBilled;
	
////////ATRUBUTES//////////
	
	/**
	 * 
	 */
	private double cifRate;
	
////////CONSTRUCTOR//////////

	/**
	 * crea la lista de periodos y crea los 12 periodos
	 */
	public Registry() {
		periods = new ArrayList<Period>(12);
		periods.add(new Period("Enero"));
		periods.add(new Period("Febrero"));
		periods.add(new Period("Marzo"));
		periods.add(new Period("Abril"));
		periods.add(new Period("Mayo"));
		periods.add(new Period("Junio"));
		periods.add(new Period("Julio"));
		periods.add(new Period("Agosto"));
		periods.add(new Period("Septiembre"));
		periods.add(new Period("Octubre"));
		periods.add(new Period("Noviembre"));
		periods.add(new Period("Diciembre"));
	}
	

/////////////////GET and SET/////////////////////////////
	
	/**
	 * 
	 */
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	
	/**
	 * 
	 */
	public ArrayList<Period> getOrdersNotBilled() {
		return ordersNotBilled;
	}
	
	/**
	 * 
	 */
	public double getCifRate() {
		return cifRate;
	}
	/**
	 * 
	 */
	public void setCifRate(double cifRate) {
		this.cifRate = cifRate;
	}
	
	
	
	
}
