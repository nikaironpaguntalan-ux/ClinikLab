import java.util.ArrayList;
import java.util.List;

public class Patient {
    private static int counter = 0001;  
    protected String name;
    protected String sex;
    protected int age;
    protected int id;
    protected String Address;
    protected String DateofCollection;
    protected String TimeofCollection;
    protected String Birthdate;

    protected List<ClinikParent> tests;

    public Patient(String name, String sex, int age, String Address, String DateofCollection, String TimeofCollection, String Birthdate) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.Address = Address;
        this.DateofCollection = DateofCollection;
        this.TimeofCollection = TimeofCollection;
        this.Birthdate = Birthdate;
        this.id = counter++;          
        this.tests = new ArrayList<>(); 
    }

    public void addTest(ClinikParent test) {
        tests.add(test); 
    }

    public void displayPatientInfo() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Sex: " + sex);
        System.out.println("Age: " + age);
        System.out.println("Address: " + Address);
        System.out.println("Date of Collection: " + DateofCollection);
        System.out.println("Time of Collection: " + TimeofCollection);
        System.out.println("Birthdate: " + Birthdate);
    }

    public void viewResults() {
        System.out.println("--- Results for " + name + " ---");
        for (ClinikParent test : tests) {
            test.TestTaken(); 
        }
    }

    public void generateReport() {
        System.out.println("------ Clinic Report ------");
        displayPatientInfo();
        double totalBill = 0.0;
        for (ClinikParent test : tests) {
            test.displayPatientInfo();
            double bill = test.CalculateBill();
            System.out.println("Bill: ₱" + bill);
            totalBill += bill;
        }
        System.out.println("Total Bill: ₱" + totalBill);
    }
}
