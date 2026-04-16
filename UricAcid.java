import java.util.Scanner;

public class UricAcid extends ChemistryTest {
    public UricAcid(String name, String sex, int age) {
        super(name, sex, age, 0.0);
    }

    @Override
    public double SIconverter() {
        return mgdl * 0.06;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Uric Acid test taken");
        System.out.print("Enter your Uric Acid in mg/dL: ");
        mgdl = input.nextDouble();  
        System.out.println("Your Uric Acid in SI units: " + SIconverter() + " mmol/L");
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (sex.equalsIgnoreCase("male")) {
            if (mgdl <= 3.4) {
                System.out.println("Result: Low Uric Acid (Low Muscle Mass or Kidney Disease)");
            } else if (mgdl >= 3.5 && mgdl <= 7.2) {
                System.out.println("Result: Normal Uric Acid");
            } else {
                System.out.println("Result: High Uric Acid (Kidney Dysfunction)");
            }
        } else if (sex.equalsIgnoreCase("female")) {
            if (mgdl <= 2.5) {
                System.out.println("Result: Low Uric Acid (Low Muscle Mass or Kidney Disease)");
            } else if (mgdl >= 2.6 && mgdl <= 6.0) {
                System.out.println("Result: Normal Uric Acid");
            } else {
                System.out.println("Result: High Uric Acid (Kidney Dysfunction)");
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
        return 220.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Uric Acid result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }
}
