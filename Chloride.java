import java.util.Scanner;
public class Chloride extends ChemistryTest{
    public Chloride(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 1.0;
    }   
    @Override
    public void TestTaken() {
       
        Scanner input = new Scanner(System.in);
        System.out.println("Chloride test taken");
        System.out.print("Enter your Chloride in mg/dL: ");
        mgdl = input.nextDouble();
          SIconverter();
        System.out.println("Your Chloride in SI units: " + SIconverter() + " mmol/L");
        InterpretResult();

    }

    @Override
    public void InterpretResult(){
        if (mgdl <= 95) {
            System.out.println("Result: Hypochloremia");
        } else if (mgdl >= 96 && mgdl <= 110) {
            System.out.println("Result: Normal");
        } else {
            System.out.println("Result: Hyperchloremia");

        }
    }
    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Karl John Montibon");
    }
    @Override
    public double CalculateBill() {
        return 170.0;
    }
    @Override
    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Chloride result: " + mgdl + " mg/dL");
        AssignedDoc();
    }
    



} 