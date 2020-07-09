
public class NoPayer implements Payer {

	@Override
	public void pay() {
		System.out.println("No pay is issued.");
	}
	
}
