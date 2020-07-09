
public enum Flavor {
	
	VANILLA(false, "Vanilla"), CHOCOLATE(false, "Chocolate"), STRAWBERRY(true, "Strawberry"),
	LEMON(true, "Lemon"), PISTACHIO(false, "Pistachio"), PEANUT_BUTTER(false, "Peanut Butter");
	
	private boolean nutFree;
	private String displayFlavor;
	
	private Flavor(boolean nutFree, String displayFlavor) {
		this.nutFree = nutFree;
		this.displayFlavor = displayFlavor;
	}
	
	public boolean isNutFree() {
		return nutFree;
	}
	
	@Override
	public String toString() {
		String nutString = nutFree ? "" : " (may contain nuts)";
		return displayFlavor + nutString;
	}

}
