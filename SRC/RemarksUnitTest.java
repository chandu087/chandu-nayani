import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RemarksUnitTest {

    private EyePrescription prescription;

    // Set up a new EyePrescription object before each test
    @BeforeEach
    void setUp() {
        prescription = new EyePrescription();
    }

    // Test case for adding a valid client remark
    @Test
    void testAddValidRemarkClient() {
        assertTrue(prescription.addRemarks("Schedule regular check-ups for optimal eye health.", "Client"));
    }

    @Test
    void testAddValidRemarkClient01() {
        assertTrue(prescription.addRemarks("Consider blue light glasses for screen time protection.", "Client"));
    }

    // Test case for adding a valid optometrist remark
    @Test
    void testAddValidRemarkOptometrist() {
        assertTrue(prescription.addRemarks("For better eyesight, keep your lenses clean every day.", "Optometrist"));
    }

    @Test
    void testAddValidRemarkOptometrist01() {
        assertTrue(prescription.addRemarks("Maintain proper hydration to promote general eye health.", "Optometrist"));
    }

    // Test case for adding a remark that is too short
    @Test
    void testAddRemarkTooShort() {
        assertFalse(prescription.addRemarks("Short", "Client"));
    }

    @Test
    void testAddRemarkTooShort01() {
        assertFalse(prescription.addRemarks("I need eye checkup", "Client"));
    }

    // Test case for adding a remark that is too long
    @Test
    void testAddRemarkTooLong() {
        String longRemark = "Every 20 minutes, look at something 20 feet away for at least 20 seconds. This simple practice can help reduce eye strain and improve comfort";
        assertFalse(prescription.addRemarks(longRemark, "Client"));
    }

    @Test
    void testAddRemarkTooLong01() {
        String longRemark = "Your eye health can be greatly improved by include foods high in omega-3 fatty acids, including walnuts and salmon, in your diet.";
        assertFalse(prescription.addRemarks(longRemark, "Client"));
    }

    // Test case for adding a remark that starts with a lowercase letter
    @Test
    void testAddRemarkStartsWithLowercase() {
        assertFalse(prescription.addRemarks("limit screen time to reduce eye strain", "Client"));
    }

    @Test
    void testAddRemarkStartsWithLowercase01() {
        assertFalse(prescription.addRemarks("when handling contact lenses, maintain proper hygiene.", "Client"));
    }

    // Test case for adding a remark with an invalid type
    @Test
    void testAddInvalidRemarkType() {
        assertFalse(prescription.addRemarks("This is a valid remark.", "Unknown"));
    }

    @Test
    void testAddInvalidRemarkType01() {
        assertFalse(prescription.addRemarks("Eat a healthy, vitamin-rich diet.", "Customer"));
    }

    // Test case for adding two valid remarks
    @Test
    void testAddTwoValidRemarks() {
        assertTrue(prescription.addRemarks("Suffering from dry eyes, using the artificial tears.", "Client"));
        assertTrue(prescription.addRemarks("To avoid discomfort and harm, do not rub your eyes.", "Optometrist"));
    }

    @Test
    void testAddTwoValidRemarks01() {
        assertTrue(prescription.addRemarks("I'd like to complain about persistent eye discomfort", "Client"));
        assertTrue(prescription.addRemarks("To prevent infections, change your contact lenses frequently.", "Optometrist"));
    }
  
}
