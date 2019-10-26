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
	
	/**
	 * 
	 */
	public Period() {
		
	}
	
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
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	
	public double getMDTotal() {
		return MDTotal;
	}
	/**
	 * 
	 */
	public void setMDTotal(double mDTotal) {
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
	 * 
	 */
	public void setCIFAplicated(double cIFAplicated) {
		CIFAplicated = cIFAplicated;
	}
	
	
}
