/*
 * James E
 */
import java.util.Scanner;
public class PrizeFE {
	//Front end of the game
	public static final String FILE_NAME = "./prizeList.txt";
	public static Scanner keyboard = new Scanner(System.in);
	public static PrizeManager prizeManager = new PrizeManager(FILE_NAME);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printGreeting();
		boolean end = false;
		while(!end) {
			double total = printPrizes();
			System.out.println("\n"
					+ "Make your guess:");
			double guess = keyboard.nextDouble();
			System.out.println("The actual total is " + total);
			if(guess == total) {
				System.out.println("WOW! That was exactly correct!\n"
						+"You win!");
			} else if(guess > total) {
				System.out.println("Your guess was over the total...\n"
						+ "You lose.");
			} else if(guess+1300.0 >= total) {
				System.out.println("Your guess was close enough!\n"
						+ "You win!");
			} else {
				System.out.println("Your guess wasn't close enough...\n"
						+ "You lose.");
			}
			System.out.println("Would you like to try again?\n"
					+ "Enter 'no' to quit");
			String answer = keyboard.next();
			if(answer.equals("no")) {
				System.out.println("Goodbye!");
				end = true;
			}
		}
	}
	//introduction and explanation of the game
	public static void printGreeting() {
		System.out.println("Welcome to the game!\n"
				+"You will be shown 5 items, \n"
				+ "try to guess the price of the them  \n"
				+ "equal to or below $1,300 of the total.");
		System.out.println();
	}
	//Method that gets a random prize from the array, adds its price to the 
	//total that isn't shown, and prints the name of the prize
	public static double printPrizes() {
		double total = 0;
		Prize[] currentPrizes = new Prize[5];
		for(int i = 0; i < currentPrizes.length; i++) {
			Prize randPrize = prizeManager.getPrize((int)Math.floor(Math.random()*prizeManager.getLength()));
			currentPrizes[i] = randPrize;
			total += randPrize.getPrice();	
		}
		//checks for duplicates and replaces if there are
		for(int i=0; i < currentPrizes.length; i++) {
			Prize pIndex = currentPrizes[i];
			for (int j = i+1; j < currentPrizes.length; j++) {
				if(pIndex.equals(currentPrizes[j])) {
					total -= currentPrizes[i].getPrice();
					Prize randPrize = prizeManager.getPrize((int)Math.floor(Math.random()*prizeManager.getLength()));
					currentPrizes[i] = randPrize;
					total += randPrize.getPrice();
				}
			}
			System.out.println(currentPrizes[i].getName());
		}
		return total;
	}

}
