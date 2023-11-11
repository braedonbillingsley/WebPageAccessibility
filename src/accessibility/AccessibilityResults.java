package accessibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * AccessibilityResults constructs a AccessibilityResults object that reads and stores test information
 * from a file of test results and has methods for viewing the results data in different ways.
 *
 * @author Braedon Billingsley
 * @version 1.0
 */
public class AccessibilityResults {
    private Set<AccessibilityTest> tests;

    /**
     * Constructs a AccessibilityResults object by reading a file by each line within
     * a try/with block to catch exceptions.
     *
     * @param filename String containing the relative path of the input file.
     */
    public AccessibilityResults(String filename) {
        tests = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ");
                if (parts.length >= 5) {
                    String category = parts[0];
                    String googleResult = parts[1];
                    String waveResult = parts[2];
                    String sortsiteResult = parts[3];
                    String aslintResult = parts[4];

                    StringBuilder descriptionBuilder = new StringBuilder();
                    for (int i = 5; i < parts.length; i++) {
                        descriptionBuilder.append(parts[i]).append(" ");
                    }
                    String description = descriptionBuilder.toString().trim();

                    AccessibilityTest test = new AccessibilityTest(category, description, googleResult, waveResult, sortsiteResult, aslintResult);
                    tests.add(test);
                }
            }
        } catch (IOException e) {
            System.out.println("Invalid filename: " + e);
        }
    }

    /**
     * Retrieves the Set of AccessibilityTest objects.
     *
     * @return The Set of AccessibilityTest objects.
     */
    public Set<AccessibilityTest> getTests() {
        return tests;
    }

    /**
     * Returns number of tests stored in the AccessibilityResults object.
     *
     * @return number of tests in the tests set.
     */
    public int numTests() {
        return getTests().size();
    }

    /**
     * Displays test info for tests that match or contain a given detail.
     *
     * @param detail detail to match.
     */
    public void showTestResults(String detail) {
        int count = 0;
        detail = detail.toLowerCase();

        for (AccessibilityTest test : tests) {
            if (test.getDescription().toLowerCase().contains(detail)) {
                System.out.println(test);
                count++;
            }
        }
        System.out.println("\n" + "Total tests matching: " + count);
    }

    /**
     * Displays test info for tests that contain the given category.
     *
     * @param categoryDetail category detail to match or contain in test information.
     */
    public void showByCategory(String categoryDetail) {
        int count = 0;
        categoryDetail = categoryDetail.toLowerCase();

        for (AccessibilityTest test : tests) {
            if (test.getCategory().toLowerCase().contains(categoryDetail)) {
                System.out.println(test);
                count++;
            }
        }
        System.out.println("Total tests in category: " + count);
    }

    /**
     * Displays test information for tests that all checkers have failed / result is "notfound".
     */
    public void showAllFailed() {
        int count = 0;
        for (AccessibilityTest test : tests) {
            if (test.getGoogleResult().equalsIgnoreCase("notfound") &&
                    test.getWaveResult().equalsIgnoreCase("notfound") &&
                    test.getSortsiteResult().equalsIgnoreCase("notfound") &&
                    test.getAslintResult().equalsIgnoreCase("notfound")) {
                System.out.println(test);
                count++;
            }
        }
        System.out.println("Total tests failed: " + count);
    }

    /**
     * Returns the number of tests that passed (result is "error" or "error_paid") for a given checker name and category (case-insensitive).
     *
     * @param checkerName The checker name to match or contain in test results.
     * @param category The category to match or contain in test results.
     * @return number of tests that passed for the checker name and category.
     */
    public int numPass(String checkerName, String category) {
        int count = 0;
        for (AccessibilityTest test : tests) {
            String checkerResult = test.getGoogleResult().toLowerCase();
            String testCategory = test.getCategory().toLowerCase();

            if ((checkerResult.contains("error") || checkerResult.contains("error_paid")) &&
                    (testCategory.contains(category.toLowerCase()) || checkerName.isEmpty() || testCategory.contains(checkerName.toLowerCase()))) {
                count++;
            }
        }
        return count;
    }
}
