/*
 * James E
 */

import java.io.*;
import java.util.Scanner;
//All of the back end functions for the database
public class VGManager {
	private GenLL <VideoGame> games;
	private static final String DELIM = "\t";
	private static final String END_LINE = "\n";
	private static final int FIELD_AMT = 2;
	
	public VGManager() {
		games = new GenLL<VideoGame>();
	}
	
	//loads the file into an LL so that the search method can do it's job
	public void readFile(String aN) {
		try {
			Scanner fileReader = new Scanner(new File("./"+ aN));
			while(fileReader.hasNextLine()) {
				String fileLine = fileReader.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if (splitLines.length == FIELD_AMT) {
					String name = splitLines[0];
					String console = splitLines[1];
					VideoGame nV = new VideoGame(name,console);
					games.add(nV);
				}
			}
			fileReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//creates a separate LL that holds the results of the names brought up by the user.
	public GenLL<VideoGame> searchGames(String name, String console) {
		GenLL<VideoGame> results = new GenLL<VideoGame>();
		games.reset();
		while(games.hasMore()) {
			if(games.getCurrent().equalsName(name) && games.getCurrent().equalsCon(console)) {
				results.add(games.getCurrent());
			}
			games.goToNext();
		}
		return results;
	}
	//writes a new file or appends the search results to a new file
	public void writeFile(String file, GenLL<VideoGame> results, boolean append) {
		try {
			Scanner fileReader = new Scanner(new File("./" + file)); //I hate this line it caused me a day of trouble because I didn't make the file a new file so it interpreted the text as a String and not a file
			GenLL<VideoGame> temp = new GenLL<VideoGame>();
			if(append) {
				while(fileReader.hasNextLine()) {
					String fileLine = fileReader.nextLine();
					String[] splitLines = fileLine.split(DELIM);
					if (splitLines.length == FIELD_AMT) {
						String name = splitLines[0];
						String console = splitLines[1];
						VideoGame nV = new VideoGame(name,console);
						temp.add(nV);
					}
				}
			}
			PrintWriter fileWriter = new PrintWriter(file);
			temp.reset();
			while(temp.hasMore()) {
				fileWriter.print(temp.getCurrent().getName() + DELIM +
						temp.getCurrent().getConsole() + END_LINE);
				temp.goToNext();
			}
			results.reset();
			while(results.hasMore()) {
				fileWriter.write(results.getCurrent().getName() + DELIM +
						results.getCurrent().getConsole() + END_LINE);
				results.goToNext();
			}

			fileWriter.close();
			fileReader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
