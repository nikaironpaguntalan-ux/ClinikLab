import java.util.Scanner;

public class Hemoglobin extends ClinikParent {
    protected double hemoglobinValue;

    public Hemoglobin(String name, String sex, int age, double hemoglobinValue) {
        super(name, sex, age);
        this.hemoglobinValue = hemoglobinValue;
    }

    @Override
    public double SIconverter() {
        return 0.0;
    }

    @Override
    public void TestTaken() {
        System.out.print("Enter Hemoglobin value (g/dL): ");
        Scanner input = new Scanner(System.in);
        hemoglobinValue = input.nextDouble();
        InterpretResult();
    }

    @Override
    public void InterpretResult() {
        if (age < 12) {
            if (hemoglobinValue <= 11.0) {
                System.out.println("Hemoglobin level is low. Possible anemia.");
            } else if (hemoglobinValue > 16.0) {
                System.out.println("Hemoglobin level is high. Possible polycythemia.");
            } else {
                System.out.println("Hemoglobin level is normal.");
            }
        } else if (age >= 13 && age <= 17 && sex.equalsIgnoreCase("Male")) {
            if (hemoglobinValue < 13.0) {
                System.out.println("Hemoglobin level is low. Possible anemia.");
            } else if (hemoglobinValue > 16.0) {
                System.out.println("Hemoglobin level is high. Possible polycythemia.");
            } else {
                System.out.println("Hemoglobin level is normal.");
            }
        } else if (age >= 13 && age <= 17 && sex.equalsIgnoreCase("Female")) {
            if (hemoglobinValue < 12.0) {
                System.out.println("Hemoglobin level is low. Possible anemia.");
            } else if (hemoglobinValue > 15.0) {
                System.out.println("Hemoglobin level is high. Possible polycythemia.");
            } else {
                System.out.println("Hemoglobin level is normal.");
            }
        } else if (age >= 18 && sex.equalsIgnoreCase("Male")) {
            if (hemoglobinValue < 13.4) {
                System.out.println("Hemoglobin level is low. Possible anemia.");
            } else if (hemoglobinValue > 17.6) {
                System.out.println("Hemoglobin level is high. Possible polycythemia.");
            } else {
                System.out.println("Hemoglobin level is normal.");
            }
        } else if (age >= 18 && sex.equalsIgnoreCase("Female")) {
            if (hemoglobinValue < 12.0) {
                System.out.println("Hemoglobin level is low. Possible anemia.");
            } else if (hemoglobinValue > 15.5) {
                System.out.println("Hemoglobin level is high. Possible polycythemia.");
            } else {
                System.out.println("Hemoglobin level is normal.");
            }
        }
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Reynaldonna Smeretsa");
    }

    @Override
    public double CalculateBill() {
        return 500.0;
    }

    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Hemoglobin Value: " + hemoglobinValue + " g/dL");
        AssignedDoc();
        InterpretResult();
    }
}
