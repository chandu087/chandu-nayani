import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EyePrescription {
    private int prescriptionID;  // Unique ID for the prescription
    private String patientFirstName;  // Patient's first name
    private String patientLastName;   // Patient's last name
    private String patientAddress;    // Patient's address (must be at least 20 characters)
    private float sphericalValue;     // Spherical correction value (-20.00 to +20.00)
    private float axisValue;          // Axis value (0 to 180)
    private float cylinderValue;      // Cylindrical correction value (-4.00 to +4.00)
    private Date testDate;            // Date of the eye examination
    private String optometristName;   // Optometrist name (8-25 characters)
    private final String[] validRemarkTypes = {"Client", "Optometrist"};  // Predefined remark types
    private ArrayList<String> remarksList = new ArrayList<>();  // List to store remarks

    // Method to add a prescription and save to a file
    public boolean addPrescription() {
        int validationCount = 0;  // Initialize validation counter

        // Condition 1: Validate First Name and Last Name length (must be between 4 and 15 characters)
        if (patientFirstName.length() >= 4 && patientFirstName.length() <= 15 && patientLastName.length() >= 4 && patientLastName.length() <= 15) {
            validationCount++;  // Increment counter if valid
        }

        // Condition 2: Validate Address length (must be at least 20 characters)
        if (patientAddress.length() >= 20) {
            validationCount++;  // Increment counter if valid
        }

        // Condition 3: Validate spherical, cylindrical, and axis values
        if (sphericalValue >= -20.00 && sphericalValue <= 20.00 && cylinderValue >= -4.00 && cylinderValue <= 4.00 && axisValue >= 0 && axisValue <= 180) {
            validationCount++;  // Increment counter if valid
        }

        // Condition 4: Validate optometrist name length (must be between 8 and 25 characters)
        if (optometristName.length() >= 8 && optometristName.length() <= 25) {
            validationCount++;  // Increment counter if valid
        }

        // Final check: If all 4 conditions are met, write to the file
        if (validationCount == 4) {
            try (FileWriter writer = new FileWriter("D:\\Workspace\\Output files\\Prescription.txt", true)) {
                writer.write("Prescription No: " + prescriptionID + "\n");
                writer.write("First Name: " + patientFirstName + "\n");
                writer.write("Last Name: " + patientLastName + "\n");
                writer.write("Address: " + patientAddress + "\n");
                writer.write("Sphere Value: " + sphericalValue + "\n");
                writer.write("Cylinder Value: " + cylinderValue + "\n");
                writer.write("Axis Value: " + axisValue + "\n");
                writer.write("Examination Date: " + new SimpleDateFormat("dd/MM/yy").format(testDate) + "\n");
                writer.write("Optometrist Name: " + optometristName + "\n");
                writer.write("=================================\n");
                return true;  // Return true if successfully written to the file
            } catch (IOException e) {
                e.printStackTrace();  // Print exception if file writing fails
                return false;
            }
        } else {
            return false;  // Return false if any condition fails
        }
    }

    // Method to add a remark and save to a file
    public boolean addRemarks(String remark, String remarkType) {
        int validationCount = 0;  // Initialize validation counter

        // Condition 1: Validate the remark (6 to 20 words, starting with an uppercase letter)
        String[] words = remark.split(" ");
        if (words.length >= 6 && words.length <= 20 && Character.isUpperCase(words[0].charAt(0))) {
            validationCount++;  // Increment counter if valid
        }

        // Condition 2: Validate the remark type (either "Client" or "Optometrist")
        if (remarkType.equalsIgnoreCase("Client") || remarkType.equalsIgnoreCase("Optometrist")) {
            validationCount++;  // Increment counter if valid
        }

        // Condition 3: Ensure no more than 2 remarks
        if (remarksList.size() < 2) {
            validationCount++;  // Increment counter if valid
        }

        // Final check: If all 3 conditions are met, add the remark and write to the file
        if (validationCount == 3) {
            remarksList.add(remarkType + ": " + remark);

            try (FileWriter writer = new FileWriter("D:\\Workspace\\Output files\\Remark.txt", true)) {
                writer.write("Remark Type: " + remarkType + "\n");
                writer.write("Remark: " + remark + "\n");
                writer.write("=================================\n");
                return true;  // Return true if successfully written to the file
            } catch (IOException e) {
                e.printStackTrace();  // Print exception if file writing fails
                return false;
            }
        } else {
            return false;  // Return false if any condition fails
        }
    }

    // Setters for all attributes
    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public void setPatientFirstName(String firstName) {
        this.patientFirstName = firstName;
    }

    public void setPatientLastName(String lastName) {
        this.patientLastName = lastName;
    }

    public void setPatientAddress(String address) {
        this.patientAddress = address;
    }

    public void setSphericalValue(float sphericalValue) {
        this.sphericalValue = sphericalValue;
    }

    public void setAxisValue(float axisValue) {
        this.axisValue = axisValue;
    }

    public void setCylinderValue(float cylinderValue) {
        this.cylinderValue = cylinderValue;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public void setOptometristName(String optometrist) {
        this.optometristName = optometrist;
    }

    // Main method to take inputs and interact with the class
 // Main method to take inputs and interact with the class
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        EyePrescription prescription = new EyePrescription();  // Create a new EyePrescription object

        // Collect prescription details
        System.out.print("Enter Prescription ID: ");
        prescription.setPrescriptionID(inputScanner.nextInt());
        inputScanner.nextLine();  // Consume newline

        System.out.print("Enter First Name (4-15 characters): ");
        prescription.setPatientFirstName(inputScanner.nextLine());

        System.out.print("Enter Last Name (4-15 characters): ");
        prescription.setPatientLastName(inputScanner.nextLine());

        System.out.print("Enter Address (minimum 20 characters): ");
        prescription.setPatientAddress(inputScanner.nextLine());

        System.out.print("Enter Sphere Value (-20.00 to +20.00): ");
        prescription.setSphericalValue(inputScanner.nextFloat());

        System.out.print("Enter Cylinder Value (-4.00 to +4.00): ");
        prescription.setCylinderValue(inputScanner.nextFloat());

        System.out.print("Enter Axis Value (0 to 180): ");
        prescription.setAxisValue(inputScanner.nextFloat());
        inputScanner.nextLine();  // Consume newline

        // Get and validate the examination date
        System.out.print("Enter Examination Date (DD/MM/YY): ");
        String dateInput = inputScanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        try {
            Date testDate = dateFormat.parse(dateInput);
            prescription.setTestDate(testDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Use DD/MM/YY.");
            return;
        }

        System.out.print("Enter Optometrist Name (8-25 characters): ");
        prescription.setOptometristName(inputScanner.nextLine());

        // Test the addPrescription method
        if (prescription.addPrescription()) {
            System.out.println("Prescription created successfully.");
        } else {
            System.out.println("Failed to create prescription. Check input criteria.");
            return;
        }

        // Ask for remarks
        for (int i = 0; i < 2; i++) {
            System.out.println("Add a Remark (" + (i + 1) + " of 2)");

            System.out.print("Enter Remark (" + (i + 1) + ") (6 to 20 words, start with uppercase): ");
            String remark = inputScanner.nextLine();

            System.out.print("Enter Remark Type (Client/Optometrist): ");
            String remarkType = inputScanner.nextLine();

            // Test the addRemarks method
            if (prescription.addRemarks(remark, remarkType)) {
                System.out.println("Remark added successfully.");
            } else {
                System.out.println("Failed to add remark. Check input criteria.");
            }

            // Ask user if they want to add another remark
            if (i == 0) {  // Only ask after the first remark
                System.out.print("Do you want to enter another remark? (yes/no): ");
                String response = inputScanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;  // Exit the loop if the user says no
                }
            }
        }

        inputScanner.close();  // Close the scanner
    }
}