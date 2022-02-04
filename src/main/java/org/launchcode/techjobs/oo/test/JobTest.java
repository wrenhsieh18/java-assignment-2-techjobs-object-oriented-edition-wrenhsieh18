package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.print.attribute.standard.JobName;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;

    @Before
    public void initializeTestObject() {
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJodId() {
       assertEquals("two job objects created in the row should have sequential integer IDs", 1, testJob2.getId() - testJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assert testJob3 instanceof Job;
        assertEquals("should assign proper ID", 3, testJob3.getId());
        assertEquals("should assign proper name","Product tester", testJob3.getName());
        assertEquals("should assign proper employer","ACME", testJob3.getEmployer().getValue());
        assertEquals("should assign proper location","Desert", testJob3.getLocation().getValue());
        assertEquals("should assign proper position type","Quality control", testJob3.getPositionType().getValue());
        assertEquals("should assign proper core competency","Persistence", testJob3.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        assertEquals(false, testJob3.equals(testJob4));
    }



}
