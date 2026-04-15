import java.util.Scanner;

public class BUN extends ChemistryTest{
    public BUN(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 0.357;
    }
    @Override
    public void TestTaken() {
        SIconverter();
           Scanner input = new Scanner(System.in);
        System.out.println("BUN test taken");
        System.out.print("Enter your BUN in mg/dL: ");
        mgdl = input.nextDouble();
        System.out.println("Your BUN in SI units: " + SIconverter() + " mmol/L");
        if (mgdl <= 5.9 ) {
            System.out.println("Result: Hypoglycemia");
        } else if (mgdl >= 6.0 && mgdl <= 20.0) {
            System.out.println("Result: Normal");
        } else {
            System.out.println("Result: Hyperglycemia");

        }
    }
    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }
    @Override
    public double CalculateBill() {
        return 180.0;
    }
    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("BUN result: " + mgdl + " mg/dL");
        AssignedDoc();
    }
    
        





} 