package edu.eci;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Unit test for simple Nano Spark Web App.
 */
public class AppTest extends TestCase {


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testShouldFindJsPage() {
        try {
            String urlString = "https://infinite-ridge-77551.herokuapp.com/";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/webapp.js").openStream()));
            assertTrue(true);
        } catch (IOException e) {
            fail("Resource not foundL");
        }
    }

    public void testShouldFindImage() {
        try {
            String urlString = "https://infinite-ridge-77551.herokuapp.com/";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/ibai.png").openStream()));
            assertTrue(true);
        } catch (IOException e) {
            fail("Resource not found");
        }
    }

    public void testShouldFindHtmlPage() {
        try {
            String urlString = "https://infinite-ridge-77551.herokuapp.com";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/index.html").openStream()));
            assertTrue(true);
        } catch (IOException e) {
            fail("Resource not found");
        }
    }

}