
public class OuncesToGrams implements Converter {

    public static final double OUNCES_TO_GRAMS = 28.3495;
      
      public double convert(double pounds) {
          return pounds * OUNCES_TO_GRAMS;
      }
  }
