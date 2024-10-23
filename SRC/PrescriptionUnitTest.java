import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


class PrescriptionUnitTest {

    private EyePrescription prescription;

    // Set up a new EyePrescription object before each test
    @BeforeEach
    void setUp() {
        prescription = new EyePrescription();
    }

    // Test case for a valid prescription
    @Test
    void testValidPrescription() throws ParseException {
        prescription.setPrescriptionID(1);
        prescription.setPatientFirstName("Julian");
        prescription.setPatientLastName("Hinton");
        prescription.setPatientAddress("Apt. 662 9150 Corinne Turnpike, New Julian, IA 12410-8128");
        prescription.setSphericalValue(0.00f);
        prescription.setCylinderValue(0.00f);
        prescription.setAxisValue(90.00f);
        prescription.setTestDate(new SimpleDateFormat("dd/MM/yy").parse("21/10/23"));
        prescription.setOptometristName("Benjamin Campion");

        // Verify that the prescription is successfully added
        assertTrue(prescription.addPrescription());
    }

    @Test
    void testValidPrescription01() throws ParseException {
        prescription.setPrescriptionID(1);
        prescription.setPatientFirstName("Oscar");
        prescription.setPatientLastName("Woolls");
        prescription.setPatientAddress("815 Lauryn Unions, Lanitafort, LA 01870");
        prescription.setSphericalValue(2.00f);
        prescription.setCylinderValue(2.00f);
        prescription.setAxisValue(80.00f);
        prescription.setTestDate(new SimpleDateFormat("dd/MM/yy").parse("21/10/23"));
        prescription.setOptometristName("Lincoln McCubbin");

        // Verify that the prescription is successfully added
        assertTrue(prescription.addPrescription());
    }

