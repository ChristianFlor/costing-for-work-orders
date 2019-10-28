/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

/**
 * This class represents a date
 */
public class Date {

////////ATRUBUTES//////////
	
	/**
	 * Represents the date's day
	 */
	private int day;
	/**
	 * Represents the date's month
	 */
	private int month;
	/**
	 * Represents the date's year
	 */
	private int year;

////////CONSTRUCTOR//////////
	
	/**
	 * permite crear un objeto de tipo fecha
	 * Create an object 
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
