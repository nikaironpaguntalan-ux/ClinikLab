import java.util.Scanner;

public class PlateletCount extends ClinikParent {
    protected double plateletCount;

    public PlateletCount(String name, String sex, int age, double plateletCount) {
        super(name, sex, age);
        this.plateletCount = plateletCount;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        System.out.print("Enter Platelet Count (u/L): ");
        Scanner input = new Scanner(System.in);
        plateletCount = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (age < 12) {
            if (plateletCount < 200000) {
                System.out.println("Platelet count is low. Possible thrombocytopenia.");
            } else if (plateletCount > 450000) {
                System.out.println("Platelet count is high. Possible thrombocytosis.");
            } else {
                System.out.println("Platelet count is within the normal range.");
            }
        } else {
            if (plateletCount < 150000) {
                System.out.println("Platelet count is low. Possible thrombocytopenia.");
            } else if (plateletCount > 450000) {
                System.out.println("Platelet count is high. Possible thrombocytosis.");
            } else {
                System.out.println("Platelet count is within the normal range.");
            }
        }
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Reynaldonna Smeretsa");
    }

    @Override
    public double CalculateBill() {
        return 150.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Platelet Count: " + plateletCount + " u/L");
        AssignedDoc();
        InterpretResult();
    }
}
