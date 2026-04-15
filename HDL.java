import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class HDL extends ChemistryTest{
     boolean fasting;

    public HDL(String name, String sex, int age) {
        super(name, sex, age, 0.0);
        
        }
    
    @Override
    public double SIconverter() {
        return mgdl * 0.026;
    }

    @Override
    public void TestTaken() {
        SIconverter();
        Scanner input = new Scanner(System.in);
        System.out.println("HDL test taken");
        System.out.println("For Accurate result please fast for at least 9 hours before taking the test.");
        System.out.println("Enter the time of the last meal (HH:mm): ");
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
            System.out.println("You are allowed to take the HDL test.");
            System.out.print("Enter your HDL level in mg/dL: ");
            mgdl = input.nextDouble();
            System.out.println("Your HDL in SI units: " + SIconverter() + "mmol/L");
            if (sex.equalsIgnoreCase("male")) {
                if (mgdl <=34.0 ) {
                    System.out.println("Result: Low HDL (High Heart Risk)");
                } else if (mgdl >= 35.0 && mgdl <=80.0) {
                    System.out.println("Result: Normal HDL");
                } else {
                    System.out.println("Result: High HDL");
                }
            } else if (sex.equalsIgnoreCase("female")) {
                if (mgdl<=41.0 ) {
                    System.out.println("Result: Low HDL (High Heart Risk)");
                } else if (mgdl >= 42.0 && mgdl <= 88.0) {
                    System.out.println("Result: Normal HDL");
                } else {
                    System.out.println("Result: High HDL");
                }
            } else {
                System.out.println("Invalid sex entered. Please enter 'male' or 'female'.");
            }        

    }
}
@Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }

    @Override
    public double CalculateBill() {
        return 250.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("HDL Result (mg/dL): " + mgdl);
    }
}
