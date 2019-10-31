/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents the company order record
 */
public class Registry {

////////RELATIONS//////////
	
	/**
	 * It is a list that contains the registry for periods
	 */
	private List<Period> periods;
	/**
	 * It is a list that contains the registry of orders not finished
	 */
	private List<Order> ordersNotFinished;
	private List<Order> ordersFinished;
	
////////ATRUBUTES//////////
	
	/**
	 * Represents the CIF rate
	 */
	private double cifRate;
	
////////CONSTRUCTOR//////////

	/**
	 * Create 12 periods whit month names in Spanish and add to list periods
	 */
	public Registry() {
		ordersNotFinished= new ArrayList<Order>();
		ordersFinished= new ArrayList<Order>();
		periods = new ArrayList<Period>(12);
		periods.add(new Period(1));
		periods.add(new Period(2));
		periods.add(new Period(3));
		periods.add(new Period(4));
		periods.add(new Period(5));
		periods.add(new Period(6));
		periods.add(new Period(7));
		periods.add(new Period(8));
		periods.add(new Period(9));
		periods.add(new Period(10));
		periods.add(new Period(11));
		periods.add(new Period(12));
	}
	
/////////////METHOD////////////
	
	public void calculateCIFAplicatedOrdersNotFinished(double tasa) {
		
		for (Iterator<Order> iterator = ordersNotFinished.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			order.calculateCIFApplied(tasa);
		}
	}
	
	public void calculateCIFAplicatedOrdersFinished(double tasa) {
		for (Iterator<Order> iterator = ordersFinished.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			order.calculateCIFApplied(tasa);
		}
	}
	

	/**
	 * Search a order in ordersNotBilled
	 * @param id is the code of the order sought
	 * @return an int represents the position of order sought in the ordersNotBilled, if it does not find returns -1
	 */
	public void finishedOrder(String id,double md, double mod, double cif, int dayF, int monthF, int yearF ) {
		
		for (int i = 0; i < ordersNotFinished.size(); i++) {
			if(ordersNotFinished.get(i).getId().equals(id)) {
				ordersNotFinished.get(i).setMD(md);
				ordersNotFinished.get(i).setMOD(mod);
				ordersNotFinished.get(i).setCIF(cif);
				Order r= new Order(ordersNotFinished.get(i).getId(),ordersNotFinished.get(i).getMD(),ordersNotFinished.get(i).getMOD(),
						ordersNotFinished.get(i).getCIF(),ordersNotFinished.get(i).getStart().getDay(),ordersNotFinished.get(i).getStart().getMonth(),
						ordersNotFinished.get(i).getStart().getYear(), dayF,monthF,yearF);
				ordersFinished.add(r);
				ordersNotFinished.remove(i);
			}
		}
	}
	/**
	 * agrega una orden a la lista de las ordenes que aun no han sido facturadas 
	 * en orden
	 * 
	 */

	/**
	 * se encarga de crear y agregar una nueva orden a la lista correspondiente, ya sea un periodo especifico
	 * o en la lista de las ordenes no facturadas
	 */
	public void addOrderNF(Order nf) {
		ordersNotFinished.add(nf);
		
		//sortByIdOrder();
	}
	public void addOrderF(Order f) {
		ordersFinished.add(f);
		
		//sortByIdOrder();
	}
	/**
	 * Search a order in ordersNotBilled
	 * @param id is the code of the order sought
	 * @return an int represents the position of order sought in the ordersNotBilled, if it does not find returns -1
	 */
	public void billedOrder(String id) {
		
		for (int i = 0; i < ordersFinished.size(); i++) {
			if(ordersFinished.get(i).getId().equals(id)) {
				Order r= new Order(ordersFinished.get(i).getId(),ordersFinished.get(i).getMD(),ordersFinished.get(i).getMOD(),
						ordersFinished.get(i).getCIF(),ordersFinished.get(i).getStart().getDay(),ordersFinished.get(i).getStart().getMonth(),
						ordersFinished.get(i).getStart().getYear(), ordersFinished.get(i).getFinish().getDay(),ordersFinished.get(i).getFinish().getMonth(),
						ordersFinished.get(i).getFinish().getYear());
				addOrderB(r, r.getFinish().getMonth());
				ordersFinished.remove(i);
			}
		}
	}
	/**
	 * Register a order billed in order completion period
	 */
	public void addOrderB(Order r,int period) {
		for (int i = 0; i < periods.size(); i++) {
			if(periods.get(i).getPeriodMonth()==period) {
				periods.get(i).getOrders().add(r);
			}
		}
		//sortByIdOrder();
	}
	public void sortByIdOrder(){
		Comparator<Order> orderComparator = new IdOrderComparator();
		Collections.sort(ordersNotFinished, orderComparator);	
	}
	/**
	 * agrega una orden a la lista de ordenes del periodo que le corresponde
	 * en orden
	 * 
	 */
	

/////////////////GET and SET/////////////////////////////
	
	/**
	 * @return the periods list
	 */
	public List<Period> getPeriods() {
		return periods;
	}
	
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	/**
	 * @return the ordersNotBilled list
	 */
	public List<Order> getOrdersNotFinished() {
		return ordersNotFinished;
	}
	
	public void setOrdersNotFinished(List<Order> ordersNotFinished) {
		this.ordersNotFinished = ordersNotFinished;
	}

	
	public List<Order> getOrdersFinished() {
		return ordersFinished;
	}

	public void setOrdersFinished(List<Order> ordersFinished) {
		this.ordersFinished = ordersFinished;
	}
	/**
	 * @return the CIF rate
	 */
	public double getCifRate() {
		return cifRate;
	}
	/**
	 * Change the CIF rate
	 * @param cifRate is the new CIF rate
	 */
	public void setCifRate(double cifRate) {
		this.cifRate = cifRate;
	}

	
	
	
	
	
}
