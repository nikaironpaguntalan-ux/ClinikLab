public abstract class ChemistryTest extends ClinikParent {

    protected double mgdl;
    protected String testName = "Chemistry Test";

    public ChemistryTest(String name, String sex, int age, double mgdl) {
        super(name, sex, age);
        this.mgdl = mgdl;
    }

    @Override
    public void TestTaken() {
        System.out.println("Test Taken: " + testName);
    }

    @Override
    public void AssignedDoc() {
        System.out.println("Assigned Doctor: Dr. Smith");
    }

    public void displayPatientInfo() {
        super.displayPatientInfo();
        System.out.println("Chemistry Test Result (mg/dL): " + mgdl);
    }

    public abstract double SIconverter();
    public abstract double CalculateBill();
}