package accessibility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test class for AccessibilityTest getters and setters
 */
public class AccessibilityTestTest {

    @Test
    public void testAccessibilityTestConstructor() {
        AccessibilityTest test = new AccessibilityTest("Category", "Description", "GoogleResult", "WaveResult", "SortsiteResult", "AslintResult");

        assertEquals("Category", test.getCategory());
        assertEquals("Description", test.getDescription());
        assertEquals("GoogleResult", test.getGoogleResult());
        assertEquals("WaveResult", test.getWaveResult());
        assertEquals("SortsiteResult", test.getSortsiteResult());
        assertEquals("AslintResult", test.getAslintResult());
    }

    @Test
    public void testAccessibilityTestToString() {
        AccessibilityTest test = new AccessibilityTest("Category", "Description", "GoogleResult", "WaveResult", "SortsiteResult", "AslintResult");

        String expectedString = "Category: Description Google: GoogleResult WAVE: WaveResult SortSite: SortsiteResult ASLint: AslintResult";
        assertEquals(expectedString, test.toString());
    }

    @Test
    public void testSettersAndGetters() {
        AccessibilityTest test = new AccessibilityTest("Category", "Description", "GoogleResult", "WaveResult", "SortsiteResult", "AslintResult");

        test.setCategory("NewCategory");
        test.setDescription("NewDescription");
        test.setGoogleResult("NewGoogleResult");
        test.setWaveResult("NewWaveResult");
        test.setSortsiteResult("NewSortsiteResult");
        test.setAslintResult("NewAslintResult");

        assertEquals("NewCategory", test.getCategory());
        assertEquals("NewDescription", test.getDescription());
        assertEquals("NewGoogleResult", test.getGoogleResult());
        assertEquals("NewWaveResult", test.getWaveResult());
        assertEquals("NewSortsiteResult", test.getSortsiteResult());
        assertEquals("NewAslintResult", test.getAslintResult());
    }
}