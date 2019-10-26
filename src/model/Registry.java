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
	
	/**
	 * 
	 */
	private ArrayList<Period> periods;
	
	/**
	 * 
	 */
	private double cifRate;
	
	/**
	 * 
	 */
	public Registry() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public ArrayList<Period> getPeriods() {
		return periods;
	}
	/**
	 * 
	 */
	public void setPeriods(ArrayList<Period> periods) {
		this.periods = periods;
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
