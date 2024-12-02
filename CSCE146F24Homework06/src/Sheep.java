/*
 * James E
 */
public class Sheep implements Comparable<Sheep> {
	private String name;
	private int shearTime;
	private int arrivalTime;
	public Sheep() {
		this.name = "none";
		this.shearTime = 0;
		this.arrivalTime = 0;
	}
	
	public Sheep(String aN, int sT, int aT) {
		this.setName(aN);
		this.setShearTime(sT);
		this.setArrivalTime(aT);
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
	public int getShearTime() {
		return shearTime;
	}
	public void setShearTime(int shearTime) {
		if(shearTime <= 0) {
			this.shearTime = 0;
		} else {
			this.shearTime = shearTime;
		}
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime <= 0) {
			this.arrivalTime = 0;
		} else {
			this.arrivalTime = arrivalTime;
		}
	}
	
	public int compareTo(Sheep aSheep) {
		if(aSheep == null) {
			return -1;
		}
		if(this.shearTime > aSheep.shearTime) {
			return 1;
		} else if(this.shearTime < aSheep.shearTime) {
			return -1;
		} else {
			return this.name.compareTo(aSheep.getName());
		}
	}
	public String toString() {
		return "Name: " + this.name + " Shear Time: " + this.shearTime + " Arrival Time: " + this.arrivalTime;
	}
	
}
