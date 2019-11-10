/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.io.Serializable;

/**
 * This class represents an order
 */
public class Order implements Comparable<Order>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
////////RELATIONS//////////
	
	/**
	 * It represents the order start date
	 */
	private DateOrder start;
	/**
	 * It represents the order end date
	 */
	private DateOrder finish;
	
////////ATRUBUTES//////////
	
	/**
	 * It represents the order code
	 */
	private String id;
	/**
	 * It represents the cost of direct order material
	 */
	private double MD;
	/**
	 * It represents the cost of direct order labor
	 */
	private double MOD;
	/**
	 * It represents the cost the real base of the order
	 */
	private double realBase;
	/**
	 * It represents the CIF Applicated for the order
	 */
	private double CIFApplied;


	
////////CONSTRUCTOR//////////
	
	/**
	 * create an order type object that has not yet been finished
	 * @param id is the order code
	 * @param md is the cost of MD spend do far
	 * @param mod is the cost of MOD spend do far
	 * @param rBase is the cost of real base spend do far
	 * @param dayS is a day of the start date
	 * @param monthS is a month of the start date
	 * @param yearS is a year of the start date
	 */
	public Order(String id, double md, double mod, double rBase, int dayS, int monthS, int yearS) {
		this.id = id;
		MD = md;
		MOD = mod;
		realBase = rBase;
		start = new DateOrder(dayS, monthS, yearS);
	}
	
	/**
	 * create an order type object that has not yet been finished
	 * @param id is the order code
	 * @param md is the cost of MD spend do far
	 * @param mod is the cost of MOD spend do far
	 * @param rBase is the cost of real base spend do far
	 * @param dayS is a day of the start date
	 * @param monthS is a month of the start date
	 * @param yearS is a year of the start date
	 * @param dayF is a day of the finished date
	 * @param monthF is a month of the finished date
	 * @param yearF is a year of the finished date
	 */
	public Order(String id, double md, double mod, double  rBase, int dayS, int monthS, int yearS, int dayF, int monthF, int yearF) {
		this.id = id;
		MD = md;
		MOD = mod;
		realBase = rBase;
		start = new DateOrder(dayS, monthS, yearS);
		finish = new DateOrder(dayF, monthF, yearF);
	}
	
	/**
	 * Calculate the applied CIF of the order
	 */
	public void calculateCIFApplied(double tasa) {
		CIFApplied = tasa*realBase ;
	}	
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * @return the order start date
	 */
	public DateOrder getStart() {
		return start;
	}
	
	/**
	 * @return the order end date
	 */
	public DateOrder getFinish() {
		return finish;
	}
	/**
	 * Add a finish date for the order
	 * @param dayF is a day of the finished date
	 * @param monthF is a month of the finished date
	 * @param yearF is a year of the finished date
	 */
	public void setFinish(int dayF, int monthF, int yearF) {
		DateOrder nFinish = new DateOrder(dayF, monthF, yearF);
		this.finish = nFinish;
	}
	
	/**
	 * @return the order code
	 */
	public String getId() {
		return id;
	}
	/**
	 * Change the order code
	 * @param id is the new code for the order
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the order MD
	 */
	public double getMD() {
		return MD;
	}
	/**
	 * Change the order MD
	 * @param md is the new MD for the order
	 */
	public void setMD(double md) {
		MD = md;
	}
	
	/**
	 * Add the extra cost of MD of the order
	 * @param
	 */
	public void addMD(double md) {
		MD += md;
	}
	
	/**
	 * @return the order MOD
	 */
	public double getMOD() {
		return MOD;
	}
	/**
	 * Change the order MOD
	 * @param md is the new MOD for the order
	 */
	public void setMOD(double mod) {
		MOD = mod;
	}
	/**
	 * add the extra cost of MOD of the order
	 */
	public void addMOD(double mod) {
		MOD += mod;
	}
	
	/**
	 * @return the order realBase
	 */
	public double getRealBase() {
		return realBase;
	}
	/**
	 * Change the order real base
	 * @param realBase is the new realBase for the order
	 */
	 public void setRealBase(double realBase) {
		this.realBase = realBase;
	}
	 /**
	 * add the extra cost of realBase of the order
	 */
	public void addRealBase(double realBase) {
		this.realBase += realBase;
	} 
	 
	 
	/**
	 * @return the applied CIF of order
	 */
	public double getCIFApplied() {
		return (double)Math.round(CIFApplied * 100d) / 100;
	}

	
	
	@Override
	public int compareTo(Order otherDate) {
		int comparation = start.compareTo(otherDate.start);
		return comparation;
	}
	
	public int compareTo1(Order otherDate) {
		int comparation = finish.compareTo(otherDate.finish);
		return comparation;
	}

}
