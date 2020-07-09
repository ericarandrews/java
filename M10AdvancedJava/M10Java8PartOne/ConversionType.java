public enum ConversionType {
    
    POUNDS_TO_OUNCES (16, "Pounds to Ounces"), 
    OUNCES_TO_POUNDS(0.0625, "Ounces to Pounds"), 
    GRAMS_TO_OUNCES (0.035274, "Grams to Ounces"), 
    OUNCES_TO_GRAMS(28.3495, "Ounces to Grams");
    
    private double conversionFactor;
    private String displayString;
    
    private ConversionType(double conversionFactor, String displayString) {
        this.conversionFactor = conversionFactor;
        this.displayString = displayString;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
    
    @Override
    public String toString() {
        return displayString;
    }

}
