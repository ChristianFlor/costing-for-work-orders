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
import java.util.List;

/**
 * This class represents the company order record
 */
public class Registry implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

////////RELATIONS//////////
	/**
	 * It is a list that contains the registry for periods
	 */
	private List<Period> periods;
	/**
	 * It is a list that contains the registry of orders not finished
	 */
	private List<Order> ordersNotFinished;
	/**
	 * It is a list that contains the registry of orders finished
	 */
	private List<Order> ordersFinished;
	
////////ATRUBUTES//////////
	
	/**
	 * Represents the CIF rate
	 */
	private double cifRate;
	
////////CONSTRUCTOR//////////

	/**
	 * Create 12 periods whit month names in Spanish and add to list periods
	 * @param cif is the CIF rate
	 */
	public Registry(double cif) {
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
		cifRate = cif;
	}
	
/////////////METHOD////////////
	
	/**
	 * Calculate the applied CIF of all orders that have not been finalized
	 */
	public void calculateCIFAplicatedOrdersNotFinished() {
		
		for (Iterator<Order> iterator = ordersNotFinished.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			order.calculateCIFApplied(cifRate);
		}
	}
	
	/**
	 * Calculate the applied CIF of all orders that have been finalized
	 */
	public void calculateCIFAplicatedOrdersFinished() {
		for (Iterator<Order> iterator = ordersFinished.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			order.calculateCIFApplied(cifRate);
		}
	}
	
	/**
	 * Calculate the applied CIF of all orders that have been finalized billed
	 */
	public void calculateCIFAplicatedOrdersBiled() {
		for (int i = 0; i < periods.size(); i++) {
			for (Iterator<Order> iterator = periods.get(i).getOrders().iterator(); iterator.hasNext();) {
				Order order = (Order) iterator.next();
				order.calculateCIFApplied(cifRate);
			}
		}
	}
	
	/**
	 * Delete an order
	 * @param idOrder is order code to be deleted
	 * @param finish is a boolean indicating if the order has been finalized
	 * @param represents the total indirect manufacturing costs applied for the period period is a number indicating the order period, if the order has not been billed put zero
	 * @return a boolean indicated if the order was registered (true) or it wasn't register (false)
	 */
	public boolean deleteOrder(String idOrder, boolean finish, int period) {
		boolean delete = false;
		if(finish) {
			int o = searchOrder(idOrder, ordersFinished);
			if(o!=-1) { ordersFinished.remove(o); }
		}else if(period > 0){
			List<Order> list = periods.get(period-1).getOrders();
			int o = searchOrder(idOrder, list);
			if(o!=-1) { list.remove(o); }
		}else {
			int o = searchOrder(idOrder, ordersNotFinished);
			if(o!=-1) { ordersNotFinished.remove(o); }
		}
		return delete;
	}
	
	public void setOrder(String idOrder) {
		
	}

	/**
	 * Change the status of an unfinished order to finalized
	 * @param id is the order code that ends
	 * @param md is a double that represents the MD that was added to finalize the order
	 * @param mod is a double that represents the MOD that was added to finalize the order
	 * @param rBase is a double that represents the real base that was added to finalize the order
	 * @param dayF is a day of the finished date
	 * @param monthF is a month of the finished date
	 * @param yearF is a year of the finished date
	 * @return a boolean indicated if the order was registered (true) or it wasn't register (false)
	 */
	public boolean finishedOrder(String id,double md, double mod, double rBase, int dayF, int monthF, int yearF ) {
		
		boolean finished = false;
		int o = searchOrder(id, ordersNotFinished);
		if(o!=-1) {
			Order order = ordersFinished.get(o);
			order.setMD(md);
			order.setMOD(mod);
			order.setRealBase(rBase);
			order.setFinish(dayF, monthF, yearF);
			ordersFinished.add(order);
			ordersNotFinished.remove(o);
			finished = true;
		}
		return finished;
	}

	/**
	 * Add an order not finished to registry
	 * @param nf is the order not finished
	 */
	public void addOrderNF(Order nf) {
		ordersNotFinished.add(nf);
	}
	
	/**
	 * Add an order finished to registry
	 * @param f is the order finished != null
	 */
	public void addOrderF(Order f) {
		ordersFinished.add(f);
	}
	
	/**
	 * Invoice an order finished in the corresponding period
	 * @param id is the order code
	 * @return a boolean that indicating if the order was billed
	 */
	public boolean billedOrder(String id) {
		boolean billed = false;
		int j = searchOrder(id, ordersFinished);
		if(j!=-1) {
			Order order = ordersFinished.get(j);
			addOrderB(order, order.getFinish().getMonth());
			ordersFinished.remove(j);
			billed = true;
		}
		return billed;
	}
	
	/**
	 * Search a order in a collection
	 * @param id is the code of the order sought
	 * @param list is a collection when where the search will be performed
	 * @return an number represents the position of order sought in the list, if it does not find returns -1
	 */
	public int searchOrder(String id, List<Order> list) {
		int pos = -1;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				pos = i;
				i= list.size();
			}
		}
		return pos;
	}
	
	/**
	 * Pass a completed order to the corresponding period record
	 * @param r is a order != null that you want to bill
	 * @param period is a number that represents the period to which the order corresponds
	 */
	public void addOrderB(Order r, int period) {
		for (int i = 0; i < periods.size(); i++) {
			if(periods.get(i).getPeriodMonth()==period) {
				periods.get(i).getOrders().add(r);
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

	/**
	 * @return the ordersNotBilled list
	 */
	public List<Order> getOrdersNotFinished() {
		return ordersNotFinished;
	}
	
	/**
	 * @return the ordersFinished list
	 */
	public List<Order> getOrdersFinished() {
		return ordersFinished;
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
