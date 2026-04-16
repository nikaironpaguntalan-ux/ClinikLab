import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Triglycerides extends ChemistryTest {
    boolean fasting;

    public Triglycerides(String name, String sex, int age) {
        super(name, sex, age, 0.0);
    }

    @Override
    public double SIconverter() {
        return mgdl * 0.0114;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Triglycerides test taken");
        System.out.println("For accurate results, please fast for at least 9 hours before taking the test.");
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
            System.out.println("You are allowed to take the Triglycerides test.");
            System.out.print("Enter your Triglycerides level in mg/dL: ");
            mgdl = input.nextDouble();
            System.out.println("Your Tryglicerides in SI units: " + SIconverter() + " mmol/L");
            InterpretResult();
        } else {
            fasting = false;
            System.out.println("Please come back after " + (9 - hoursSinceMeal) + " more hours.");
        }
    }

    @Override
    public void InterpretResult() {
        if (sex.equalsIgnoreCase("male")) {
            if (mgdl <= 59) {
                System.out.println("Result: Low Triglycerides (High Heart Risk)");
            } else if (mgdl >= 60 && mgdl <= 165) {
                System.out.println("Result: Normal Triglycerides");
            } else {
                System.out.println("Result: High Triglycerides");
            }
        } else if (sex.equalsIgnoreCase("female")) {
            if (mgdl <= 39) {
                System.out.println("Result: Low Triglycerides (High Heart Risk)");
            } else if (mgdl >= 40 && mgdl <= 140) {
                System.out.println("Result: Normal Triglycerides");
            } else {
                System.out.println("Result: High Triglycerides");
            }
        } else {
            System.out.println("Invalid sex entered. Please enter 'male' or 'female'.");
        }
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }

    @Override
    public double CalculateBill() {
        return 300.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Tryglicerides result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }
}
