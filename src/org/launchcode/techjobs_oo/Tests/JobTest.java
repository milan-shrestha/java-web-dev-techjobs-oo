package org.launchcode.techjobs_oo.Tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static Job one;
    private static Job two;
    private static Job three;
    private static Job four;
    private static Job five;
    private static Job six;
    private static Job seven;
    private static Job eight;

    @BeforeClass
    public static void createJobsWithConstructor() {

        one = new Job();

        two = new Job();

        three = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        four = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        five = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        six = new Job();

        seven = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        eight = new Job("", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency(""));
    }


    // Testing empty constructors
    @Test
    public void testSettingJobId() {

        assertEquals(1, one.getId(), 0.001);
        assertEquals(1+1, two.getId(), 0.001);
        assertFalse("false", two.getId() != 2);
    }


    // Testing full constructors with checks for proper assignment of classes and values related to them
    @Test
    public void testJobConstructorSetsAllFields() {

        assertEquals(3,three.getId());
        assertEquals("Product tester", three.getName());
        assertEquals("ACME", three.getEmployer().getValue());
        assertTrue("true", three.getEmployer() instanceof Employer);
        assertEquals("Desert", three.getLocation().getValue());
        assertTrue("true", three.getLocation() instanceof Location);
        assertEquals("Quality control", three.getPositionType().getValue());
        assertTrue("true", three.getPositionType() instanceof PositionType);
        assertEquals("Persistence", three.getCoreCompetency().getValue());
        assertTrue("true", three.getCoreCompetency() instanceof CoreCompetency);
    }


    // Testing custom equals method
    @Test
    public void testJobsForEquality() {

        assertFalse("false", four.equals(five));
    }


    // Testing custom toString method
    @Test
    public void testToString() {

        // Testing for blank lines before and after the job information
        // Testing for “OOPS! This job does not seem to exist.” message when only "id" is available

        assertEquals("\n" +
                "OOPS! This job does not seem to exist." +
                "\n", six.toString());

        // Testing for proper labels and assigned values in the job information

        assertEquals("\n" +
                "ID: " + 7 + "\n" +
                "Name: " + "John Smith" + "\n" +
                "Employer: " + "Google" + "\n" +
                "Location: " + "Silicon Valley" + "\n" +
                "Position Type: " + "UX Designer" + "\n" +
                "Core Competency: " + "Problem Solving" +
                "\n", seven.toString());

        // Testing for correct message "Data not available"  displayed when field/s left empty

        assertEquals("\n" +
                "ID: " + 8 + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "Google" + "\n" +
                "Location: " + "Silicon Valley" + "\n" +
                "Position Type: " + "UX Designer" + "\n" +
                "Core Competency: " + "Data not available" +
                "\n", eight.toString());
    }
}
