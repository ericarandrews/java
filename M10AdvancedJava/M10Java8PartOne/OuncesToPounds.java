
public class OuncesToPounds implements Converter {

  public static final double OUNCES_TO_POUNDS = 0.0625;
    
    public double convert(double pounds) {
        return pounds * OUNCES_TO_POUNDS;
    }
}
