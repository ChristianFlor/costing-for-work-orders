/**
 * 
 */
package model;

/**
 * @author ASUS
 *
 */
public class Order {

////////RELATIONS//////////
	
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
	private String id;
	
	/**
	 * 
	 */
	private double MD;
	/**
	 * 
	 */
	private double MOD;
	/**
	 * 
	 */
	private double CIF;
	/**
	 * 
	 */
	private double CIFApplied;
	/**
	 * 
	 */
	private boolean billed;
	
	
////////CONSTRUCTOR//////////
	
	/**
	 * 
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
/////////////////GET and SET/////////////////////////////
	
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
	public String getId() {
		return id;
	}
	/**
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 */
	public double getMD() {
		return MD;
	}
	/**
	 * 
	 */
	public void setMD(double md) {
		MD = md;
	}
	
	/**
	 * 
	 */
	public double getMOD() {
		return MOD;
	}
	/**
	 * 
	 */
	public void setMOD(double mod) {
		MOD = mod;
	}
	 
	/**
	 * 
	 */
	public double getCIF() {
		return CIF;
	}
	/**
	 * 
	 */
	public void setCIF(double cIF) {
		CIF = cIF;
	}
	
	/**
	 * 
	 */
	public double getCIFApplied() {
		return CIFApplied;
	}
	/**
	 * 
	 */
	public void setCIFApplied(double cIFApplied) {
		CIFApplied = cIFApplied;
	}
	
	/**
	 * 
	 */
	public boolean getBilled() {
		return billed;
	}
	/**
	 * 
	 */
	public void setBilled(boolean billed) {
		this.billed = billed;
	}
	
	
	

}
