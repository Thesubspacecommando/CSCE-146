/*
 * James E
 */
import java.util.Scanner;
public class TaskManagerFE {
	public static Scanner input = new Scanner(System.in);
	public static TaskManager TM = new TaskManager(); //TM = task manager
 public static void main(String args[]) {
	 printGreeting();
	 boolean end = false;
	 while(!end) {
		 printOptions();
		 int choices = input.nextInt();
		 input.nextLine();
		 switch(choices) {
		 case 1:
			 addTask();
			 break;
		 case 2:
			 removeTask();
			 break;
		 case 3:
			 printTasks();
			 break;
		 case 4:
			 readTasks();
			 break;
		 case 5:
			 writeTasks();
			 break;
		 case 9:
			 System.out.println("Goodbye!");
			 end = true;
			 break;
		 }
	 }
 }
 
 	public static void printGreeting() {
		System.out.println("Welcome to the Task Organizer!");
 	}
 	
 	public static void printOptions() {
		System.out.println("1 = Add a task\n" 
				+ "2 = remove a task\n"
				+ "3 = Print task list to console\n"
				+ "4 = read task list from a file\n"
				+ "5 = write task list to a file\n"
				+ "9 = End");
 	}
 	
 	public static void addTask() {
 		System.out.println("Please enter a priority number:");
 		int priority = input.nextInt();
 		input.nextLine();
 		System.out.println("Please enter the task's name:");
 		String name = input.nextLine();
 		boolean error = TM.addTask(priority, name);
 		if(error) { // error code for if a duplicate exists
 			System.out.println("!!ERROR!!: A duplicate exists.\n"
 					+ "The item wasn't added as a result.");
 		}
 	}
 	
 	public static void removeTask() {
 		System.out.println("Please enter a priority number:");
 		int priority = input.nextInt();
 		input.nextLine();
 		System.out.println("Please enter the task's name:");
 		String name = input.nextLine();
 		TM.removeTask(priority, name);
 	}
 	
 	public static void printTasks() {
 		TM.printTasks();
 	}
 	
 	public static void readTasks() {
 		System.out.println("Please type a file name:");
 		String file = input.nextLine();
 		TM.readTaskFile(file);
 	}
 	public static void writeTasks() {
 		System.out.println("Please enter a file name:");
 		String file = input.nextLine();
 		TM.writeTaskFile(file);
 	}
 	
}
