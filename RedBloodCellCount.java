import java.util.Scanner;

public class RedBloodCellCount extends ClinikParent {
    protected double rbcCount;

    public RedBloodCellCount(String name, String sex, int age, double rbcCount) {
        super(name, sex, age);
        this.rbcCount = rbcCount;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        System.out.print("Enter Red Blood Cell Count (million cells/uL): ");
        Scanner input = new Scanner(System.in);
        rbcCount = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (age < 12) {
            if (rbcCount <= 4.1) {
                System.out.println("Red Blood Cell Count is low. Possible anemia.");
            } else if (rbcCount > 5.5) {
                System.out.println("Red Blood Cell Count is high. Possible polycythemia.");
            } else {
                System.out.println("Red Blood Cell Count is within the normal range.");
            }
        } else {
            if (rbcCount <= 4.5) {
                System.out.println("Red Blood Cell Count is low. Possible anemia.");
            } else if (rbcCount > 6.0) {
                System.out.println("Red Blood Cell Count is high. Possible polycythemia.");
            } else {
                System.out.println("Red Blood Cell Count is within the normal range.");
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
        System.out.println("Red Blood Cell Count: " + rbcCount + " million cells/uL");
        AssignedDoc();
        InterpretResult();
    }
}
