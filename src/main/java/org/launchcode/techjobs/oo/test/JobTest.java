package org.launchcode.techjobs.oo.test;

import org.junit.*;
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

    static Job testJob1;
    static Job testJob2;
    static Job testJob3;

    @BeforeClass
    public static void initializeTestObject() {
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
       assertEquals("two job objects created in the row should have sequential integer IDs", -1, new Job().getId() - new Job().getId());
        System.out.println(testJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assert testJob1 instanceof Job;
        assertTrue( testJob1.getId() == 1 );
        assertTrue("Product tester".equals(testJob1.getName()) );
        assertTrue("ACME".equals(testJob1.getEmployer().getValue()) );
        assertTrue("Desert".equals(testJob1.getLocation().getValue()) );
        assertTrue("Quality control".equals(testJob1.getPositionType().getValue()) );
        assertTrue("Persistence".equals(testJob1.getCoreCompetency().getValue()) );
        assertEquals(1, testJob1.getId());
        assertEquals("Product tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        assertEquals("\n", Character.toString(testJob1.toString().charAt(0)) );
        assertEquals("\n", Character.toString(testJob1.toString().charAt(testJob1.toString().length()-1)) );
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        assertEquals("\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", testJob1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        assertEquals("\nID: 3\nName: Product tester\nEmployer: ACME\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Persistence\n", testJob3.toString());
    }



}
