/* 
 * *************************************************************
 * DO NOT MODIFY THIS CLASS!!!
 * ************************************************************* 
 * */

public class Voter {
	
	private int id;
	private String name;
	
	public Voter(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + " (" + id + ")";
	}
	

	
	
}
