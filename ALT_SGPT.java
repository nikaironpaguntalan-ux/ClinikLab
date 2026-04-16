import java.util.Scanner;

public class ALT_SGPT extends ChemistryTest{
    public ALT_SGPT(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 0.017;
    }
@Override
    
    public void TestTaken() {
        Scanner input = new Scanner(System.in);
        System.out.println("ALT/SGPT test taken");
        System.out.print("Enter your ALT/SGPT in mg/dL: ");
        mgdl = input.nextDouble();
         SIconverter();
        System.out.println("Your ALT/SGPT in SI units: " + SIconverter() + " µkat/L");
        InterpretResult();
    
    }
          public void  InterpretResult(){
        if (mgdl <= 49) {
            System.out.println("Result: Normal ALT/SGPT");
        } else {
            System.out.println("Result: Elevated ALT/SGPT (Liver Dysfunction)");}

        }
    
    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }
    @Override
    public double CalculateBill() {
        return 200.0;
    }
    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("ALT/SGPT result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }



} 