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
       
    }

    @Override
    public void InterpretResult(){

    }

    public void displayPatientInfo(){
        
    }

    public abstract double SIconverter();
    public abstract double CalculateBill();
}