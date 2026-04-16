import java.util.Scanner;

public class Creatinine extends ChemistryTest{
    public Creatinine(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 88.4;
    }
    @Override
    public void TestTaken() {
       
           Scanner input = new Scanner(System.in);
        System.out.println(" Creatinine test taken");
        System.out.print("Enter your Creatinine in mg/dL: ");
        mgdl = input.nextDouble();
         SIconverter();
        System.out.println("Your Creatinine in SI units: " + SIconverter() + " mmol/L");
        InterpretResult();
    }
         @Override
    public void InterpretResult(){
        if (sex.equalsIgnoreCase("male")) {
            if (mgdl <= 0.8) {
                System.out.println("Result: Low Creatinine (Low Muscle Mass or Kidney Disease)");
            } else if (mgdl >= 0.9 && mgdl <= 1.3) {
                System.out.println("Result: Normal Creatinine");
            } else {
                System.out.println("Result: High Creatinine (Kidney Dysfunction)");
            }
        } else if (sex.equalsIgnoreCase("female")) {
            if (mgdl <= 0.59 ) {
                System.out.println("Result: Low Creatinine (Low Muscle Mass or Kidney Disease)");
            } else if (mgdl >= 0.60 && mgdl <= 1.2) {
                System.out.println("Result: Normal Creatinine");
            } else {
                System.out.println("Result: High Creatinine (Kidney Dysfunction)");
            }
        } else {
            System.out.println("Invalid sex entered. Please enter 'male' or 'female'.");
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
        System.out.println("Creatinine result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }




} 