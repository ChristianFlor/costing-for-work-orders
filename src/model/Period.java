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
 *
 */
public class Period implements Serializable{
	
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
	 * representa el costo de materiales directos de todo el periodo
	 */
	private double MDTotal;
	/**
	 * representa el costo de mano de obra directa de todo el periodo
	 */
	private double MODTotal;
	/**
	 * representa el total de los costos indirectos de fabricacion del periodo
	 */
	private double CIFTotal;
	/**
	 * representa el total de los costos indirectos de fabricacion aplicados del periodo
	 */
	private double CIFAplicated;
	
////////CONSTRUCTOR//////////
	
	/**
	 * permite crear objeto de tipo periodo con el nombre que se asigna
	 * 
	 * para
	 */
	public Period(int periodName) {
		this.month = periodName;
		ordersBilled= new ArrayList<Order>();
	}
	
/////////////METHOD////////////
	
	/**
	 * calcula el total de md, mod, cif y cifaplicados del periodo
	 */
	public void calculateTotalCost(double tasa) {
		double mdTotal = 0;
		double modTotal = 0;
		double cifTotal = 0;
		double cifAplicatedTotal = 0;
		for (Iterator<Order> iterator = ordersBilled.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			mdTotal += order.getMD();
			modTotal += order.getMOD();
			cifTotal += order.getCIF();
			order.calculateCIFApplied(tasa);
			cifAplicatedTotal += order.getCIFApplied();
		}
		MDTotal = mdTotal;
		MODTotal = modTotal;
		CIFTotal = cifTotal;
		CIFAplicated = cifAplicatedTotal;
	}
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * retorna la lista orders
	 */
	public ArrayList<Order> getOrders() {
		return ordersBilled;
	}
	
	/**
	 * retorna el nombre del periodo
	 */
	public int getPeriodMonth() {
		return month;
	}
	
	/**
	 * retorna el md 
	 */
	public double getMDTotal() {
		return MDTotal;
	}
	
	/**
	 * retorna el mod total
	 */
	public double getMODTotal() {
		return MODTotal;
	}

	/**
	 * retorna el md 
	 */
	public double getCIFTotal() {
		return CIFTotal;
	}

	
	/**
	 * retorn el total de cif aplicados
	 */
	public double getCIFAplicated() {
		return CIFAplicated;
	}

	
	
	
	
}
