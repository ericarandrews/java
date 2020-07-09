import java.awt.Color;

public class Shirt extends Clothing {
	
	private Color color;
	
	public Shirt(String name, Size size, Color color) {
		super(name, size);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Color: R" + color.getRed() + " G" + color.getGreen() + " B" + color.getBlue();
	}

}
