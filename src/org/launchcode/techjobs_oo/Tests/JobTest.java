package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job one;
    Job two;

    @Before
    public void createJobsWithConstructor() {

        one = new Job();
        two = new Job();
    }

    //Testing empty constructors

    @Test
    public void testSettingJobId() {

        assertEquals(1, one.getId(), 0.001);
        assertEquals(1+1, two.getId(), 0.001);
        assertFalse("false", two.getId() != 2);
    }

    //Testing full constructors with checks for proper assignment of classes and values related to them

    @Test
    public void testJobConstructorSetsAllFields() {

        Job three = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

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

    //Testing custom equals method

    @Test
    public void testJobsForEquality() {

        Job four = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        Job five = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        assertFalse("false", four.equals(five));
    }

    @Test
    public void testToString() {

        //Testing for blank lines before and after the job information
        //Testing for “OOPS! This job does not seem to exist.” message when only "id" is available

        Job six = new Job();

        assertEquals("\n" +
                "OOPS! This job does not seem to exist." +
                "\n", six.toString());

        //Testing for proper labels and assigned values in the job information

        Job seven = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        assertEquals("\n" +
                "ID: " + 4 + "\n" +
                "Name: " + "John Smith" + "\n" +
                "Employer: " + "Google" + "\n" +
                "Location: " + "Silicon Valley" + "\n" +
                "Position Type: " + "UX Designer" + "\n" +
                "Core Competency: " + "Problem Solving" +
                "\n", seven.toString());

        //Testing for correct message "Data not available"  displayed when field/s left empty

        Job eight = new Job("", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency(""));

        assertEquals("\n" +
                "ID: " + 5 + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "Google" + "\n" +
                "Location: " + "Silicon Valley" + "\n" +
                "Position Type: " + "UX Designer" + "\n" +
                "Core Competency: " + "Data not available" +
                "\n", eight.toString());
    }
}
