import java.util.Scanner;

public class RheumatoidFactor extends ClinikParent {
    protected double rfValue;

    public RheumatoidFactor(String name, String sex, int age, double rfValue) {
        super(name, sex, age);
        this.rfValue = rfValue;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Rheumatoid Factor test taken for patient " + name + " with ID " + id);
        System.out.print("Enter Rheumatoid Factor value: ");
        rfValue = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (rfValue < 14) {
            System.out.println("Results: LOW (Rheumatoid Factor not detected).");
        } else if (rfValue >= 14 && rfValue < 20) {
            System.out.println("Results: BORDERLINE (Rheumatoid Factor detected at low levels, may be seen in healthy individuals or mild autoimmune conditions).");
        } else if (rfValue >= 20 && rfValue < 60) {
            System.out.println("Results: MODERATE POSITIVE (Rheumatoid Factor detected at moderate levels, more suggestive of rheumatoid arthritis or other autoimmune diseases).");
        } else {
            System.out.println("Results: HIGH POSITIVE (Rheumatoid Factor detected at high levels, strongly suggestive of rheumatoid arthritis or other autoimmune diseases).");
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
        System.out.println("Rheumatoid Factor Value: " + rfValue);
        AssignedDoc();
        InterpretResult();
    }
}
