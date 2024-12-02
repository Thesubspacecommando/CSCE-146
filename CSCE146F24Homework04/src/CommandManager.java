/*
 * James E
 */
import java.util.Scanner;
import java.io.*;
public class CommandManager {
	public static final char ROB = 'O';
	public static final char SPACE = '_';
	public static final char OBST = 'X';
	public static final String LEFT = "Move Left";
	public static final String RIGHT = "Move Right";
	public static final String UP = "Move Up";
	public static final String DOWN = "Move Down";
	private QueueI<String> queue;
	public CommandManager() {
		this.queue = new LLQueue<String>();
	}
	
	public char[][] readBoard(String bFile) { // creates a 2D array that acts as the board which it reads from the text file.
		try {
			Scanner fileReader = new Scanner(new File("./" + bFile));
			char[][] spaces = new char[10][10]; 
			int i = 0;
			while(fileReader.hasNextLine()) {
				 String fileLine = fileReader.nextLine();
				 char[] line = fileLine.toCharArray();
				 for(int j = 0; j < spaces.length; j++) {
					 spaces[i][j] = line[j];
				 }
				 i++;
			}
			fileReader.close();
			return spaces;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void loadCommands(String cFile) { // creates a queue that acts as the robot commands which it reads from the text file.
		try {
			Scanner fileReader = new Scanner(new File("./" + cFile));
			while(fileReader.hasNextLine()) {
				queue.enqueue(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void execute(char[][] board) {
		board[0][0] = ROB;
		this.printboard(board);
		int robX = 0;
		int robY = 0;
		int commandNum = 0;
		while(queue.hasMore()) {
			System.out.println("Command" + commandNum);
			String command = queue.dequeue();
			if(command.equals(LEFT)) {
				if(board[robY][robX-1] == OBST || robX-1 < 0) { //if the character hits an X or goes out of bounds
					System.out.println("CRASH!\n"
							+ "Sim ended");
					return;
				} else { //Replace current charcter's space with an empty space, change the character's x value by -1, and then update the character's position
					board[robY][robX] = SPACE;
					robX -= 1;
					board[robY][robX] = ROB;
					
				}
			}
			if(command.equals(RIGHT)) {
				if(board[robY][robX+1] == OBST || robX+1 > 9) {
					System.out.println("CRASH!\n"
							+ "Sim ended");
					return;
				} else {
					board[robY][robX] = SPACE;
					robX += 1;
					board[robY][robX] = ROB;
				}
			}
			if(command.equals(UP)) {
				if(board[robY-1][robX] == OBST || robY-1 < 0) {
					System.out.println("CRASH!\n"
							+ "Sim ended");
					return;
				} else {
					board[robY][robX] = SPACE;
					robY -= 1;
					board[robY][robX] = ROB;
				}
			}
			if(command.equals(DOWN)) {
				if(board[robY+1][robX] == OBST || robY+1 > 9) {
					System.out.println("CRASH!\n"
							+ "Sim ended");
					return;
				} else {
					board[robY][robX] = SPACE;
					robY += 1;
					board[robY][robX] = ROB;
				}
			}
			this.printboard(board);
			commandNum++;
		}
		System.out.println("Sim end");
	}
	public void printboard(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
