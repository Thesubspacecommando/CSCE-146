/*
 * James E
 */
//class for the games in the database, has a name and console
public class VideoGame {
	private String name;
	private String console;
	public VideoGame() {
		this.name = "none";
		this.console = "none";
	}
	
	public VideoGame(String aN, String aC) {
		this.setName(aN);
		this.setConsole(aC);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null) {
			this.name = name;
		} else
		this.name = "none";
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		if(console != null) {
			this.console = console;
		} else
		this.console = "none";
	}
	
	public String toString() {
		return "Name: " +this.name + " Console: " +this.console;
	}
	
	//Separated into two methods because I needed two separate variables  
	public boolean equalsName(String aN) {
		if(aN.equals("*")) {
			return true;
		} else {
			return aN != null &&
					this.name.toLowerCase().contains(aN.toLowerCase()); // contains allows for partial matches
		}
	}
	public boolean equalsCon(String aC) {
		if(aC.equals("*")) {
			return true;
		} else {
			return aC != null &&
					this.console.toLowerCase().contains(aC.toLowerCase());
		}
	}
}
