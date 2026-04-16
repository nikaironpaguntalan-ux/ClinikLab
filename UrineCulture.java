import java.util.Scanner;

public class UrineCulture extends ClinikParent {
    protected double CFU;

    public UrineCulture(String name, String sex, int age, double CFU) {
        super(name, sex, age);
        this.CFU = CFU;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("URINE CULTURE TEST");
        System.out.print("Enter CFU/ml: ");
        CFU = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (sex.equalsIgnoreCase("Female")) {
            if (CFU < 1000) {
                System.out.println("Result: Normal");
            } else if (CFU < 100000) {
                System.out.println("Result: Low");
            } else {
                System.out.println("Result: High");
            }
        } else if (sex.equalsIgnoreCase("Male")) {
            if (CFU < 100000) {
                System.out.println("Result: Normal");
            } else {
                System.out.println("Result: High");
            }
        } else {
            System.out.println("Invalid sex entered. Please enter 'Male' or 'Female'.");
        }
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Riaben Fernanda");
    }

    @Override
    public double CalculateBill() {
        return 300.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("CFU/ml: " + CFU);
        AssignedDoc();
        InterpretResult();
    }
}
