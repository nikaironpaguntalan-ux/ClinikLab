import java.util.Scanner;

public class ImmunoglobinE extends ClinikParent{
    protected double igEvalue;
        public ImmunoglobinE(String name, String sex, int age, double igEvalue) {
            super(name, sex, age);
            this.igEvalue = igEvalue;
        }
        public double SIconverter(){
            return 0;
        }
        public void TestTaken(){
            Scanner input = new Scanner(System.in);
            System.out.println("Immunoglobin E test taken for patient " + name + " with ID " + id);
            System.out.println(" Enter in IU/ml Immunoglobin E value: ");
            igEvalue = input.nextDouble();
            if (igEvalue >= 0 && igEvalue < 100) {
                System.out.println("Results: Normal");
            } else {
                System.out.println("Results: High (Possible allergic reaction, parasitic infection, or certain immune disorders).");
            }
        }
        public void AssignedDoc(){
            System.out.println("Assigned Doctor: Kwesel Kwem");
        }
        
        public double CalculateBill(){
            return 500.0;
        }
        public void displayPatientInfo(){
            super.displayPatientInfo();
            System.out.println("Immunoglobin E Value: " + igEvalue + " IU/ml");
        }


}