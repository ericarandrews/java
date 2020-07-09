import java.time.*;
import java.time.temporal.*;

public class FeatureSpot<T extends Item>  {
	
	private T item;
	private LocalTime start, end;
	private int featuredItemCount;
	
	public FeatureSpot() {
		this.featuredItemCount = 0;
		this.item = null;
	}
	
	public void featureItem(T item, int numberOfMinutes) {
		featuredItemCount++;
		this.item = item;
		this.start = LocalTime.now();	
		this.end = this.start.plusMinutes(numberOfMinutes);
	}
	
    public boolean isAnythingFeatured() {
        LocalTime now = LocalTime.now();
        if (start.isBefore(now) && now.isBefore(end)) {
            return true;
        } else {
            return false;
        }
    }
	
	public T getItem() {
		return item;
	}

	public LocalTime getStart() {
		return start;
	}

	public LocalTime getEnd() {
		return end;
	}

	@Override
	public String toString() {
		if(!isAnythingFeatured()) {
			return "There is no featured item at this time." +
					"\n\tThere have been " + featuredItemCount + " items featured.";
		} else {
			return "Featured Item!\n" + item.toString() + 
			        "\nThis item will be featured until " + end.truncatedTo(ChronoUnit.MINUTES) +
					"\nThere have been " + featuredItemCount + " items featured.\n";
		}
	}
	
	

	

}
