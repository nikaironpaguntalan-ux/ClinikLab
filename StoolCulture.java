import java.util.Scanner;

public class StoolCulture extends ClinikParent {
    protected String path;

    public StoolCulture(String name, String sex, int age, String path) {
        super(name, sex, age);
        this.path = path;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("Stool Culture Test");
        System.out.print("Pathogen detected? (Yes/No): ");
        path = input.nextLine();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (path.equalsIgnoreCase("Yes")) {
            System.out.println("Result: High (Pathogen detected)");
        } else {
            System.out.println("Result: Normal (No pathogen detected)");
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
        System.out.println("Is there a Pathogen? " + path);
        AssignedDoc();
        InterpretResult();
    }
}
