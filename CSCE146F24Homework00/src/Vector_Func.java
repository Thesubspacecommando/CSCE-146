/*
 * James E
 */
import java.util.Scanner;
public class Vector_Func {
	public static Scanner keyboard = new Scanner(System.in);
	private double[] array1;
	private double[] array2;
	public Vector_Func(double[] a1, double[] a2) {
		 this.setArray1(a1);
		 this.setArray2(a2);
	}
	public Vector_Func(double[] a1) {
		this.array1 = a1;
	}
	public double[] getArray1() {
		return array1;
	}
	public void setArray1(double[] array1) {
		this.array1 = array1;
	}
	public double[] getArray2() {
		return array2;
	}
	public void setArray2(double[] array2) {
		this.array2 = array2;
	}
	//Sets values for vectors 1 & 2
	public void setArrayNums() {
		System.out.println("Please enter values for Vector 1:");
		for(int i = 0; i < this.array1.length; i++) {
			System.out.println(i+1+".");
			this.array1[i] = keyboard.nextDouble();
		}
		//if array 2 isn't empty (for magnitude)
		if (array2 != null) {
			System.out.println("Please enter values for Vector 2:");
			for(int i = 0; i < this.array2.length; i++) {
				System.out.println(i+1+".");
				this.array2[i] = keyboard.nextDouble();
			}
		}
	}
	//Adds vectors
	public double[] vAdd() {
		double[] fArray = new double[this.array1.length];
		for (int i = 0; i < fArray.length; i++) {
			fArray[i] = this.array1[i] + this.array2[i];
		}
		return fArray;
	}
	//Subtracts vectors
	public double[] vSub() {
		double[] fArray = new double[this.array1.length];
		for (int i = 0; i < fArray.length; i++) {
			fArray[i] = this.array1[i] - this.array2[i];
		}
		return fArray;
	}
	//returns the magnitude of the vector
	public double vMag() {
		double m = 0;
		for(int i = 0; i < this.array1.length; i++) {
			m += Math.pow(this.array1[i],2);
		}
		return Math.sqrt(m);
	}
}
