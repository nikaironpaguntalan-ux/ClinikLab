import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class LDL extends ChemistryTest{
    boolean fasting;
    public LDL(String name, String sex, int age){
        super(name, sex, age, 0.0);

    }
    @Override
    public double SIconverter(){
        return mgdl * 0.026;
    }
    @Override
    public void TestTaken(){
        SIconverter();
         Scanner input = new Scanner(System.in);
        System.out.println("LDL test taken");
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
            System.out.println("You are allowed to take the LDL test.");
            System.out.print("Enter your LDL level in mg/dL: ");
            mgdl = input.nextDouble();
            System.out.println("Your LDL in SI units: " + SIconverter() + " mmol/L");
            if (mgdl < 49 ) {
                System.out.println("Result: Low");
            } else if (mgdl >= 50 && mgdl <= 130) {
                System.out.println("Result: Normal");
            } else {
                System.out.println("Result: High");

            }
        } else {
            fasting = false;
            System.out.println("Please come back after " + (9 - hoursSinceMeal) + " more hours.");
        }
    }
    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }
    @Override
    public double CalculateBill(){
        return 300.0;

    }
    @Override
    public void displayPatientInfo(){
        super.displayPatientInfo();
        System.out.println("LDL result: " + mgdl + " mg/dL");
        AssignedDoc();
    }



} 