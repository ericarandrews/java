import java.text.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class PoliceReport implements Comparable<PoliceReport>{

	private long incidentNum;
	private String category;
	private String description;
	private DayOfWeek day;
	private LocalDate date;
	private String district;
	private String resolution;
	private String address;
	
	public PoliceReport(long incidentNum, String category, String description, String dayString, String dateString, String district,
			String resolution, String address)  {
		this.incidentNum = incidentNum;
		this.category = category;
		this.description = description;
		
	    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("L/d/yyyy");
	    this.date = LocalDate.parse(dateString, inputFormatter);
	    this.day = DayOfWeek.valueOf(dayString.toUpperCase());
	    this.district = district;
		this.resolution = resolution;
		this.address = address;	
	}
	
	public PoliceReport() {
		this(-1, null, null, "MONDAY", "01/01/0001", null, null, null);
	}
	
	public long getIncidentNum() {
		return incidentNum;
	}
	public void setIncidentNum(long incidentNum) {
		this.incidentNum = incidentNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setDate(String dateString) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("L/d/yyyy");
		this.date = LocalDate.parse(dateString, inputFormatter);
	}
	public void setDay(String dayString) {
		 this.day = DayOfWeek.valueOf(dayString.toUpperCase());
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		String s = "Incident #" + incidentNum +
				"\tDate: " + date;
				/* + " (" + getDay() + ")"+ 
				"\n\tCategory: " + category +
				"\tDescription: " + description + 
				"\tResolution: " + resolution + 	
				"\n\tDistrict: " + district + 
				"\tAddress: " + address;*/
		return s;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof PoliceReport) {
			PoliceReport otherReport = (PoliceReport) other;
			return date.equals(otherReport.date);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
	@Override
	public int compareTo(PoliceReport otherReport) {
		return date.compareTo(otherReport.date);
	}
	
	public boolean isOnDate(String dateString) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("L/d/yyyy");
		LocalDate dateToCheck = LocalDate.parse(dateString, inputFormatter);
		return this.date.equals(dateToCheck);
	}

	
}
