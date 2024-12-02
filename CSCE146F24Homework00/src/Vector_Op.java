/*
 * James Efird
 */
import java.util.Scanner;
public class Vector_Op {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		//creates a new scanner for user input.
		boolean quit = false;
		while (quit != true) {
			printGreeting();
			chooseOptions();
			int answer = input.nextInt();
			//proceed with the program if the value is between 1 and 3, inclusive, and terminates if it is not or the tester input 9.
			if (answer == 1) {
				printSize();
				int size = input.nextInt();
				if (size <= 1) {
					printError();
				} else {
					double[] a1 = new double[size];
					double[] a2 = new double[size];
					Vector_Func Add = new Vector_Func(a1, a2);
					Add.setArrayNums();
					double[] a3 = Add.vAdd();
					System.out.println("The values of vectors 1 & 2 added together are:"); 
					for (int i = 0; i < a3.length; i++) {
						System.out.println(a3[i]);
					}
				}
			} else if (answer == 2) {
				printSize();
				int size = input.nextInt();
				if (size <= 1) {
					printError();
				} else {
					double[] a1 = new double[size];
					double[] a2 = new double[size];
					Vector_Func Sub = new Vector_Func(a1, a2);
					Sub.setArrayNums();
					double[] a3 = Sub.vSub();
					System.out.println("The values of vector 1 subtacted by vector 2 are:"); 
					for (int i = 0; i < a3.length; i++) {
						System.out.println(a3[i]);
					}
				}
			} else if (answer == 3) {
				printSize();
				int size = input.nextInt();
				if (size <= 1) {
					printError();
				} else {
					double[] a1 = new double[size];
					Vector_Func Mag = new Vector_Func(a1);
					Mag.setArrayNums();
					double m = Mag.vMag();
					System.out.println("The magnitude of this vector is:" + m);
				}
			} else if (answer == 9) {
				System.out.println("Goodbye!");
				quit = true;
			} else {
				printError();
			}
		}
	}
	public static void printGreeting() {
		System.out.println("Welcome to vector operations!");
	}
	public static void chooseOptions() {
		System.out.println("1 = Add 2 vectors");
		System.out.println("2 = Subtract 2 vectors");
		System.out.println("3 = Find the magnitude of a vector");
		System.out.println("9 = quit program");
		System.out.print("Please type an interger between 1 and 3:");
	}
	public static void printSize() {
		System.out.println("How long would you like the vectors to be?");
	}
	public static void printError() {
		System.out.println("That's not a valid number!");
		System.out.close();
	}
}
