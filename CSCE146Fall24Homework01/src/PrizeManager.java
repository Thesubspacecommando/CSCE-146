/*
 * James E
 */
import java.util.Scanner;
import java.io.*;
//sets up the array that is used to pick out the prizes from the text file
public class PrizeManager {
	private Prize[] prizes;
	public static final String DELIM = "\t";
	public static final String FILE_NAME = "./prizeList.txt";
	public static final int BODY_FIELD_AMT = 2;
	public PrizeManager(String fileName) {
		this.prizes = this.readPrizeFile(FILE_NAME);
	}
	public int listPrizes(String fileName) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			int size = 0;
			while(fileScanner.hasNextLine()) {
				fileScanner.nextLine();
				size++;
			}
			fileScanner.close();
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//reads the file that contains the prizes and puts them into an array
	public Prize[] readPrizeFile(String fileName) {
		//sets up an empty array that has the length of the amount of lines in the file
		Prize[] prizes = new Prize[this.listPrizes(FILE_NAME)];
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				//splits the line into two parts, separated by the tab ("\t")
				String[] splitLines = line.split(DELIM);
				//populates the array with exact formatting
				if(splitLines.length == BODY_FIELD_AMT) {
					String name = splitLines[0];
					double price = Double.parseDouble(splitLines[1]);
					Prize aPrize = new Prize(name, price);
					for(int i = 0; i < prizes.length; i++) {
						if(prizes[i] ==null) {
							prizes[i] = aPrize;
							break;
						}
					}
				}
			}
			fileScanner.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return prizes;
	}
	//prints out the objects in the array, used for testing if the method above worked
	public void printPrizes() {
		for(int i=0; i < this.prizes.length; i++) {
			if(prizes[i] == null) {
				break;
			}
			System.out.println(prizes[i]);
		}
	}
	//gets a prize from an exact location
	public Prize getPrize(int index) {
		return prizes[index];
	}
	public int getLength() {
		return prizes.length-1;
	}
}
