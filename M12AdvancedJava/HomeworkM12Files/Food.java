public class Food {
	
	private String name;
	private int cookTime, serveTime; // number of seconds
	
	public Food(String name, int cookTime, int serveTime) {
		this.name = name;
		this.cookTime = cookTime;
		this.serveTime = serveTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCookTime() {
		return cookTime;
	}
	public void setCookTime(int cookTime) {
		if(cookTime > 0) 
			this.cookTime = cookTime;
	}
	public int getServeTime() {
		return serveTime;
	}
	public void setServeTime(int serveTime) {
		if(serveTime > 0) 
			this.serveTime = serveTime;
	}
	
	public String toString() {
		return name + " (" + cookTime + " TO COOK, " + serveTime + " TO SERVE)";
	}
	
	
	

}
