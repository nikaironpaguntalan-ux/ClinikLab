import java.util.Scanner;

public class ImmunoglobinE extends ClinikParent {
    protected double igEvalue;

    public ImmunoglobinE(String name, String sex, int age, double igEvalue) {
        super(name, sex, age);
        this.igEvalue = igEvalue;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Immunoglobin E test taken for patient " + name + " with ID " + id);
        System.out.print("Enter Immunoglobin E value (IU/ml): ");
        igEvalue = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (igEvalue >= 0 && igEvalue < 100) {
            System.out.println("Results: Normal");
        } else {
            System.out.println("Results: High (Possible allergic reaction, parasitic infection, or certain immune disorders).");
        }
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Kwesel Kwem");
    }

    @Override
    public double CalculateBill() {
        return 500.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Immunoglobin E Value: " + igEvalue + " IU/ml");
        AssignedDoc();
        InterpretResult();
    }
}
