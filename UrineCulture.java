import java.util.Scanner;

public class UrineCulture extends ClinikParent{
    protected double CFU;
    public UrineCulture(String name, String sex, int age, double CFU){
    super(name, sex, age);
    this.CFU=CFU;
    

    }
    @Override
    public double SIconverter(){
        return 0.0;
    }
    public void TestTaken(){
        Scanner input=new Scanner(System.in);
        System.out.println(" URINE CULTURE TEST ");
        System.out.println("");
        System.out.print("Enter CFU/ml: ");
        CFU= input.nextDouble();
        if(sex.equalsIgnoreCase("Female")){
        if (CFU < 1000){
            System.out.println("Results is: Normal");
        } else if (CFU < 100000) {
            System.out.println("Results: LOW");
        }else{
            System.out.println("Results: High");
        }    
            
        }else{
            if(sex.equalsIgnoreCase("Male")){
        if (CFU < 100000){
            System.out.println("Results is: Normal");
        }else{
            System.out.println("Results: High");
        }    

        }

        

    }
}
@Override
public void AssignedDoc(){
    System.out.println("Assigned Doctor: Riaben Fernanda");
}
public double CalculateBill(){
    return 300;
}
public void displayPatientInfo(){
    super.displayPatientInfo();
    System.out.println("CFU/ml "+ CFU);
}
}