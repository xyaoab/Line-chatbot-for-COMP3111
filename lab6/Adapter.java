//package skeleton;

import java.util.HashMap;

public class Adapter {
	public static final String[] BEVERAGES = new String[] {
			"Caffe Americano", "Caffe Mocha", "Caffe Latte", 
			"Cappuccino", "Caramel Macchiato", "Espresso" }; // You can change these

	/**
	* This function compute the edit distance between a string and every 
	* strings in your selected beverage set. The beverage with the minimum 
	* edit distance <= 3 is returned. The use of Wagner_Fischer algorithm
	* is shown in the main function in WagnerFischer.java
	**/
	public String getBeverage(String s){
		// TODO: find the word with minimum edit distance
		int dis=s.length();
		String drink=null;
		for(int i=0;i<BEVERAGES.length;i++) {
			 WagnerFischer wf = new WagnerFischer(BEVERAGES[i], s);
			 int cur=wf.getDistance();
			 if (cur< dis && cur<=3) {
				 dis=cur;
				 drink=BEVERAGES[i];
			 }
		}
		return drink;
	}
}
