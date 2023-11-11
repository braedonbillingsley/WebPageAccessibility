package accessibility;

/**
 * AccessibilityTest class constructs a AccessibilityTest object that can be used
 * to create objects containing the information from Accessibility Test results.
 *
 * @author Braedon Billingsley
 * @version 1.0
 */
public class AccessibilityTest {
    private String category;
    private String description;
    private String googleResult;
    private String waveResult;
    private String sortsiteResult;
    private String aslintResult;

    public AccessibilityTest(String category, String description, String googleResult, String waveResult, String sortsiteResult, String aslintResult) {
        this.category = category;
        this.description = description;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortsiteResult = sortsiteResult;
        this.aslintResult = aslintResult;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoogleResult() {
        return googleResult;
    }

    public void setGoogleResult(String googleResult) {
        this.googleResult = googleResult;
    }

    public String getWaveResult() {
        return waveResult;
    }

    public void setWaveResult(String waveResult) {
        this.waveResult = waveResult;
    }

    public String getSortsiteResult() {
        return sortsiteResult;
    }

    public void setSortsiteResult(String sortsiteResult) {
        this.sortsiteResult = sortsiteResult;
    }

    public String getAslintResult() {
        return aslintResult;
    }

    public void setAslintResult(String aslintResult) {
        this.aslintResult = aslintResult;
    }

    /**
     * toString method that organizes the fields for better user display
     * on the console.
     * @return returns a String containing a formatted string ready to print to console.
     */
    @Override
    public String toString() {
        return category + ": " + description + " Google: " + googleResult + " WAVE: " + waveResult + " SortSite: " + sortsiteResult + " ASLint: " + aslintResult;

    }
}
