import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FBS extends ChemistryTest {
  protected boolean fasting;
  public FBS(String name, String sex, int age) {
        super(name, sex, age, 0.0);
    }

    @Override 
    public double SIconverter() {
        return mgdl * 0.055;
    }

    @Override 
    public void TestTaken() {
        SIconverter();
        Scanner input = new Scanner(System.in);
        System.out.println("FBS test taken");
        System.out.print("Enter the time of the last meal (HH:mm): ");
        String lastmeal = input.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime now = LocalDateTime.now();
            LocalTime mealLocalTime = LocalTime.parse(lastmeal, formatter);
            LocalDateTime lastMealTime = LocalDateTime.of(now.toLocalDate(), mealLocalTime);

            if (lastMealTime.isAfter(now)) {
                lastMealTime = lastMealTime.minusDays(1);
            }

            long hoursSinceMeal = Duration.between(lastMealTime, now).toHours();

            if (hoursSinceMeal >= 8) {
                fasting = true;
                System.out.println("You are allowed to take the FBS test.");
                System.out.print("Enter your blood glucose in mg/dL: ");
                mgdl = input.nextDouble();
                System.out.println("Your glucose in SI units: " + SIconverter() + " mmol/L");

                if (mgdl < 70.0) {
                    System.out.println("Result: Hypoglycemia");
                } else if (mgdl <= 100.0) {
                    System.out.println("Result: Normal");
                } else if (mgdl <= 125.0) {
                    System.out.println("Result: Prediabetes");
                } else {
                    System.out.println("Result: Diabetes");
                }
            } else {
                fasting = false;
                System.out.println("Please come back after " + (8 - hoursSinceMeal) + " more hours.");
            }
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm (e.g., 09:30).");
        }
    }

    public void AssignedDoc() {
        System.out.println("Assigned doctor: Dr. Karl John Montibon");
    }

    @Override
    public double CalculateBill() {
        return 200.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Fasting Blood Sugar Result (mg/dL): " + mgdl);
    }
}
