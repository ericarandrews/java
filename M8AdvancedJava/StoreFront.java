import java.awt.Color;

public class StoreFront {

	public static void main(String[] args) {
	    Book bookItem1 = new Book("Java Rules", "Oracle");
		Clothing clothingItem1 = new Shirt("Childs Tee", Clothing.Size.SMALL, Color.RED);
		Clothing clothingItem2 = new Shirt("Mens Button Down", Clothing.Size.LARGE, Color.BLUE);
		
		
		FeatureSpot<Item> mainFeature = new FeatureSpot<>();
		mainFeature.featureItem(bookItem1, 60);
		//System.out.println(mainFeature);
		mainFeature.featureItem(clothingItem1, 60);
		try { Thread.sleep(100); } catch(InterruptedException ex) {} // to slow things down so we can see the print!
		//System.out.println(mainFeature);

	
		FeatureSpot<Clothing> clothesFeature = new FeatureSpot<>();
	    //clothesFeature.featureItem(bookItem1, 15); // COMPILER ERROR
		clothesFeature.featureItem(clothingItem2, 15); // try changing declared type of item2! that wil give an error because the declared type (Item) is not compatible with Clothing
	    try { Thread.sleep(100); } catch(InterruptedException ex) {}
        //System.out.println(clothesFeature);
		
        /*
		FeatureSpot<String> wordFeature = new FeatureSpot<>(); // COMPILER ERROR!
		wordFeature.featureItem("hello", 1);
	    try { Thread.sleep(100); } catch(InterruptedException ex) {}
	    System.out.println(wordFeature);
		*/
        
	  
	    // methods to demonstrate upper bounded wildcard
	    printItemNonBounded(mainFeature); // type of mainFeature is FeatureSpot<Item>
	    //printItemNonBounded(clothesFeature); // COMPILER ERROR- FeatureSpot<Item> expected; FeatureSpot<Clothing> cannot be sent
	   
	    printItem(mainFeature); // type of mainFeature is FeatureSpot<Item>
        printItem(clothesFeature); // type of clothesFeature is FeatureSpot<Clothing>
        // which is compatible with FeatureSpot<? extends Item> because Clothing extends Item
       
        // methods to demonstrate lower bounded wildcard
        featureNewItem(mainFeature); // type of mainFeature is FeatureSpot<Item>
        //featureNewItem(clothesFeature); // COMPILER ERROR
        
        featureNewClothing(mainFeature);
        featureNewClothing(clothesFeature);
       
        // methods to demonstrate unbounded wildcard
        getStringOfFeaturedItem(mainFeature);
        getStringOfFeaturedItem(clothesFeature);
		
	}
	
	/* methods to demonstrate upper bounded wildcard */
	public static void printItemNonBounded(FeatureSpot<Item> spot) {
	    Item item = spot.getItem();
	    System.out.println(item);
	}
	public static void printItem(FeatureSpot<? extends Item> spot) {
        Item item = spot.getItem();
        System.out.println(item);

	}
	public static void upperBoundRestrictions(FeatureSpot<? extends Item> spot) {
	    Item retreivedItem = spot.getItem(); // "getter"- allowed!
	    
	    Item item = new Book("Java Rules2", "Oracle");
	    //spot.featureItem(item, 60); // COMPILER ERROR! this is like a "setter"- not allowed      
	}

	
	
    /* methods to demonstrate lower bounded wildcard */
    public static void featureNewItem(FeatureSpot<? super Item> spot) {
        Item item = new Book("Java Rules2", "Oracle");
        spot.featureItem(item, 60); // invoking a "setter" type method
    }
    public static void featureNewClothing(FeatureSpot<? super Clothing> spot) {
        Clothing clothingItem = new Shirt("Womens Button Down", Clothing.Size.LARGE, Color.WHITE);
        spot.featureItem(clothingItem, 60);
        //Clothing clothingItem1 = spot.getItem(); // COMPILER ERROR! the FeatureSpot could hold Items that aren't Clothing!
    }
    public static void lowerBoundRestrictions(FeatureSpot<? super Clothing> spot) {
        Item item = new Book("Java Rules2", "Oracle");
        //spot.featureItem(item, 60); // COMPILER ERROR! an "Item" could be a Book!
        
        Clothing clothingItem = new Shirt("Womens Button Down", Clothing.Size.LARGE, Color.WHITE);
        // try changing the declared type of clothingItem to Item!
        spot.featureItem(clothingItem, 60);
        
        //Clothing retrievedClothing = spot.getItem(); // COMPILER ERROR! 
        Item retrievedItem = spot.getItem(); 
    }

    /* method to demonstrate unbounded wildcard */

	public static String getStringOfFeaturedItem(FeatureSpot<?> spot) {
		Object item = spot.getItem();
		String s = spot.toString();
		return s;
	}

	

}
