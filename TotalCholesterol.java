import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TotalCholesterol extends ChemistryTest{
   
    protected boolean fasting;
    public TotalCholesterol(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 0.026;

    }
    @Override 
    public void TestTaken() {
        SIconverter();
        Scanner input = new Scanner(System.in);
        System.out.println("Total Cholesterol test taken");
        System.out.print("For accurate results, please fast for at least 9 hours before taking the test.");
        System.out.print("Enter the time of the last meal (HH:mm): ");
        String lastmeal = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        LocalTime mealLocalTime = LocalTime.parse(lastmeal, formatter);
        LocalDateTime lastMealTime = LocalDateTime.of(now.toLocalDate(), mealLocalTime);

 
        if (lastMealTime.isAfter(now)) {
            lastMealTime = lastMealTime.minusDays(1);
        }

        long hoursSinceMeal = Duration.between(lastMealTime, now).toHours();

        if (hoursSinceMeal >= 9) {
            fasting = true;
            System.out.println("You are allowed to take the Total Cholesterol test.");
            System.out.print("Enter your cholesterol level in mg/dL: ");
            mgdl = input.nextDouble();
            System.out.println("Your cholesterol in SI units: " + SIconverter() + " mmol/L");
            if (mgdl <= 200 ) {
                System.out.println("Result: Normal");
            } else if (mgdl <= 239) {
                System.out.println("Result: Borderline High");
            } else {
                System.out.println("Result: High");

            }
        } else {
            fasting = false;
            System.out.println("Please come back after " + (9 - hoursSinceMeal) + " more hours.");
        }
    }
    @Override
    public void AssignedDoc(){
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }

    @Override
    public double CalculateBill() {
        return 150.0;
    }
    @Override
     public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Total Cholesterol Result (mg/dL): " + mgdl);
    }
     
}