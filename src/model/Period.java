/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author 
 *
 */
public class Period {
	
////////RELATIONS//////////
	
	/**
	 * 
	 */
	private ArrayList<Order> orders;
	
	/**
	 * 
	 */
	private Date start;
	/**
	 * 
	 */
	private Date finish;
	
////////ATRUBUTES//////////
	
	/**
	 * 
	 */
	private String periodName;
	/**
	 * 
	 */
	private double MDTotal;
	/**
	 * 
	 */
	private double MODTotal;
	/**
	 * 
	 */
	private double CIFTotal;
	/**
	 * 
	 */
	private double CIFAplicated;
	
////////CONSTRUCTOR//////////
	
	/**
	 * 
	 */
	public Period(String periodName) {
		this.periodName = periodName;
	}
	
/////////////METHOD////////////
	
	/**
	 * 
	 */
	public boolean changeBilledStatus(String id){
		return true;
	}
	
	
/////////////////GET and SET/////////////////////////////
	
	/**
	 * 
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
	 * 
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	/**
	 * 
	 */
	public Date getStart() {
		return start;
	}
	/**
	 * 
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	
	/**
	 * 
	 */
	public Date getFinish() {
		return finish;
	}
	/**
	 * 
	 */
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	
	/**
	 * 
	 */
	public String getPeriodName() {
		return periodName;
	}
	
	/**
	 * 
	 */
	public double getMDTotal() {
		return MDTotal;
	}
	/**
	 * 
	 */
	public void MDTotal(double mDTotal) {
		MDTotal = mDTotal;
	}
	
	/**
	 * 
	 */
	public double getMODTotal() {
		return MODTotal;
	}
	/**
	 * 
	 */
	public void setMODTotal(double mODTotal) {
		MODTotal = mODTotal;
	}
	
	/**
	 * 
	 */
	public double getCIFTotal() {
		return CIFTotal;
	}
	/**
	 * 
	 */
	public void setCIFTotal(double cIFTotal) {
		CIFTotal = cIFTotal;
	}
	
	/**
	 * 
	 */
	public double getCIFAplicated() {
		return CIFAplicated;
	}
	/**
	 * @param cifAplicated
	 */
	public void setCIFAplicated(double cIFAplicated) {
		CIFAplicated = cIFAplicated;
	}
	
	
	
	
}
