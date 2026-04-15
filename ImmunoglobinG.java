import java.util.Scanner;

public class ImmunoglobinG extends ClinikParent{
    protected double igGvalue;
        public ImmunoglobinG(String name, String sex, int age, double igGvalue) {
            super(name, sex, age);
            this.igGvalue = igGvalue;
        }
        public double SIconverter(){
            return 0;
        }
        public void TestTaken(){
            Scanner input = new Scanner(System.in);
            System.out.println("Immunoglobin G test taken for patient " + name + " with ID " + id);
            System.out.println(" Enter in g/L Immunoglobin G value: ");
            igGvalue = input.nextDouble();
            if (igGvalue < 7) {
                System.out.println("Results: Low (Possible weak immune response or immunodeficiency).");
            } else if (igGvalue >=7 && igGvalue < 16) {
                System.out.println("Results: Normal.");
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
            System.out.println("Immunoglobin E Value: " + igGvalue + " g/L");
        }


}