import java.util.Scanner;

public class AntinuclearAntibody extends ClinikParent{
    protected double anaValue;
        public AntinuclearAntibody(String name, String sex, int age, double anaValue) {
            super(name, sex, age);
            this.anaValue = anaValue;
        }
        public double SIconverter(){
            return 0;
        }
        public void TestTaken(){
            Scanner input = new Scanner(System.in);
            System.out.println("Antinuclear Antibody test taken for patient " + name + " with ID " + id);
            System.out.println(" Enter in ANA titer value: ");
            anaValue = input.nextDouble();
            if (anaValue < 40) {
                System.out.println("Results: LOW (ANA not detected).");
            } else if (anaValue >= 40 && anaValue < 160) {
                System.out.println("Results: Low Positive (ANA detected at low levels, may be seen in healthy individuals or mild autoimmune conditions).");
            } else if (anaValue >= 160 && anaValue < 320) {
                System.out.println("Results: Moderate Positive (ANA detected at moderate levels, more suggestive of autoimmune disease).");
            } else {
                System.out.println("Results: High Positive (ANA detected at high levels, strongly suggestive of autoimmune disease).");
            }
        }
        public void AssignedDoc(){
            System.out.println("Assigned Doctor: Kwesel Kwem");
        }
        public double CalculateBill(){
            return 700.0;
        }
        public void displayPatientInfo(){
            super.displayPatientInfo();
            System.out.println("ANA Titer Value: " + anaValue);
        }

    }