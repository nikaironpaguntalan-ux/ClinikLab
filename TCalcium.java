import java.util.Scanner;
public class TCalcium extends ChemistryTest{
    public TCalcium(String name, String sex, int age){
        super(name, sex, age, 0.0);
        
    }
    @Override
    public double SIconverter(){
        return mgdl * 0.25;
    }
    @Override
    public void TestTaken() {
        SIconverter();
        Scanner input = new Scanner(System.in);
        System.out.println("Total Calcium test taken");
        System.out.print("Enter your Total Calcium in mg/dL: ");
        mgdl = input.nextDouble();
        System.out.println("Your Total Calcium in SI units: " + SIconverter() + " mmol/L");
        if (mgdl <= 8.5) {
            System.out.println("Result: Hypocalcemia");
        } else if (mgdl >= 8.6 && mgdl <= 10.28) {
            System.out.println("Result: Normal Total Calcium");
        } else {
            System.out.println("Result: Hypercalcemia");

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
        System.out.println("Total Calcium result: " + mgdl + " mg/dL");
        AssignedDoc();
    }
    
    




} 