import java.util.*;

public class Product {
    
    private String name, company, brand, colorScentFlavor;
    private Category category;
    private Set<String> chemicalSet;
    
    public Product(String name, String company, String brand, String colorScentFlavor, Category category) {
        this.name = name;
        this.company = company;
        this.brand = brand;
        this.category = category;
        this.colorScentFlavor = colorScentFlavor;
        this.chemicalSet = new HashSet<String>();
    }

   public boolean addChemical(String chemical) {
	   return chemicalSet.add(chemical);
   }
   
   public int getNumberOfChemicals() {
       return chemicalSet.size();
   }
    
    @Override
    public String toString() {
    	return name + ", company=" + company + ", brand=" + brand + ", colorScentFlavor="
                + colorScentFlavor + ", category=" + category.getDescription() + ", number=" + getNumberOfChemicals();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, brand, colorScentFlavor, category);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product) {
            Product otherProduct = (Product) obj;
            return otherProduct.name.equalsIgnoreCase(name) &&
                    otherProduct.company.equalsIgnoreCase(company)&&
                    otherProduct.brand.equalsIgnoreCase(brand)&&
                    otherProduct.colorScentFlavor.equalsIgnoreCase(colorScentFlavor)&&
                    otherProduct.category==(category);
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

     public String getCompany() {
        return company;
    }

 
    public String getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getChemicals() {
        return new ArrayList<String>(chemicalSet);
    }

}