    // Test case for first name that is too short
    @Test
    void testFirstNameTooShort() {
        prescription.setPatientFirstName("Sus");
        prescription.setPatientLastName("McMillan");
        prescription.setPatientAddress("Suite 513 5689 Denesik Circle, Klockomouth, KS 35352");
        prescription.setSphericalValue(12.00f);
        prescription.setCylinderValue(2.00f);
        prescription.setAxisValue(90.00f);
        prescription.setOptometristName("Dylan Zouch");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testFirstNameTooShort01() {
        prescription.setPatientFirstName("Rya");
        prescription.setPatientLastName("Tyas");
        prescription.setPatientAddress("4748 Gracie Creek, Lake Vincent, NV 09140");
        prescription.setSphericalValue(16.00f);
        prescription.setCylinderValue(1.00f);
        prescription.setAxisValue(120.00f);
        prescription.setOptometristName("Matthew Ewan");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    // Test case for last name that is too long
    @Test
    void testLastNameTooLong() {
        prescription.setPatientFirstName("David");
        prescription.setPatientLastName("Austin Fairweather");
        prescription.setPatientAddress("Suite 528 69560 Todd Meadow, South Dwight, UT 96744");
        prescription.setSphericalValue(11.00f);
        prescription.setCylinderValue(-1.00f);
        prescription.setAxisValue(70.00f);
        prescription.setOptometristName("Michael Narelle");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testLastNameTooLong01() {
        prescription.setPatientFirstName("David");
        prescription.setPatientLastName("Oscar Fairweather");
        prescription.setPatientAddress("56930 Ritchie Freeway, East Digna, CO 38714");
        prescription.setSphericalValue(11.00f);
        prescription.setCylinderValue(-1.50f);
        prescription.setAxisValue(90.00f);
        prescription.setOptometristName("Sean Sturt");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    // Test case for an address that is too short
    @Test
    void testAddressTooShort() {
        prescription.setPatientFirstName("Ashton");
        prescription.setPatientLastName("Serra");
        prescription.setPatientAddress("India");
        prescription.setSphericalValue(10.00f);
        prescription.setCylinderValue(3.00f);
        prescription.setAxisValue(90.00f);
        prescription.setOptometristName("Justin Southwell");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testAddressTooShort01() {
        prescription.setPatientFirstName("Charles");
        prescription.setPatientLastName("Lawton");
        prescription.setPatientAddress("Vietnam");
        prescription.setSphericalValue(11.00f);
        prescription.setCylinderValue(-3.00f);
        prescription.setAxisValue(90.00f);
        prescription.setOptometristName("Justin Southwell");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    // Test case for spherical value that is out of bounds
    @Test
    void testSphericalValueOutOfBounds() {
        prescription.setPatientFirstName("Joel");
        prescription.setPatientLastName("Garvan");
        prescription.setPatientAddress("2805 Rosario Row, Robertsshire, MT 29324-4758");
        prescription.setSphericalValue(25.00f); // Out of bounds
        prescription.setCylinderValue(1.00f);
        prescription.setAxisValue(90.00f);
        prescription.setOptometristName("Daniel Longworth");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testSphericalValueOutOfBounds01() {
        prescription.setPatientFirstName("Lucas");
        prescription.setPatientLastName("Lipscombe");
        prescription.setPatientAddress("1640 Roberts Junctions, Rolandton, NY 94637");
        prescription.setSphericalValue(34.00f); // Out of bounds
        prescription.setCylinderValue(3.00f);
        prescription.setAxisValue(90.00f);
        prescription.setOptometristName("Hunter Ritchie");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    // Test case for optometrist name that is too short
    @Test
    void testOptometristNameTooShort() {
        prescription.setPatientFirstName("Victoria");
        prescription.setPatientLastName("Belcher");
        prescription.setPatientAddress("Suite 117 657 Russ Valleys, Danside, AZ 84946-6101");
        prescription.setSphericalValue(13.00f);
        prescription.setCylinderValue(2.60f);
        prescription.setAxisValue(64.00f);
        prescription.setOptometristName("Ram");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    @Test
    void testOptometristNameTooShort01() {
        prescription.setPatientFirstName("Sofia");
        prescription.setPatientLastName("Dyason");
        prescription.setPatientAddress("5286 Spencer Wells, North Deandrea, OR 28996");
        prescription.setSphericalValue(17.00f);
        prescription.setCylinderValue(-2.40f);
        prescription.setAxisValue(54.00f);
        prescription.setOptometristName("Jay");

        // Verify that the prescription fails to be added
        assertFalse(prescription.addPrescription());
    }

    // Test case for a valid prescription with edge values
    @Test
    void testValidPrescriptionMinValues() throws ParseException {
        prescription.setPrescriptionID(5);
        prescription.setPatientFirstName("Charlie");
        prescription.setPatientLastName("Brown");
        prescription.setPatientAddress("4768 Grimes Stravenue, Port Jefferymouth, ID 92126-8189");
        prescription.setSphericalValue(-10.00f);  // Minimum spherical value
        prescription.setCylinderValue(-2.00f);     // Minimum cylindrical value
        prescription.setAxisValue(0.0f);            // Minimum axis value
        prescription.setTestDate(new SimpleDateFormat("dd/MM/yy").parse("24/10/23"));
        prescription.setOptometristName("Annabelle Ramsay");

        // Verify that the prescription is successfully added
        assertTrue(prescription.addPrescription());
    }

    @Test
    void testValidPrescriptionMinValues01() throws ParseException {
        prescription.setPrescriptionID(5);
        prescription.setPatientFirstName("Stella");
        prescription.setPatientLastName("Bushby");
        prescription.setPatientAddress("Apt. 816 8860 Willms Isle, Andersonbury, MN 15947-9006");
        prescription.setSphericalValue(-20.00f);  // Minimum spherical value
        prescription.setCylinderValue(-4.00f);     // Minimum cylindrical value
        prescription.setAxisValue(0.0f);            // Minimum axis value
        prescription.setTestDate(new SimpleDateFormat("dd/MM/yy").parse("24/10/23"));
        prescription.setOptometristName("Sarah Mackinnon");

        // Verify that the prescription is successfully added
        assertTrue(prescription.addPrescription());
    }

}
