
public class ConverterFactory {
    
    public static final double POUNDS_IN_OUNCES = 16;
    public static final double OUNCES_IN_POUNDS = 0.0625;
    public static final double GRAMS_IN_OUNCES = 0.035274;
    public static final double OUNCES_IN_GRAMS = 28.3495;
 
    public static Converter createConverter(ConversionType type) {
        switch(type) {
        case POUNDS_TO_OUNCES: return (double pounds) -> pounds * POUNDS_IN_OUNCES;
        case OUNCES_TO_POUNDS: return (double ounces) -> ounces * OUNCES_IN_POUNDS;
        case GRAMS_TO_OUNCES: return (double grams) -> grams * GRAMS_IN_OUNCES;
        case OUNCES_TO_GRAMS: return (double ounces) -> ounces * OUNCES_IN_GRAMS;
        }
        return null;
        
    }
    
    public static Converter createConverterOldSchool(ConversionType type) {
        switch(type) {
        case POUNDS_TO_OUNCES: return new PoundsToOunces();
        case OUNCES_TO_POUNDS: return new OuncesToPounds();
        case GRAMS_TO_OUNCES: return new GramsToOunces();
        case OUNCES_TO_GRAMS: return new OuncesToGrams();
        
        }
        return null;
    }

}
