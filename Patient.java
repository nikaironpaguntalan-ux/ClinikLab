import java.util.ArrayList;
import java.util.List;

public class Patient {

  
    private static int counter = 1;

  
    public final int id;
    public String name;
    public String sex;
    public int age;
    public String address;
    public String dateOfCollection;
    public String timeOfCollection;
    public String birthdate;

   
    public List<ClinikParent> tests;

   
    public Patient(String name, String sex, int age, String address,
                   String dateOfCollection, String timeOfCollection, String birthdate) {

        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.dateOfCollection = dateOfCollection;
        this.timeOfCollection = timeOfCollection;
        this.birthdate = birthdate;

        this.id = counter++;
        this.tests = new ArrayList<>();
    }

    
    public void addTest(ClinikParent test) {
        if (test != null) {
            tests.add(test);
        }
    }

   
    public void displayPatientInfo() {
        System.out.println("Patient ID: " + String.format("%04d", id));
        System.out.println("Name: " + name);
        System.out.println("Sex: " + sex);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Date of Collection: " + dateOfCollection);
        System.out.println("Time of Collection: " + timeOfCollection);
        System.out.println("Birthdate: " + birthdate);
    }

    
    public void generateReport() {
        System.out.println("--------------------------------------");
        System.out.println("        CLINIK LABORATORY REPORT       ");
        System.out.println("--------------------------------------");
        System.out.println();

        displayPatientInfo();

        if (tests.isEmpty()) {
            System.out.println("No laboratory tests recorded.");
            System.out.println("Total Bill: ₱0.00");
            return;
        }

        double totalBill = 0.0;

        for (ClinikParent test : tests) {
            if (test == null) continue;

            System.out.println("Test: " + test.getClass().getSimpleName());
            test.displayPatientInfo();

            double bill = test.CalculateBill();
            System.out.printf("Bill: P%.2f%n", bill);
            totalBill += bill;
        }

        System.out.printf("Total Bill: P%.2f%n", totalBill);
    }
}