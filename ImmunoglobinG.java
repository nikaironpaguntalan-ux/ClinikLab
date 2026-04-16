import java.util.Scanner;

public class ImmunoglobinG extends ClinikParent {
    protected double igGvalue;

    public ImmunoglobinG(String name, String sex, int age, double igGvalue) {
        super(name, sex, age);
        this.igGvalue = igGvalue;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Immunoglobin G test taken for patient " + name + " with ID " + id);
        System.out.print("Enter Immunoglobin G value (g/L): ");
        igGvalue = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (igGvalue < 7) {
            System.out.println("Results: Low (Possible weak immune response or immunodeficiency).");
        } else if (igGvalue >= 7 && igGvalue < 16) {
            System.out.println("Results: Normal.");
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
        System.out.println("Immunoglobin G Value: " + igGvalue + " g/L");
        AssignedDoc();
        InterpretResult();
    }
}
