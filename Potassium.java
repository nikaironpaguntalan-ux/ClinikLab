import java.util.Scanner;
public class Potassium extends ChemistryTest{
    public Potassium(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 1.0;
    }

    @Override
    public void TestTaken() {
        SIconverter();
        Scanner input = new Scanner(System.in);
        System.out.println("Potassium test taken");
        System.out.print("Enter your Potassium in mg/dL: ");
        mgdl = input.nextDouble();
        System.out.println("Your Potassium in SI units: " + SIconverter() + " mmol/L");
        if (mgdl <= 3.4) {
            System.out.println("Result: Hypokalemia");
        } else if (mgdl >= 3.5 && mgdl <= 5.0) {
            System.out.println("Result: Normal");
        } else {
            System.out.println("Result: Hyperkalemia");

        }
    }
    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }
    @Override
    public double CalculateBill() {
        return 250.0;
    }
    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Potassium result: " + mgdl + " mg/dL");
        AssignedDoc();
    }



} 