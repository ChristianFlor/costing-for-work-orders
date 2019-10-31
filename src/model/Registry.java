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
	
	/**
	 * Register a order billed in order completion period
	 */
	public boolean changeBilledStatus(String id, int dayF, int monthF, int yearF){
		int orderI = searchOrder(id);
		boolean changed = orderI != -1;
		if(changed) {
			Order order = ordersFinished.get(orderI);
			order.setFinish(dayF, monthF, yearF);
			addOrderBilled(order, monthF-1);
			ordersFinished.remove(orderI);
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
		int l = ordersNotFinished.size()-1;
		int s = 0;
		int m = (s+l)/2;
		while(s<l) {
			if(ordersNotFinished.get(m).getId().compareTo(id) == 0) {
				s = m;
				l = s;
			}else if(ordersNotFinished.get(m).getId().compareTo(id) > 0) {
				l = m-1;
				m = (s+l)/2;
			}else{
				s = m;
				m = (s+l)/2;
			}
		}
		if(s==l && ordersNotFinished.equals(id)) {
			i = s;
		}
		
		return i;
	}
	
	/**
	 * se encarga de crear y agregar una nueva orden a la lista correspondiente, ya sea un periodo especifico
	 * o en la lista de las ordenes no facturadas
	 */
	public void addNewOrder(String id, double md, double mod, double cif, int dayS, int monthS, int yearS, boolean finished, int dayF, int monthF, int yearF) {
		if(finished) {
			Order newOrder = new Order(id, md, mod, cif, dayS, monthS, yearS, dayF, monthF, yearF);
			addOrderFinished(newOrder);
		}else {
			Order newOrder = new Order(id, md, mod, cif, dayS, monthS, yearS);
			addOrderNotFinished(newOrder);
			//Order newOrder = new Order();
			//addOrderNB(id, md, mod, cif, dayS, monthS, yearS);
		}
			
		
	}
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
	public void addOrderNF(Order nf) {
		ordersNotFinished.add(nf);
		
		//sortByIdOrder();
	}
	public void addOrderF(Order f) {
		ordersFinished.add(f);
		
		//sortByIdOrder();
	}
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
	public void addOrderNotFinished(Order newOrder) {
		String id = newOrder.getId();
		boolean added = false;
		int l = ordersNotFinished.size()-1;
		int s = 0;
		int m = (s+l)/2;
		while(!added) {
			if(s == l) {
				if(ordersNotFinished.get(s).getId().compareTo(id) > 0) {
					ordersNotFinished.add(s, newOrder);
				}else {
					ordersNotFinished.add(s+1, newOrder);
				}
				added = true;
			}else if(ordersNotFinished.get(m).getId().compareTo(id) > 0) {
				l = m-1;
				m = (s+l)/2;
			}else{
				s = m;
				m = (s+l)/2;
			}
		}
	}
	public void addOrderFinished(Order newOrder) {
		String id = newOrder.getId();
		boolean added = false;
		int l = ordersFinished.size()-1;
		int s = 0;
		int m = (s+l)/2;
		while(!added) {
			if(s == l) {
				if(ordersFinished.get(s).getId().compareTo(id) > 0) {
					ordersFinished.add(s, newOrder);
				}else {
					ordersFinished.add(s+1, newOrder);
				}
				added = true;
			}else if(ordersFinished.get(m).getId().compareTo(id) > 0) {
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
