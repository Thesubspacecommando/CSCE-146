/*
 * James E
 */
//Object for task, has a name and a priority
public class Task {
	private int priority;
	private String action;
	public Task() {
		this.priority = 4;
		this.action = "none";
	}
	public Task(int aP, String aN) {
		this.setPriority(aP);
		this.setAction(aN);
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		if(priority >= 4) {
			this.priority = 4;
		} else {
			this.priority = priority;
		}
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		if(action != null) {
			this.action = action;
		} else {
			this.action = "none";
		}
	}
	public String toString() {
		return "Priority: " + this.priority + " Task: " + this.action;
	}
	//for removing and checking for duplicates
	public boolean equals(Task aTask) {
		return aTask != null &&
				this.priority == aTask.getPriority() &&
				this.action.equals(aTask.getAction());
	}
}
