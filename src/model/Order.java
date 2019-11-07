/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.io.Serializable;

/**
 * @author ASUS
 *
 */
public class Order implements Comparable<Order>, Serializable {

////////RELATIONS//////////
	
	/**
	 * repreenta la fecha de inicio de la orden
	 */
	private DateOrder start;
	/**
	 * representa la fecha en que finalizo la orden
	 */
	private DateOrder finish;
	
////////ATRUBUTES//////////
	
	/**
	 * representa el codigo de la orden
	 */
	private String id;
	
	/**
	 * representa los costos de mateales directos de la orden
	 */
	private double MD;
	/**
	 * representa los costos de mano de obra directa de la orden
	 */
	private double MOD;
	/**
	 * representa los costos indirectos de fabricacion de la orden
	 */
	private double CIF;
	/**
	 * representa los costos indirectos de fabricacion aplicados de la orden
	 */
	private double CIFApplied;


	
////////CONSTRUCTOR//////////
	
	/**
	 * crea un objeto de tipo orden que aun no ha sido facturado
	 */
	public Order(String id, double md, double mod, double cif, int dayS, int monthS, int yearS) {
		this.id = id;
		MD = md;
		MOD = mod;
		CIF = cif;
		start = new DateOrder(dayS, monthS, yearS);
	}
	
	/**
	 * crea un objeto de tipo orden que ya ha sido facturado
	 */
	public Order(String id, double md, double mod, double cif, int dayS, int monthS, int yearS, int dayF, int monthF, int yearF) {
		this.id = id;
		MD = md;
		MOD = mod;
		CIF = cif;
		start = new DateOrder(dayS, monthS, yearS);
		finish = new DateOrder(dayF, monthF, yearF);
	}
	
	/**
	 * calcula el cif aplicado de la orden 
	 * ****info base, como pasar esa info?****
	 * 
	 */
	public void calculateCIFApplied(double tasa) {
		CIFApplied = tasa*CIF;
	}	
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * retorna la fecha de inicio de la orden
	 */
	public DateOrder getStart() {
		return start;
	}
	
	/**
	 * retorna la fecha de fin de la orden
	 */
	public DateOrder getFinish() {
		return finish;
	}
	/**
	 * agrega una fecha de fin de la orden
	 */
	public void setFinish(int dayF, int monthF, int yearF) {
		DateOrder nFinish = new DateOrder(dayF, monthF, yearF);
		this.finish = nFinish;
	}
	
	/**
	 * retorna el id de la orden
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * retorna el md
	 */
	public double getMD() {
		return MD;
	}
	/**
	 * agrega md extras
	 * @return 
	 */
	public void setMD(double md) {
		MD += md;
	}
	
	/**
	 * retorna mod
	 */
	public double getMOD() {
		return MOD;
	}
	/**
	 * agrega costos de mod extras
	 */
	public void setMOD(double mod) {
		MOD += mod;
	}
	 
	/**
	 * retorna el cif
	 */
	public double getCIF() {
		return CIF;
	}
	/**
	 * agrega costos de cif extras
	 */
	public void setCIF(double cIF) {
		CIF += cIF;
	}
	
	/**
	 * retorna el cif aplicado de la orden
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
