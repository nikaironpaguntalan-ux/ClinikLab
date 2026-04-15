import java.util.Scanner;
public class Hematocrit extends ClinikParent {
    protected double hematocritValue;

    public Hematocrit(String name, String sex, int age, double hematocritValue) {
        super(name, sex, age);
        this.hematocritValue = hematocritValue;
    }

    @Override
    public double SIconverter(){
        return 0.0;
    }

    @Override
    public void TestTaken() {
         System.out.print("Enter Hematocrit value (%): ");
        Scanner input = new Scanner(System.in);
        hematocritValue = input.nextDouble();
        if (age < 12){
            if (hematocritValue <=35.0) {
                System.out.println("Hematocrit level is low. Possible anemia.");
            } else if (hematocritValue > 45.0) {
                System.out.println("Hematocrit level is high. Possible polycythemia.");
            } else {
                System.out.println("Hematocrit level is normal.");
            }
        }else if (age >= 13 && age <= 17 && sex.equals("Male")){
            if (hematocritValue < 35.0) {
                System.out.println("Hematocrit level is low. Possible anemia.");
            } else if (hematocritValue > 45.0) {
                System.out.println("Hematocrit level is high. Possible polycythemia.");
            } else {
                System.out.println("Hematocrit level is normal.");
            }
        }else if (age >= 13 && age <= 17 && sex.equals("Female")){
            if (hematocritValue < 35.0) { 
                System.out.println("Hematocrit level is low. Possible anemia.");
            } else if (hematocritValue > 45.0) {
                System.out.println("Hematocrit level is high. Possible polycythemia.");
            } else {
                System.out.println("Hematocrit level is normal.");
            }
        }else if (age >= 18 && sex.equals("Male")){
            if (hematocritValue < 35.0) {
                System.out.println("Hematocrit level is low. Possible anemia.");
            } else if (hematocritValue > 45.0) {
                System.out.println("Hematocrit level is high. Possible polycythemia.");
            } else {
                System.out.println("Hematocrit level is normal.");
            }
        }else if (age >= 18 && sex.equals("Female")){
            if (hematocritValue < 35.0) {
                System.out.println("Hematocrit level is low. Possible anemia.");
            } else if (hematocritValue > 45.0) {
                System.out.println("Hematocrit level is high. Possible polycythemia.");
            } else {
                System.out.println("Hematocrit level is normal.");
            }
        }

    }
    public void AssignedDoc(){
          System.out.println("Assigned Doctor: Reynaldonna Smeretsa");

    }
    public double CalculateBill(){
        return 150.0;
    }
    public void displayPatientInfo(){
        AssignedDoc();
        super.displayPatientInfo();
        System.out.println("Hematocrit Value: " + hematocritValue + "%");

    }

}