import java.util.Scanner;

public class StoolCulture extends ClinikParent{
    protected String path;
    public StoolCulture(String name, String sex, int age, String path ){
        super(name, sex,age);
        this.path= path;
    }
    @Override
    public double SIconverter(){
        return 0.0;
    }
    public void TestTaken(){
        Scanner input= new Scanner (System.in);
        System.out.println(" Blood Culture Test ");
           System.out.print("Pathogen detected? (Yes/No): ");
        path=input.nextLine();
        if(path.equalsIgnoreCase("Yes")){
            System.out.println("Results is: High");
        }else{
            System.out.println("Result is: Normal ");
        }


    }
    public void AssignedDoc(){
         System.out.println("Assigned Doctor: Riaben Fernanda");
    }
    public double CalculateBill(){
        return 300;
    }
    public void displayPatientInfo(){
        super.displayPatientInfo();
        System.out.print("Is there a Pathogen? " + path);
    }
    
}