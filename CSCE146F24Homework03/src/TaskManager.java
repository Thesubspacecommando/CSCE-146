/*
 * James E
 */
//Manages the task list
import java.util.Scanner;
import java.io.*;
public class TaskManager {
	public static final String DELIM = "\t";
	public static final int TASK_AMT = 2;
	private GenLL<Task>[] tasks;
	@SuppressWarnings("unchecked")
	public TaskManager() {
		//creates an array of Linked Lists, priority being the index of the array
		this.tasks = new GenLL[5];
		for(int i = 0; i < tasks.length; i++) {
			tasks[i] = new GenLL<Task>();
		}
	}
	
	public boolean addTask(int aP, String aN) {
		Task nTask = new Task(aP, aN);
		tasks[aP].reset();
		while(tasks[aP].hasMore()) {
			//checks if a task already exists
			if(tasks[aP].getCurrent().equals(nTask)) {
				return true; //returns an error and doesn't add into list
			}
			tasks[aP].goToNext();
		}
 		tasks[aP].add(nTask);
 		return false;
	}
	//removes a task if it exists
	public void removeTask(int aP, String aN) {
		Task rTask = new Task(aP, aN);
		tasks[aP].reset();
		while(tasks[aP].hasMore()) {
			if(tasks[aP].getCurrent().equals(rTask)) {
				tasks[aP].removeCurrent();
			}
			tasks[aP].goToNext();
		}
	}
	//prints the list onto the console
	public void printTasks() {
		for(int i = 0; i < tasks.length; i++) {
			tasks[i].print();
		}
	}
	
	public void readTaskFile(String file) {
		try {
			Scanner fileReader = new Scanner(new File("./" + file));	
			while(fileReader.hasNextLine()) {
				String fileLine = fileReader.nextLine();
				String[] splitLine = fileLine.split(DELIM);
				if(splitLine.length == TASK_AMT) {
					int priority = Integer.parseInt(splitLine[0]);
					String action = splitLine[1];
					Task aTask = new Task(priority, action);
					tasks[priority].add(aTask); //Doesn't use the method inside Task Manager since this does the same job
				}
			}
			fileReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeTaskFile(String file) {
		try {
			PrintWriter fileWriter = new PrintWriter(file);
			for(int i = 0; i < tasks.length; i++) {
				tasks[i].reset();
				while(tasks[i].hasMore() ) {
					fileWriter.println(tasks[i].getCurrent());
					tasks[i].goToNext();
				}
			}
			fileWriter.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
