package model;

import java.util.Comparator;

public class IdOrderComparator implements Comparator<Order>{

	public int compare(Order o1, Order o2) {
		int comparation=0;
		String order1=o1.getId();
		String order2=o2.getId();
		if(order1.compareTo(order2)<0){
			comparation=-1;
		}else if(order1.compareTo(order2)>0){
			comparation=1;
		}else{
			comparation=0;
		}
		return comparation;
	}
}
