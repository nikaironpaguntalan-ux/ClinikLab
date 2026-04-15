import java.util.ArrayList;
import java.util.Scanner;

public class ClinikLaboratorySystem {
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
            System.out.println("[3] View Results");
            System.out.println("[4] Generate Report");
            System.out.println("[5] View Patient");
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
                    System.out.println("Available Patients:");
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
                            selectedPatient.addTest(fbsTest);
                            fbsTest.TestTaken();
                        } else if (testChoice == 2) {
                            RBS rbsTest = new RBS(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(rbsTest);
                            rbsTest.TestTaken();
                        } else if (testChoice == 3) {
                            TotalCholesterol tcTest = new TotalCholesterol(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(tcTest);
                            tcTest.TestTaken();
                        } else if (testChoice == 4) {
                            HDL hdlTest = new HDL(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(hdlTest);
                            hdlTest.TestTaken();
                        } else if (testChoice == 5) {
                            LDL ldlTest = new LDL(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(ldlTest);
                            ldlTest.TestTaken();
                        } else if (testChoice == 6) {
                            Tryglicerides tgTest = new Tryglicerides(selectedPatient.name, selectedPatient.sex, selectedPatient.age);
                            selectedPatient.addTest(tgTest);
                            tgTest.TestTaken();
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
                        } else {
                            System.out.println("Invalid test choice. Please try again.");
                        }
                    } else if (testCategoryChoice == 2) {
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
                            System.out.println("Exit");// Needs Loop
                        }else{
                            System.out.println("Invalid Choice");
                        }

                    } else if (testCategoryChoice == 3) {
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
                        } else {
                            System.out.println("Invalid test choice. Please try again.");
                        }

                    } else if (testCategoryChoice == 4) {
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
                        }else{
                            System.out.println("Invalid");
                        }
                        



                        
                    } else if (testCategoryChoice == 5) {
                        System.out.println("Exiting test category selection.");
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                        
                    }
                }else {
                    System.out.println("Patient with ID " + patientId + " not found.");
                }
                }
            } else if (MenuChoice == 3) {
               
            } else if (MenuChoice == 4) {
             
            } else if (MenuChoice == 5) {
              
            } else if (MenuChoice == 6) {
                System.out.println("Exiting system. Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
    }
}
