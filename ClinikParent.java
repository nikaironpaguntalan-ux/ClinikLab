public abstract class ClinikParent{

    protected  String name;
    protected  String sex;
    protected  int age;
    public ClinikParent(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;


}

        public abstract double SIconverter();

        public abstract void TestTaken();

        public abstract void InterpretResult();

        public abstract void AssignedDoc();

        public abstract double CalculateBill();

    

    public void displayPatientInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Sex: " + sex);
        System.out.println("Patient Age: " + age);
    }
}
