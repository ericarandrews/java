
public class GramsToOunces implements Converter {

    public static final double GRAMS_TO_OUNCES = 0.035274;
      
      public double convert(double pounds) {
          return pounds * GRAMS_TO_OUNCES;
      }
  }
