
public class PoundsToOunces implements Converter {

    public static final double POUNDS_IN_OUNCES = 16;
    
    public double convert(double pounds) {
        return pounds * POUNDS_IN_OUNCES;
    }
}
