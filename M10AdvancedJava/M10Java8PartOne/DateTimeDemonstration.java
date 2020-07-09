import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class DateTimeDemonstration {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");  
        System.out.println("Today is " + today.format(outputFormatter));

        
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("Today is still " + today.format(outputFormatter));
        System.out.println("Tomorrow is " + tomorrow.format(outputFormatter));  
        
       
        LocalDate aprilFools = LocalDate.of(2019, Month.APRIL, 1);
        Period timeToFool = Period.between(today, aprilFools);
        System.out.println(timeToFool);
        //System.out.println("April Fools Day is in " + timeToFool.get(ChronoUnit.DAYS) + " days");       
        System.out.println("April Fools Day is in " + timeToFool.get(ChronoUnit.MONTHS) + " months and " +
                timeToFool.get(ChronoUnit.DAYS) + " days");
        System.out.println("April Fools Day is in " + ChronoUnit.DAYS.between(today, aprilFools) + " days");

        
        String midtermsString = "11-06-2018";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("LL-dd-yyyy");
        LocalDate midterms = LocalDate.parse(midtermsString, inputFormatter);
        boolean alreadyHappened = today.isAfter(midterms);
        System.out.println("The midterm election " + (alreadyHappened ? "has" : "has not") + " already happened.");
        LocalDate dayBeforeMidterms = midterms.minus(1, ChronoUnit.DAYS);
        System.out.println("There will be lots of campaigning on " + dayBeforeMidterms.format(outputFormatter));
       
       
        String birthdayString = "06-08-2014";
        LocalDate birthdayDate = LocalDate.parse(birthdayString, inputFormatter);
        LocalDate birthdayDateCurrentYear = LocalDate.of(LocalDate.now().getYear(), birthdayDate.getMonth(), birthdayDate.getDayOfMonth());
        alreadyHappened = today.isAfter(birthdayDateCurrentYear);
        System.out.println("This birthday " + (alreadyHappened ? "has" : "has not") + " already happened.");

        
        Period lifeDays = Period.between(birthdayDate, today);
       // System.out.println("There have been " + lifeDays.getDays() + " days since birth!"); 
        System.out.println("There have been " + ChronoUnit.DAYS.between(birthdayDate,  today) + " days since birth!"); 
        //System.out.println("There have been " + ChronoUnit.SECONDS.between(birthdayDate, today));
       
      
        Instant programStart = Instant.now();
        try { Thread.sleep(3000); } catch(Exception ex) {}       
        Instant programEnd = Instant.now();
        Duration programRunTime = Duration.between(programStart,  programEnd);
        System.out.println("This demonstration took "  +  programRunTime.getSeconds() + " seconds.");
        System.out.println("This demonstration took "  +  ChronoUnit.SECONDS.between(programStart, programEnd) + " seconds.");
        //System.out.println("This demonstration took " + ChronoUnit.YEARS.between(programStart, programEnd));
        
    }

}
