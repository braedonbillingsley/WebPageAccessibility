package driver;

import accessibility.AccessibilityResults;

/**
 * Main driver class for WebPageAccessibility project
 *
 * @author Braedon Billingsley
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        AccessibilityResults test = new AccessibilityResults("data/a11yCheckersResults.txt");


        System.out.println(test.numPass("Goog", ""));
        System.out.println(test.numPass("lint", "htm"));


        //test.showTestResults("Colour");
        //System.out.println();
        //test.showByCategory("key");
        //System.out.println();

        //test.showByCategory("keyboard");
        //System.out.println();
        //test.showAllFailed();
    }
}