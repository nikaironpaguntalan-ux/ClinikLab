import java.util.Scanner;

public class WhiteBloodCellCount extends ClinikParent {
    protected double wbcCount;

    public WhiteBloodCellCount(String name, String sex, int age, double wbcCount) {
        super(name, sex, age);
        this.wbcCount = wbcCount;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        System.out.print("Enter White Blood Cell Count (U/L): ");
        Scanner input = new Scanner(System.in);
        wbcCount = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (age < 18) {
            if (wbcCount < 5.0) {
                System.out.println("White Blood Cell Count is low for children. Possible leukopenia.");
            } else if (wbcCount > 15.0) {
                System.out.println("White Blood Cell Count is high for children. Possible leukocytosis.");
            } else {
                System.out.println("White Blood Cell Count is within the normal range for children.");
            }
        } else {
            if (wbcCount < 4.0) {
                System.out.println("White Blood Cell Count is low. Possible leukopenia.");
            } else if (wbcCount > 11.0) {
                System.out.println("White Blood Cell Count is high. Possible leukocytosis.");
            } else {
                System.out.println("White Blood Cell Count is within the normal range.");
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
        System.out.println("White Blood Cell Count: " + wbcCount + " U/L");
        AssignedDoc();
        InterpretResult();
    }
}
