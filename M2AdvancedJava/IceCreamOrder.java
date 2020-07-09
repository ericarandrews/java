
public class IceCreamOrder {
	
	private int numberScoops;
	private Flavor flavor;
	
	private static int totalNumberScoops = 0;
	
	private static final int DEFAULT_NUMBER_SCOOPS = 1;
	
	public IceCreamOrder(int numberScoops, Flavor flavor) {
		this.numberScoops = numberScoops;
		this.flavor = flavor;
		
		IceCreamOrder.totalNumberScoops += numberScoops;
	}
	public IceCreamOrder(Flavor flavor) {
		this(DEFAULT_NUMBER_SCOOPS, flavor);
	}
	
	public int getNumberScoops() {
		return numberScoops;
	}
	public Flavor getFlavor() {
		return flavor;
	}
	public static int getTotalNumberScoops() {
		return IceCreamOrder.totalNumberScoops;
	}
	
	@Override
	public String toString() {
		String scoopString = (numberScoops==1) ? "scoop" : "scoops";
		return numberScoops + " " + scoopString + " of " + flavor ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IceCreamOrder) {
			IceCreamOrder other = (IceCreamOrder) obj;
			return this.numberScoops==other.numberScoops && this.flavor.equals(other.flavor);
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	

	

}
