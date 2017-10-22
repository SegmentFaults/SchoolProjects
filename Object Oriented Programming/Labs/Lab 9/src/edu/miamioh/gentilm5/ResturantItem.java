/**
 * 
 */
package edu.miamioh.gentilm5;

/**
 * Creates an item that can be used by the button so that it may have a name and price. 
 * 
 * @author gentilm5
 *
 */
public class ResturantItem {
	private String name;
	private double price;
	
	/**
	 * 
	 * @param name the name of the food
	 * @param price, the price of the food
	 */
	ResturantItem(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return name + "             " +price + "\n";
	}

}
