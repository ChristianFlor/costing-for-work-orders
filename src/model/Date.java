/**
 * 
 */
package model;

/**
 * @author 
 *
 */
public class Date {

////////ATRUBUTES//////////
	
	/**
	 * representa el dia de la fecha
	 */
	private int day;
	/**
	 * representa el mes de la fecha
	 */
	private int month;
	/**
	 * representa el año de la fecha
	 */
	private int year;

////////CONSTRUCTOR//////////
	
	/**
	 * permite crear un objeto de tipo fecha
	 * 
	 * params
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * retorna el dia de la fecha
	 */
	public int getDay() {
		return day;
	}

	/**
	 * retorna el mes de la fecha
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * retonra el año de la fecha
	 * 
	 */
	public int getYear() {
		return year;
	}
	
	
	
}
