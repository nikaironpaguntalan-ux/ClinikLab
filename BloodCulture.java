import java.util.Scanner;

public class BloodCulture extends ClinikParent{
    protected String growth;
    public BloodCulture(String name, String sex, int age, String growth ){
        super(name, sex,age);
        this.growth= growth;
    }
    @Override
    public double SIconverter(){
        return 0.0;
    }
    @Override
    public void TestTaken(){
        Scanner input= new Scanner (System.in);
        System.out.println(" Blood Culture Test ");
        System.out.print("Is there Microbial Growth? [Yes or No]");
        growth=input.nextLine();
        InterpretResult();
    }
    @Override
        public void InterpretResult(){
        if(growth.equalsIgnoreCase("Yes")){
            System.out.println("Results is: High");
        }else{
            System.out.println("Result is: Normal ");
        }


    }
    @Override
    public void AssignedDoc(){
         System.out.println("Assigned Doctor: Riaben Fernanda");
    }
    @Override
    public double CalculateBill(){
        return 300;
    }
    @Override
    public void displayPatientInfo(){
        super.displayPatientInfo();
        System.out.print("Is there a Microbial Growth? " + growth);
        AssignedDoc();
        InterpretResult();
    }
    
}