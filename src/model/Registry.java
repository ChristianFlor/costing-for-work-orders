/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author 
 *
 */
public class Registry {

////////RELATIONS//////////
	
	/**
	 * 
	 */
	private ArrayList<Period> periods;
	/**
	 * 
	 */
	private ArrayList<Order> ordersNotBilled;
	
////////ATRUBUTES//////////
	
	/**
	 * 
	 */
	private double cifRate;
	
////////CONSTRUCTOR//////////

	/**
	 * crea la lista de periodos y crea los 12 periodos
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
	 * registra una orden como facturada en el periodo en que se ha finalizado la orden
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
	 * busca una orden en la lista de ordene que aun no han sido facturadas por el id
	 *  id, es el codigo de la ordne buscada
	 *  si no la encuentra retorna -1
	 *  retorna la posicion en la lista donde se encuntra la orden
	 */
	private int searchOrder(String id) {
		return 0;
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
	private void addOrderBilled(Order newOrder, int period) {
		periods.get(period).getOrders().add(newOrder);
	}
	
	/**
	 * agrega una orden a la lista de las ordenes que aun no han sido facturadas 
	 * en orden
	 * 
	 */
	private void addOrderNotBilled(Order newOrder) {
		ordersNotBilled.add(newOrder);
	}

/////////////////GET and SET/////////////////////////////
	
	/**
	 * 
	 */
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	
	/**
	 * 
	 */
	public ArrayList<Order> getOrdersNotBilled() {
		return ordersNotBilled;
	}
	
	/**
	 * 
	 */
	public double getCifRate() {
		return cifRate;
	}
	/**
	 * 
	 */
	public void setCifRate(double cifRate) {
		this.cifRate = cifRate;
	}
	
	
	
	
}
