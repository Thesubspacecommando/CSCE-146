/*
 * James E
 */
import java.util.Scanner;
public class VGDatabaseFE {
	public static Scanner keyboard = new Scanner(System.in);
	public static VGManager Games = new VGManager();
	//Static LL for showing results, I don't need the LL for anything other than that
	private static GenLL<VideoGame> query;
	public static void main(String[] args) {
		printGreeting();
		boolean end = false;
		while(!end) {
			printOptions();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice) {
			case 1:
				loadData();
				break;
			case 2:
				String name = searchName();
				String console = searchCon();
				query = Games.searchGames(name, console);
				break;
			case 3:
				if(query != null) {
					conPrint(query);
				} else {
					System.out.println("You haven't searched anything!");
				}
				break;
			case 4:
				filePrint();
				break;
			case 9:
				System.out.println("Goodbye!");
				end = true;
			}
		}
	}
	public static void printGreeting() {
		System.out.println("Welcome to the Video Game Database!");
	}
	public static void printOptions() {
		System.out.println("1 = Load game database\n" 
				+ "2 = Search database\n"
				+ "3 = Print search results to console\n"
				+ "4 = Print search results to a file\n"
				+ "9 = End");
	}
	public static void loadData() {
		System.out.println("Please enter the file name");
		String file = keyboard.nextLine();
		Games.readFile(file);
	}
	public static String searchName() {
		System.out.println("Enter a name, or enter '*' to search all names");
		String name = keyboard.nextLine();
		return name;
	}
	public static String searchCon() {
		System.out.println("Enter a console, or enter '*' to search all consoles");
		String console = keyboard.nextLine();
		return console;
	}
	public static void conPrint(GenLL<VideoGame> query) {
		query.print();
	}
	public static void filePrint() {
		System.out.println("Type the file name");
		String file = keyboard.nextLine();
		System.out.println("Do you want to append the file?\n"
				+ "Type 'true' if yes, 'false' if no");
		boolean append = keyboard.nextBoolean();
		keyboard.nextLine();
		Games.writeFile(file, query, append);
	}
	
}
