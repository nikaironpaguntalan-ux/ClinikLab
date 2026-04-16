import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ClinikLaboratorySystem {
    private static HashMap<Integer, Set<String>> restrictedTestsTaken = new HashMap<>();
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        
         
   

        boolean running = true; 

        while (running) {
            System.out.println("---------------------------------");
            System.out.println("     CLINIK LABORATORY SYSTEM    ");
            System.out.println("---------------------------------");
            System.out.println("");
            System.out.println("[1] Patient Registration");
            System.out.println("[2] Tests");
            System.out.println("[3] Generate Report");
            System.out.println("[4] View All Patient Records");
            System.out.println("[5]Pay Bills");
            System.out.println("[6] Exit");
            System.out.print("Enter your Choice: ");
            int MenuChoice = input.nextInt();
            input.nextLine();
            

            if (MenuChoice == 1) {
                boolean addMore = true;
                while (addMore) {
                    System.out.print("Enter Patients Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Patients Sex: ");
                    String sex = input.nextLine();
                    System.out.print("Enter Patients Age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Patients Address: ");
                    String Address = input.nextLine();
                    System.out.print("Enter Date of Collection: ");
                    String DateofCollection = input.nextLine();
                    System.out.print("Enter Time of Collection: ");
                    String TimeofCollection = input.nextLine();
                    System.out.print("Enter Birthdate: ");
                    String Birthdate = input.nextLine();

                    Patient newPatient = new Patient(name, sex, age, Address, DateofCollection, TimeofCollection, Birthdate);
                    patients.add(newPatient);
                    System.out.println("Patient Registered Successfully!");
                   restrictedTestsTaken.put(newPatient.id, new HashSet<>());

                    System.out.print("Do you want to add another patient? (Y/N): ");
                    String choice = input.nextLine();
                    if (!choice.equalsIgnoreCase("Y")) {
                        addMore = false; 
                    }
                }

            } else if (MenuChoice == 2) {
                if (patients.isEmpty()) {
                    System.out.println("No patients registered. Please register a patient first.");
                } else {
                    
                    System.out.println("");
                     System.out.println("---------------------------------");
                    System.out.println("        Available Patients:");
                    System.out.println("---------------------------------");

                    for (Patient patient : patients) {
                        System.out.println("ID: " + patient.id + " - Name: " + patient.name);
                    }
                    System.out.print("Select a patient by ID: ");
                    int patientId = input.nextInt();
                    input.nextLine();
                    Patient selectedPatient = null;
                    for (Patient patient : patients) {
                        if (patient.id == patientId) {
                            selectedPatient = patient;
                            break;
                        }
                    }
                    if (selectedPatient != null) {

                        System.out.println("---------------------------------");
                        System.out.println("     TEST SELECTION FOR " + selectedPatient.name.toUpperCase() + "    ");
                        System.out.println("Patient ID: " + selectedPatient.id);
                        System.out.println("---------------------------------");

                        boolean mtLoop= true;
                        while (mtLoop){

                        System.out.println("Available Tests: ");
                        System.out.println("[1] Chemistry Tests");
                        System.out.println("[2] Hematology Tests");
                        System.out.println("[3] Immunology Tests");
                        System.out.println("[4] Microbiology Tests");
                        System.out.println("[5] Exit");
                        System.out.print("Enter your choice: ");
                        int testCategoryChoice = input.nextInt();
                        input.nextLine();
                        if (testCategoryChoice == 1) {
                            boolean chemloop=true;
                            while (chemloop){

                        System.out.println("---------------------------------");
                        System.out.println("        Chemistry Tests.");
                        System.out.println("----------------------------------");
                        System.out.println("[1] FBS");
                        System.out.println("[2] RBS");
                        System.out.println("[3] TOTAL CHOLESTEROL");
                        System.out.println("[4] HDL");
                        System.out.println("[5] LDL");
                        System.out.println("[6] Triglycerides");
                        System.out.println("[7] Creatinine");
                        System.out.println("[8] Uric Acid");
                        System.out.println("[9] BUN");
                        System.out.println("[10] AST/SGOT");
                        System.out.println("[11] ALT/SGPT");
                        System.out.println("[12] Sodium");
                        System.out.println("[13] Potassium");
                        System.out.println("[14] Chloride");
                        System.out.println("[15] Total Calcium");
                        System.out.println("[16] Ionized Calcium");
                        System.out.println("[17] Exit");
                        System.out.print("Enter the number of the test to add: ");
                        int testChoice = input.nextInt();
                        input.nextLine();

                        if (testChoice == 1) {
                            FBS fbsTest = new FBS(selectedPatient.name, selectedPatient.sex, selectedPatient.age);  
                          
                            
                            String testName = fbsTest.getClass().getSimpleName();

                            if (isRestrictedTest(testName)
                                    && restrictedTestsTaken.get(selectedPatient.id).contains("RESTRICTED")) {

                                System.out.println("This test cannot be taken on the same day.");
                            } else {
                                selectedPatient.addTest(fbsTest);
                                fbsTest.TestTaken();

                                restrictedTestsTaken.get(selectedPatient.id).add("RESTRICTED");
                            }

                        } else if (testChoice == 2) {
                            RBS rbsTest = new RBS(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                           
                            String testName = rbsTest.getClass().getSimpleName();

                            if (isRestrictedTest(testName)
                                    && restrictedTestsTaken.get(selectedPatient.id).contains("RESTRICTED")) {

                                System.out.println("This test cannot be taken on the same day.");
                            } else {
                                selectedPatient.addTest(rbsTest);
                                rbsTest.TestTaken();

                                restrictedTestsTaken.get(selectedPatient.id).add("RESTRICTED");
                            }

                        } else if (testChoice == 3) {
                            TotalCholesterol tcTest = new TotalCholesterol(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            
                            tcTest.TestTaken();
                             String testName = tcTest.getClass().getSimpleName();

                            if (isRestrictedTest(testName)
                                    && restrictedTestsTaken.get(selectedPatient.id).contains("RESTRICTED")) {

                                System.out.println("This test cannot be taken on the same day.");
                            } else {
                                selectedPatient.addTest(tcTest);
                                tcTest.TestTaken();

                                restrictedTestsTaken.get(selectedPatient.id).add("RESTRICTED");
                            }

                        } else if (testChoice == 4) {
                            HDL hdlTest = new HDL(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                           
                            hdlTest.TestTaken();
                             String testName = hdlTest.getClass().getSimpleName();

                            if (isRestrictedTest(testName)
                                    && restrictedTestsTaken.get(selectedPatient.id).contains("RESTRICTED")) {

                                System.out.println("This test cannot be taken on the same day.");
                            } else {
                                selectedPatient.addTest(hdlTest);
                                hdlTest.TestTaken();

                                restrictedTestsTaken.get(selectedPatient.id).add("RESTRICTED");
                            }

                        } else if (testChoice == 5) {
                            LDL ldlTest = new LDL(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                           
                            ldlTest.TestTaken();
                             String testName = ldlTest.getClass().getSimpleName();

                            if (isRestrictedTest(testName)
                                    && restrictedTestsTaken.get(selectedPatient.id).contains("RESTRICTED")) {

                                System.out.println("This test cannot be taken on the same day.");
                            } else {
                                selectedPatient.addTest(ldlTest);
                                ldlTest.TestTaken();

                                restrictedTestsTaken.get(selectedPatient.id).add("RESTRICTED");
                            }

                        } else if (testChoice == 6) {
                            Triglycerides tgTest = new Triglycerides(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                           
                            tgTest.TestTaken();
                             String testName = tgTest.getClass().getSimpleName();

                            if (isRestrictedTest(testName)
                                    && restrictedTestsTaken.get(selectedPatient.id).contains("RESTRICTED")) {

                                System.out.println("This test cannot be taken on the same day.");
                            } else {
                                selectedPatient.addTest(tgTest);
                                tgTest.TestTaken();

                                restrictedTestsTaken.get(selectedPatient.id).add("RESTRICTED");
                            }

                        } else if (testChoice == 7) {
                            Creatinine creatinineTest = new Creatinine(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(creatinineTest);
                            creatinineTest.TestTaken();
                        } else if (testChoice == 8) {
                            UricAcid uricAcidTest = new UricAcid(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(uricAcidTest);
                            uricAcidTest.TestTaken();
                        } else if (testChoice == 9) {
                            BUN bunTest = new BUN(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(bunTest);
                            bunTest.TestTaken();
                        } else if (testChoice == 10) {
                            AST_SGOT astSgotTest = new AST_SGOT(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(astSgotTest);
                            astSgotTest.TestTaken();
                        } else if (testChoice == 11) {
                            ALT_SGPT altSgptTest = new ALT_SGPT(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(altSgptTest);
                            altSgptTest.TestTaken();
                        } else if (testChoice == 12) {
                            Sodium sodiumTest = new Sodium(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(sodiumTest);
                            sodiumTest.TestTaken();
                        } else if (testChoice == 13) {
                            Potassium potassiumTest = new Potassium(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(potassiumTest);
                            potassiumTest.TestTaken();
                        } else if (testChoice == 14) {
                            Chloride chlorideTest = new Chloride(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(chlorideTest);
                            chlorideTest.TestTaken();
                        } else if (testChoice == 15) {
                            TCalcium tCalciumTest = new TCalcium(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(tCalciumTest);
                            tCalciumTest.TestTaken();
                        } else if (testChoice == 16) {
                            iCalcium iCalciumTest = new iCalcium(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(iCalciumTest);
                            iCalciumTest.TestTaken();
                        } else if (testChoice == 17) {
                            System.out.println("Exiting test selection.");
                            chemloop=false;
                        
                        } else {
                            System.out.println("Invalid test choice. Please try again.");
                        }
                    }
                    } else if (testCategoryChoice == 2) {
                        boolean Hloop = true;
                        while(Hloop){
                        System.out.println("---------------------------------");
                        System.out.println("        Hematology Tests.");
                        System.out.println("----------------------------------");
                        System.out.println("[1] Hemoglobin");
                        System.out.println("[2] Hematocrit");
                        System.out.println("[3] White Blood Cell Count");
                        System.out.println("[4] Platelet Count");
                        System.out.println("[5] Red Blood Cell Count");
                        System.out.println("[6] Exit");
                        System.out.print("Enter the number of the test to add: ");
                        int hematologyTestChoice= input.nextInt();
                        input.nextLine();
                        if (hematologyTestChoice ==1 ){
                            Hemoglobin hemoglobintest= new Hemoglobin(selectedPatient.name, selectedPatient.sex, selectedPatient.age,0.0);
                            selectedPatient.addTest(hemoglobintest);
                            hemoglobintest.TestTaken();

                        }else if( hematologyTestChoice== 2){
                               Hematocrit hematocrittest= new Hematocrit(selectedPatient.name, selectedPatient.sex, selectedPatient.age,0.0);
                            selectedPatient.addTest(hematocrittest);
                            hematocrittest.TestTaken();
                        }else if( hematologyTestChoice== 3){
                            WhiteBloodCellCount wbcTest= new WhiteBloodCellCount(selectedPatient.name, selectedPatient.sex, selectedPatient.age,0.0);
                            selectedPatient.addTest(wbcTest);
                            wbcTest.TestTaken();
                        }else if ( hematologyTestChoice== 4){
                        PlateletCount pcTest= new PlateletCount(selectedPatient.name, selectedPatient.sex, selectedPatient.age,0.0);
                            selectedPatient.addTest(pcTest);
                            pcTest.TestTaken();
                        } else if (hematologyTestChoice ==5 ){
                            RedBloodCellCount rbcTest = new RedBloodCellCount(selectedPatient.name, selectedPatient.sex, selectedPatient.age,0.0);
                            selectedPatient.addTest(rbcTest);
                            rbcTest.TestTaken();
                        }else if (hematologyTestChoice==6 ){
                            System.out.println("Exit");
                            Hloop= false;
                        }else{
                            System.out.println("Invalid Choice");
                        }
                    }

                    } else if (testCategoryChoice == 3) {
                        boolean imloop=true;
                        while (imloop){
                        System.out.println("---------------------------------");
                        System.out.println("        Immunology Tests.");
                        System.out.println("----------------------------------");
                        System.out.println("[1] Antinuclear Antibody");
                        System.out.println("[2] C-Reactive Protein");
                        System.out.println("[3] Rheumatoid Factor");
                        System.out.println("[4] Immunoglobin E");
                        System.out.println("[5] Immunoglobin G");
                        System.out.println("[6] Exit");
                        System.out.print("Enter the number of the test to add: ");
                        int immunologyTestChoice = input.nextInt();
                        input.nextLine();
                        if (immunologyTestChoice == 1) {
                            AntinuclearAntibody anaTest = new AntinuclearAntibody(selectedPatient.name, selectedPatient.sex, selectedPatient.age, 0.0);
                            selectedPatient.addTest(anaTest);
                            anaTest.TestTaken();
                        } else if (immunologyTestChoice == 2) {
                            CReactiveProtein crpTest = new CReactiveProtein(selectedPatient.name, selectedPatient.sex, selectedPatient.age, 0.0);
                            selectedPatient.addTest(crpTest);
                            crpTest.TestTaken();
                        } else if (immunologyTestChoice == 3) {
                            RheumatoidFactor rfTest = new RheumatoidFactor(selectedPatient.name, selectedPatient.sex, selectedPatient.age, 0.0);
                            selectedPatient.addTest(rfTest);
                            rfTest.TestTaken();
                        } else if (immunologyTestChoice == 4) {
                            ImmunoglobinE igETest = new ImmunoglobinE(selectedPatient.name, selectedPatient.sex, selectedPatient.age, 0.0);
                            selectedPatient.addTest(igETest);
                            igETest.TestTaken();
                        } else if (immunologyTestChoice == 5) {
                            ImmunoglobinG igGTest = new ImmunoglobinG(selectedPatient.name, selectedPatient.sex, selectedPatient.age, 0.0);
                            selectedPatient.addTest(igGTest);
                            igGTest.TestTaken();
                        } else if (immunologyTestChoice == 6) {
                            System.out.println("Exiting immunology test selection.");
                            imloop=false;
                        } else {
                            System.out.println("Invalid test choice. Please try again.");
                        }
                    }

                    } else if (testCategoryChoice == 4) {
                        boolean micloop=true;
                        while(micloop){
                          System.out.println("---------------------------------");
                        System.out.println("        Microbiology Tests.");
                        System.out.println("----------------------------------");
                        System.out.println("[1] Urine Culture Test");
                        System.out.println("[2] Stool Culture Test");
                        System.out.println("[3] Blood Culture Test");
                        System.out.println("[4] Exit");
                        System.out.print("Enter your choice: ");
                        int Microchoice= input.nextInt();
                        input.nextLine();
                        if(Microchoice==1){
                          UrineCulture urineTest= new UrineCulture(selectedPatient.name, selectedPatient.sex, selectedPatient.age, 0.0);
                            selectedPatient.addTest(urineTest);
                            urineTest.TestTaken();

                        }else if(Microchoice==2){
                            StoolCulture StoolTest= new StoolCulture(selectedPatient.name, selectedPatient.sex, selectedPatient.age, "");
                            selectedPatient.addTest(StoolTest);
                            StoolTest.TestTaken();
                        }else if (Microchoice==3){
                            BloodCulture bloodTest= new BloodCulture(selectedPatient.name, selectedPatient.sex, selectedPatient.age, "");
                            selectedPatient.addTest(bloodTest);
                            bloodTest.TestTaken();
                        
                        }else if (Microchoice==4) {
                            System.out.println("Exiting");
                            micloop=false;
                        }else{
                            System.out.println("Invalid");
                        }
                    }



                        
                    } else if (testCategoryChoice == 5){
                       System.out.println("Exiting test category selection.");
                       mtLoop= false;
                        
                    }else{
                        System.out.print("Invalid");
                    }
                }

                }else {
                    System.out.println("Patient with ID " + patientId + " not found.");
                }
                }
            
            } else if (MenuChoice == 3) {
            viewAllPatients(patients);

               
            } else if (MenuChoice == 4) {
                 if (patients.isEmpty()) {
                        System.out.println("No patients registered yet.");
                    }else{
                        System.out.print("Enter Patient ID to generate report: ");
                        int patientId = input.nextInt();
                        input.nextLine();

                        Patient selectedPatient = null;
                        for (Patient p : patients) {
                            if (p.id == patientId) {
                                selectedPatient = p;
                                break;
                            }
                        }

                        if (selectedPatient != null) {
                            selectedPatient.generateReport();
                        } else {
                            System.out.println("Patient with ID " + patientId + " not found.");
                        }
                    }
             
            } else if (MenuChoice == 5) {
                   payBills(patients, input);
            }else if (MenuChoice == 6){
                System.out.println("Exiting system. Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
       
    }
    public static void viewAllPatients(List<Patient> patients) {
    System.out.println("-------------------------------------");
    System.out.println("===== All Patients and Records =====");
      System.out.println("-------------------------------------");
    for (Patient p : patients) {
        p.displayPatientInfo();
        double totalBill = 0.0;
        for (ClinikParent test : p.tests) {
            System.out.println("Test: " + test.getClass().getSimpleName());
            test.displayPatientInfo();
            double bill = test.CalculateBill();
            System.out.printf("Bill: P%.2f%n", bill);
            totalBill += bill;
        }
        System.out.printf("Total Bill for %s: P%.2f%n", p.name, totalBill);
        System.out.println("-----------------------------------");
    }
}

private static boolean isRestrictedTest(String testName) {
    return testName.equals("FBS")
        || testName.equals("RBS")
        || testName.equals("TotalCholesterol")
        || testName.equals("HDL")
        || testName.equals("LDL")
        || testName.equals("Triglycerides");
}
public static void payBills(List<Patient> patients, Scanner input) {

    if (patients.isEmpty()) {
        System.out.println("No patients registered.");
        return;
    }

    System.out.print("Enter Patient ID for billing: ");
    int patientId = input.nextInt();
    input.nextLine();

    Patient selectedPatient = null;
    for (Patient p : patients) {
        if (p.id == patientId) {
            selectedPatient = p;
            break;
        }
    }

    if (selectedPatient == null) {
        System.out.println("Patient not found.");
        return;
    }

    
    double subtotal = 0.0;
    for (ClinikParent test : selectedPatient.tests) {
        subtotal += test.CalculateBill();
    }

    
    System.out.print("Does the patient have Senior Citizen / PWD ID? (Y/N): ");
    String hasDiscount = input.nextLine();

    double discount = 0.0;
    if (hasDiscount.equalsIgnoreCase("Y")) {
        discount = subtotal * 0.20;
    }

    double discountedAmount = subtotal - discount;

    
    double vat = discountedAmount * 0.12;
    double totalPayable = discountedAmount + vat;

    
    System.out.println("================================================");
    System.out.println("           CLINIK LABORATORY SYSTEM");
    System.out.println("                OFFICIAL BILLING");
    System.out.println("================================================");
    System.out.println("Billing Date : " + java.time.LocalDate.now());
    System.out.println("------------------------------------------------");

    
    System.out.println("PATIENT INFORMATION");
    System.out.println("------------------------------------------------");
    selectedPatient.displayPatientInfo();
    System.out.println("------------------------------------------------");

    
    System.out.println("LABORATORY TESTS PERFORMED");
    System.out.println("------------------------------------------------");
    for (ClinikParent test : selectedPatient.tests) {
        System.out.printf("Test: %-25s P%.2f%n",
                test.getClass().getSimpleName(),
                test.CalculateBill());
        test.AssignedDoc();  
        System.out.println();
    }

    
    System.out.println("------------------------------------------------");
    System.out.printf("Subtotal           : P%.2f%n", subtotal);
    System.out.printf("Senior/PWD Discount: -P%.2f%n", discount);
    System.out.printf("VAT (12%%)          : P%.2f%n", vat);
    System.out.println("------------------------------------------------");
    System.out.printf("TOTAL AMOUNT DUE   : P%.2f%n", totalPayable);
    System.out.println("================================================");
    System.out.println("Thank you for trusting Clinik Laboratory System");
    System.out.println("================================================\n");
}


    
}
