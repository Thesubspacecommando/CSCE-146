/*
 * James E
 */
//This class sets up the parameters that a prize has, which is it's name and how much it costs
public class Prize {
	private String name;
	private double price;
	public Prize() {
		this.name = "none";
		this.price = 0.0;
	}
	public Prize(String aN, double aP) {
		this.setName(aN);
		this.setPrice(aP);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null) {
			this.name = name;
		} else {
			this.name = "none";
		}

	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price >= 1) {
			this.price = price;
		} else {
			this.price = 0.0;
		}

	}
	//used for testing
	public String toString() {
		return "Name: " +this.name+ " Price: " +this.price;
	}
	
	//used for checking duplicates
	public boolean equals(Prize aPrize) {
		return aPrize != null &&
				this.name.equals(aPrize.getName()) &&
				this.price == aPrize.getPrice();
	}
}
