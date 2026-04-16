import javax.swing.*;
import java.awt.*;
import java.util.*;

/*
 =====================================================
  CLINIK LABORATORY SYSTEM
SED GUI (SINGLE FILE)
 =====================================================
*/

public class ClinikLaboratorySystemGUI extends JFrame {

    private ArrayList<Patient> patients = new ArrayList<>();
    private Map<Integer, Set<String>> restrictedTestsTaken = new HashMap<>();

    private JComboBox<Patient> patientBox = new JComboBox<>();
    private JComboBox<String> categoryBox;
    private JList<String> testList;
    private DefaultListModel<String> testModel;

    private JTextArea outputArea = new JTextArea();

    public ClinikLaboratorySystemGUI() {
        setTitle("CLINIK LABORATORY SYSTEM ");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Clinik Laboratory System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(20, 70, 140));
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Patient Registration", patientPanel());
        tabs.add("Test Selection", testPanel());
        tabs.add("View All Patients", viewPatientsPanel());
        tabs.add("Medical Record / Billing", recordPanel());

        add(title, BorderLayout.NORTH);
        add(tabs, BorderLayout.CENTER);
    }

    /* ===================== PATIENT REGISTRATION ===================== */
    private JPanel patientPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        JTextField name = new JTextField();
        JTextField sex = new JTextField();
        JTextField age = new JTextField();
        JTextField address = new JTextField();
        JTextField date = new JTextField();
        JTextField time = new JTextField();
        JTextField birthdate = new JTextField();

        panel.add(new JLabel("Name:")); panel.add(name);
        panel.add(new JLabel("Sex:")); panel.add(sex);
        panel.add(new JLabel("Age:")); panel.add(age);
        panel.add(new JLabel("Address:")); panel.add(address);
        panel.add(new JLabel("Date of Collection:")); panel.add(date);
        panel.add(new JLabel("Time of Collection:")); panel.add(time);
        panel.add(new JLabel("Birthdate:")); panel.add(birthdate);

        JButton register = new JButton("Register Patient");
        register.addActionListener(e -> {
            Patient p = new Patient(
                name.getText(), sex.getText(),
                Integer.parseInt(age.getText()),
                address.getText(), date.getText(),
                time.getText(), birthdate.getText()
            );
            patients.add(p);
            patientBox.addItem(p);
            restrictedTestsTaken.put(p.id, new HashSet<>());
            JOptionPane.showMessageDialog(this, "Patient Registered Successfully");
        });

        panel.add(new JLabel());
        panel.add(register);
        return panel;
    }

    /* ===================== TEST SELECTION ===================== */
    private JPanel testPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel top = new JPanel();
        categoryBox = new JComboBox<>(new String[]{
            "Chemistry", "Hematology", "Immunology", "Microbiology"
        });

        top.add(new JLabel("Select Patient:"));
        top.add(patientBox);
        top.add(new JLabel("Test Category:"));
        top.add(categoryBox);

        testModel = new DefaultListModel<>();
        testList = new JList<>(testModel);

        categoryBox.addActionListener(e -> loadTestsByCategory());

        JButton addTest = new JButton("Run Selected Test");
        addTest.addActionListener(e -> runSelectedTest());

        panel.add(top, BorderLayout.NORTH);
        panel.add(new JScrollPane(testList), BorderLayout.CENTER);
        panel.add(addTest, BorderLayout.SOUTH);

        return panel;
    }

    private void loadTestsByCategory() {
        testModel.clear();
        String cat = (String) categoryBox.getSelectedItem();

        if (cat.equals("Chemistry")) {
            add("FBS"); add("RBS"); add("HDL"); add("LDL");
            add("Triglycerides"); add("Creatinine"); add("BUN");
            add("Sodium"); add("Potassium"); add("Chloride");
            add("TCalcium"); add("iCalcium"); add("UricAcid");
            add("AST_SGOT"); add("ALT_SGPT");
        }
        if (cat.equals("Hematology")) {
            add("Hemoglobin"); add("Hematocrit");
            add("WhiteBloodCellCount"); add("RedBloodCellCount");
            add("PlateletCount");
        }
        if (cat.equals("Immunology")) {
            add("RheumatoidFactor"); add("AntinuclearAntibody");
            add("CReactiveProtein"); add("ImmunoglobinE");
            add("ImmunoglobinG");
        }
        if (cat.equals("Microbiology")) {
            add("UrineCulture"); add("StoolCulture"); add("BloodCulture");
        }
    }

    private void add(String s) { testModel.addElement(s); }

    /* ===================== RESTRICTION + EXECUTION ===================== */
    private void runSelectedTest() {
        Patient p = (Patient) patientBox.getSelectedItem();
        if (p == null) return;

        String testName = testList.getSelectedValue();
        if (testName == null) return;

        // Restricted tests
        if (isRestricted(testName) &&
            restrictedTestsTaken.get(p.id).contains("RESTRICTED")) {
            JOptionPane.showMessageDialog(this,
                "This test cannot be taken on the same day.");
            return;
        }

        ClinikParent test = createTest(testName, p);
        if (test != null) {
            p.addTest(test);
            test.TestTaken(); // YOUR LOGIC
            if (isRestricted(testName))
                restrictedTestsTaken.get(p.id).add("RESTRICTED");
        }
    }

    private boolean isRestricted(String t) {
        return t.equals("FBS") || t.equals("RBS") ||
               t.equals("HDL") || t.equals("LDL") ||
               t.equals("Triglycerides");
    }

    /* ===================== VIEW ALL PATIENTS ===================== */
    private JPanel viewPatientsPanel() {
        JTextArea area = new JTextArea();
        area.setFont(new Font("Consolas", Font.PLAIN, 13));
        area.setEditable(false);

        JButton view = new JButton("View All Patients");
        view.addActionListener(e -> {
            area.setText("");
            for (Patient p : patients) {
                p.displayPatientInfo();
                area.append("---------------------------\n");
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(area), BorderLayout.CENTER);
        panel.add(view, BorderLayout.SOUTH);
        return panel;
    }

    /* ===================== RECORD + BILLING ===================== */
    private JPanel recordPanel() {
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setEditable(false);

        JButton generate = new JButton("Generate Medical Record");
        generate.addActionListener(e -> {
            if (patients.isEmpty()) return;
            Patient p = patients.get(patients.size() - 1);

            outputArea.setText("");
            outputArea.append("CLINIK LABORATORY SYSTEM\n");
            outputArea.append("================================\n");
            p.displayPatientInfo();
            outputArea.append("\nTESTS:\n");

            double total = 0;
            for (ClinikParent t : p.tests) {
                outputArea.append("- " + t.getClass().getSimpleName() + "\n");
                t.AssignedDoc();
                total += t.CalculateBill();
            }
            outputArea.append("\nTOTAL BILL: ₱" + total);
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        panel.add(generate, BorderLayout.SOUTH);
        return panel;
    }

    /* ===================== FACTORY ===================== */
    private ClinikParent createTest(String t, Patient p) {
        switch (t) {
            case "FBS": return new FBS(p.name,p.sex,p.age);
            case "RBS": return new RBS(p.name,p.sex,p.age);
            case "HDL": return new HDL(p.name,p.sex,p.age);
            case "LDL": return new LDL(p.name,p.sex,p.age);
            case "Triglycerides": return new Triglycerides(p.name,p.sex,p.age);
            case "Creatinine": return new Creatinine(p.name,p.sex,p.age);
            case "BUN": return new BUN(p.name,p.sex,p.age);
            case "Sodium": return new Sodium(p.name,p.sex,p.age);
            case "Potassium": return new Potassium(p.name,p.sex,p.age);
            case "Chloride": return new Chloride(p.name,p.sex,p.age);
            case "TCalcium": return new TCalcium(p.name,p.sex,p.age);
            case "iCalcium": return new iCalcium(p.name,p.sex,p.age);
            case "UricAcid": return new UricAcid(p.name,p.sex,p.age);
            case "AST_SGOT": return new AST_SGOT(p.name,p.sex,p.age);
            case "ALT_SGPT": return new ALT_SGPT(p.name,p.sex,p.age);
            case "UrineCulture": return new UrineCulture(p.name,p.sex,p.age,0.0);
            case "StoolCulture": return new StoolCulture(p.name,p.sex,p.age,"");
            case "BloodCulture": return new BloodCulture(p.name,p.sex,p.age,"");
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClinikLaboratorySystemGUI().setVisible(true);
        });
    }
}