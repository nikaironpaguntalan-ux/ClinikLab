import java.util.Scanner;
public class RBS extends ChemistryTest{
    public RBS(String name, String sex, int age){
        super(name, sex, age, 0.0);

    }
    @Override
    public double SIconverter(){
        return mgdl * 0.055;
    }
    @Override
    public void TestTaken(){
        SIconverter();
        Scanner input = new Scanner(System.in);
        System.out.println("RBS test taken");
        System.out.print("Enter your blood glucose in mg/dL: ");
        mgdl = input.nextDouble();
        System.out.println("Your glucose in SI units: " + SIconverter() + " mmol/L");
        if (mgdl < 70 ) {
            System.out.println("Result: Hypoglycemia");
        } else if (mgdl >= 70 && mgdl <= 140) {
            System.out.println("Result: Normal");
        } else {
            System.out.println("Result: Hyperglycemia");

        }
    }

    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");

    }
    public double CalculateBill() {
        return 200.0;
    }

    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Random Blood Sugar Result (mg/dL): " + mgdl);
    }
    






} 