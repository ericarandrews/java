
public enum Category {

    MAKEUP("Makeup Products (non-permanent)"),
    HAIR_NONCOLOR("Hair Care Products (non-coloring)"),
    NAIL("Nail Products"),
    PERSONAL("Personal Care Products"),
    SUN("Sun-Related Products"),
    BATH("Bath Products"),
    SKIN("Skin Care Products"), 
    FRAGRANCE("Fragrances"),
    TATOOS("Tattoos and Permanent Makeup"),
    HAIR_COLOR("Hair Coloring Products"),
    ORAL_HYGIENE("Oral Hygiene Products"),
    SHAVING("Shaving Products"),
    BABY("Baby Products");
    
    private String description;
    
    private Category(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}
