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

    @Test
    public void testSettingJobId() {

        assertEquals(1, one.getId(), 0.001);
        assertEquals(1+1, two.getId(), 0.001);
        assertFalse("false", two.getId() != 2);
    }

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

    @Test
    public void testJobsForEquality() {

        Job four = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        Job five = new Job("John Smith", new Employer("Google"), new Location("Silicon Valley"),
                new PositionType("UX Designer"), new CoreCompetency("Problem Solving"));

        assertFalse("false", four.equals(five));
    }
}
