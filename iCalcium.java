import java.util.Scanner;

public class iCalcium extends ChemistryTest {
    public iCalcium(String name, String sex, int age) {
        super(name, sex, age, 0.0);
    }

    @Override
    public double SIconverter() {    
        return mgdl * 0.25;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ionized Calcium test taken");
        System.out.print("Enter your Ionized Calcium in mg/dL: ");
        mgdl = input.nextDouble();
        System.out.println("Your Ionized Calcium in SI units: " + SIconverter() + " mmol/L");
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (mgdl <= 4.3) {
            System.out.println("Result: Hypocalcemia");
        } else if (mgdl >= 4.4 && mgdl <= 5.20) {
            System.out.println("Result: Normal Ionized Calcium");
        } else {
            System.out.println("Result: Hypercalcemia");
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
        System.out.println("Ionized Calcium result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }
}
