/*
 * James E
 */
import java.util.Scanner;
public class CommandFE {
	public static Scanner keyboard = new Scanner(System.in);
	public static CommandManager Manager = new CommandManager();
	public static void main(String[] args) {
		printGreeting();
		boolean quit = false;
		while(!quit) {
			System.out.println("Please type a file for the board.");
			char[][] board = Manager.readBoard(keyboard.nextLine());
			System.out.println("Please type a file for the robot commands.");
			Manager.loadCommands(keyboard.nextLine());
			Manager.execute(board);
			System.out.println("Would you like to quit? \n"
					+ "Enter true if you want to quit and false otherwise");
			quit = keyboard.nextBoolean();
			keyboard.nextLine();
		}
	}
	public static void printGreeting() {
		System.out.println("Welcome to the Robot Simulator");
	}

}
