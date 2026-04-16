import java.util.Scanner;

public class AST_SGOT extends ChemistryTest{
    public AST_SGOT(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 0.017;
    }
    @Override
    public void TestTaken() {
      
        Scanner input = new Scanner(System.in);
        System.out.println("AST/SGOT test taken");
        System.out.print("Enter your AST/SGOT in mg/dL: ");
        mgdl = input.nextDouble();
         SIconverter();
        System.out.println("Your AST/SGOT in SI units: " + SIconverter() + " µkat/L");
        InterpretResult();
    }
        public void InterpretResult(){
        if (mgdl <= 46) {
            System.out.println("Result: Normal AST/SGOT");
        } else {
            System.out.println("Result: Elevated AST/SGOT (Liver Dysfunction)");
        }
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
        System.out.println("AST/SGOT result: " + mgdl + " mg/dL");
        AssignedDoc();
        InterpretResult();
    }



} 