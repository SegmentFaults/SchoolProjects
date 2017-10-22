/**
 * 
 */

/**
 * @author Michael Gentile
 *
 */
public class Trend implements Comparable<Trend> {
	private String word;
	private int amountUsed;

	Trend(int amount, String word) {
		this.word = word;
		this.amountUsed = amount;
	}

	Trend(String word) {
		amountUsed = 0;
		this.word = word;
	}

	public void incrementCount() {
		amountUsed++;
	}

	public int getCount() {
		return amountUsed;
	}

	public String getString() {
		return word;
	}

	public void setCount(int x) {
		amountUsed = x;
	}

	@Override
	public int compareTo(Trend o) {
		if (o.getCount() > this.getCount()) {
			return 1;
		} else if (o.getCount() < this.getCount()) {
			return -1;
		}
		else{
			return this.getString().compareTo(o.getString());
		}
	}

}
