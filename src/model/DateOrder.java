/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a date
 */
public class DateOrder implements Comparable<DateOrder>{

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
	public DateOrder(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String toString() {
		return year+"-"+addZero(month)+"-"+addZero(day);
	}
	public String addZero(int n) {
		String msg="";
		if(n<10) {
			msg="0"+n;
		}else {
			msg=""+n;
		}
		return msg;
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

	public String compare() {
		return year+"-"+month+"-"+day;
	}
	@Override
	public int compareTo(DateOrder o){
		int comparation = 0;
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date dt_1;
	    Date dt_2;
		try {
			dt_1 = objSDF.parse(compare());
			dt_2 = objSDF.parse(o.compare());
			comparation=dt_1.compareTo(dt_2);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	   
		return comparation;
	}
	
	
	
}
