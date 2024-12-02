/*
 * James E
 */
import java.util.Scanner;
import java.io.*;
public class SheepFE {
	public static Scanner keyboard = new Scanner(System.in);
	public static final String DELIM = "\t";
	public static void main(String[] args) {
		MinHeap<Sheep> sheepLine = new MinHeap<Sheep>();
		boolean quit = false;
		printGreeting();
		while(!quit) {
			System.out.println("Please enter a file name");
			String fName = keyboard.nextLine();
			try {
				int size = 0;
				Scanner sizeReader = new Scanner(new File("./" +fName)); //gets the amount of sheep so the size of the array can be measured.
				while(sizeReader.hasNext()) {
					size++;
					sizeReader.nextLine();
				}
				sizeReader.close();
				Sheep[] sArray = new Sheep[size]; //Creates an array of all the sheep
				Scanner fileReader = new Scanner(new File("./" + fName));
				int index = 0;
				while(fileReader.hasNext()) { //Populates the array with info in the file
					String fileLine = fileReader.nextLine();
					String[] splitLines = fileLine.split(DELIM);
					Sheep nSheep = new Sheep(splitLines[0],Integer.parseInt(splitLines[1]),Integer.parseInt(splitLines[2]));
					sArray[index] = nSheep;
					index++;
				}
				fileReader.close();
				Sheep curSheep = sArray[0];
				for(int i = 0; i < sArray.length; i++) { //Gets the sheep with the smallest arrival time, i.e. the sheep who arrives first
					if(sArray[i].getArrivalTime() < curSheep.getArrivalTime()) {
						curSheep = sArray[i];
					}
				}
				index = 0;
				int curShear = curSheep.getShearTime();
				while(curShear >= 0) { //loop for shearing sheep
					if(curShear == 0) { //if the sheep has been sheared, get the next sheep in the heap. Also removes the sheep from the line
						System.out.println(curSheep);
						if(sheepLine.peek() == null) {
							break;
						}
						curSheep = sheepLine.remove();
						curShear = curSheep.getShearTime();
					}
					if(index < sArray.length-1) {//if the index goes beyoned the max amount of sheep
						sheepLine.add(sArray[index]);//sheep gets in line while the current sheep is getting sheared
						index++;
					}
					curShear -= 1; 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Type false if you want to put in another file");
			quit = keyboard.nextBoolean();
			keyboard.nextLine();
		}
	}
	public static void printGreeting() {
		System.out.println("Welcome to sort sorter!");
	}

}
