import java.util.Scanner;
public class CReactiveProtein extends ClinikParent{
    protected double crpValue;
        public CReactiveProtein(String  name, String sex, int age, double crpValue) {
            super(name, sex, age);
            this.crpValue = crpValue;
        }
        public double SIconverter(){
            return 0;
        }   
        public void TestTaken(){
            Scanner input = new Scanner(System.in);
            System.out.println("C-Reactive Protein test taken for patient " + name + " with ID " + id);
            System.out.println(" Enter in mg/L C-Reactive Protein value: ");
            crpValue = input.nextDouble();
            if (crpValue < 3) {
                System.out.println("Results: Normal (Low cardiovascular risk).");
            } else if (crpValue >= 3 && crpValue < 10) {
                System.out.println("Results: Elevated (Moderate cardiovascular risk, may indicate inflammation or infection).");
            } else {
                System.out.println("Results: High (High cardiovascular risk, likely indicates significant inflammation or infection).");
            }
        }
        public void AssignedDoc(){
            System.out.println("Assigned Doctor: Kwesel Kwem");
        }
        public double CalculateBill(){
            return 300.0;
        }
        public void displayPatientInfo(){
            super.displayPatientInfo();
            System.out.println("C-Reactive Protein Value: " + crpValue + " mg/L");
        }

    }