/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import java.util.ArrayList;

/**
 * This class represents the company order record
 */
public class Registry {

////////RELATIONS//////////
	
	/**
	 * It is a list that contains the registry for periods
	 */
	private ArrayList<Period> periods;
	/**
	 * It is a list that contains the registry of orders not billed
	 */
	private ArrayList<Order> ordersNotBilled;
	
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
	
/////////////METHOD////////////
	
	/**
	 * Register a order billed in order completion period
	 */
	public boolean changeBilledStatus(String id, int dayF, int monthF, int yearF){
		int orderI = searchOrder(id);
		boolean changed = orderI != -1;
		if(changed) {
			Order order = ordersNotBilled.get(orderI);
			order.setFinish(dayF, monthF, yearF);
			addOrderBilled(order, monthF-1);
			ordersNotBilled.remove(orderI);
		}
		return true;
	}
	
	/**
	 * Search a order in ordersNotBilled
	 * @param id is the code of the order sought
	 * @return an int represents the position of order sought in the ordersNotBilled, if it does not find returns -1
	 */
	public int searchOrder(String id) {
		int i = -1;
		int l = ordersNotBilled.size()-1;
		int s = 0;
		int m = (s+l)/2;
		while(s<l) {
			if(ordersNotBilled.get(m).getId().compareTo(id) == 0) {
				s = m;
				l = s;
			}else if(ordersNotBilled.get(m).getId().compareTo(id) > 0) {
				l = m-1;
				m = (s+l)/2;
			}else{
				s = m;
				m = (s+l)/2;
			}
		}
		if(s==l && ordersNotBilled.equals(id)) {
			i = s;
		}
		
		return i;
	}
	
	/**
	 * se encarga de crear y agregar una nueva orden a la lista correspondiente, ya sea un periodo especifico
	 * o en la lista de las ordenes no facturadas
	 */
	public void addNewOrder(String id, double md, double mod, double cif, int dayS, int monthS, int yearS, boolean billed, int dayF, int monthF, int yearF) {
		if(billed) {
			Order newOrder = new Order(id, md, mod, cif, dayS, monthS, yearS, dayF, monthF, yearF);
			addOrderBilled(newOrder, monthF-1);
		}else {
			Order newOrder = new Order(id, md, mod, cif, dayS, monthS, yearS);
			addOrderNotBilled(newOrder);
		}
			
		
	}
	
	/**
	 * agrega una orden a la lista de ordenes del periodo que le corresponde
	 * en orden
	 * 
	 */
	public void addOrderBilled(Order newOrder, int period) {
		String id = newOrder.getId();
		boolean added = false;
		int l = periods.get(period).getOrders().size()-1;
		ArrayList<Order> orders = periods.get(period).getOrders();
		int s = 0;
		int m = (s+l)/2;
		while(!added) {
			if(s == l) {
				if(orders.get(s).getId().compareTo(id) > 0) {
					orders.add(s, newOrder);
				}else {
					orders.add(s+1, newOrder);
				}
				added = true;
			}else if(orders.get(m).getId().compareTo(id) > 0) {
				l = m-1;
				m = (s+l)/2;
			}else{
				s = m;
				m = (s+l)/2;
			}
		}
	}
	
	/**
	 * agrega una orden a la lista de las ordenes que aun no han sido facturadas 
	 * en orden
	 * 
	 */
	public void addOrderNotBilled(Order newOrder) {
		String id = newOrder.getId();
		boolean added = false;
		int l = ordersNotBilled.size()-1;
		int s = 0;
		int m = (s+l)/2;
		while(!added) {
			if(s == l) {
				if(ordersNotBilled.get(s).getId().compareTo(id) > 0) {
					ordersNotBilled.add(s, newOrder);
				}else {
					ordersNotBilled.add(s+1, newOrder);
				}
				added = true;
			}else if(ordersNotBilled.get(m).getId().compareTo(id) > 0) {
				l = m-1;
				m = (s+l)/2;
			}else{
				s = m;
				m = (s+l)/2;
			}
		}
	}

/////////////////GET and SET/////////////////////////////
	
	/**
	 * @return the periods list
	 */
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	
	/**
	 * @return the ordersNotBilled list
	 */
	public ArrayList<Order> getOrdersNotBilled() {
		return ordersNotBilled;
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
