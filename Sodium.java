import java.util.Scanner;

public class Sodium extends ChemistryTest {
    public Sodium(String name, String sex, int age) {
        super(name, sex, age, 0.0);
    }

    @Override
    public double SIconverter() {
        return mgdl * 1.0;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sodium test taken");
        System.out.print("Enter your Sodium in mg/dL: ");
        mgdl = input.nextDouble();
        System.out.println("Your Sodium in SI units: " + SIconverter() + " mmol/L");
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (mgdl <= 134) {
            System.out.println("Result: Hyponatremia");
        } else if (mgdl >= 135 && mgdl <= 145) {
            System.out.println("Result: Normal");
        } else {
            System.out.println("Result: Hypernatremia");
        }
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }

    @Override
    public double CalculateBill() {
        return 150.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Sodium result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }
}
