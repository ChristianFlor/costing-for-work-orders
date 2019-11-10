/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a period of registry
 */
public class Period implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
////////RELATIONS//////////

	/**
	 * Is a list that contains all orders billed in this period
	 */
	private ArrayList<Order> ordersBilled;
	
	
////////ATRUBUTES//////////
	
	/**
	 * Is the name of period and represents registration period
	 */
	private int month;
	/**
	 * Represents the cost of direct materials for the entire period
	 */
	private double MDTotal;
	/**
	 * Represents the cost of direct labor for the entire period
	 */
	private double MODTotal;
	/**
	 * Represents the total indirect manufacturing costs of the period
	 */
	private double RealBaseTotal;
	/**
	 * Represents the total indirect manufacturing costs applied for the period
	 */
	private double CIFAplicated;
	
////////CONSTRUCTOR//////////
	
	/**
	 * Allows to create a period type object with the name assigned
	 * @param periodName is a number that represents the period name
	 */
	public Period(int periodName) {
		this.month = periodName;
		ordersBilled= new ArrayList<Order>();
	}
	
/////////////METHOD////////////
	
	/**
	 * calculate the total MD, MOD, realBase and CIFAplicated for the period
	 */
	public void calculateTotalCost(double tasa) {
		double mdTotal = 0;
		double modTotal = 0;
		double realBaseTotal = 0;
		double cifAplicatedTotal = 0;
		for (Iterator<Order> iterator = ordersBilled.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			mdTotal += order.getMD();
			modTotal += order.getMOD();
			realBaseTotal += order.getRealBase();
			order.calculateCIFApplied(tasa);
			cifAplicatedTotal += order.getCIFApplied();
		}
		MDTotal = mdTotal;
		MODTotal = modTotal;
		RealBaseTotal = realBaseTotal;
		CIFAplicated = cifAplicatedTotal;
	}
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * @return the order list
	 */
	public ArrayList<Order> getOrders() {
		return ordersBilled;
	}
	
	/**
	 * @return the period month
	 */
	public int getPeriodMonth() {
		return month;
	}
	
	/**
	 * @return the MDTotal of the period
	 */
	public double getMDTotal() {
		return MDTotal;
	}
	
	/**
	 * @return the MODTotal of the period
	 */
	public double getMODTotal() {
		return MODTotal;
	}
	
	/**
	 * @return the realBaseTotal of the period
	 */
	public double getRealBaseTotal() {
		return RealBaseTotal;
	}
	
	/**
	 * @return the CIFAplicated of the period
	 */
	public double getCIFAplicated() {
		return CIFAplicated;
	}
	
}
