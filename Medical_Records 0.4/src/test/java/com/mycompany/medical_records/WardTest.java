
package com.mycompany.medical_records;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vutom
 */
public class WardTest {
    
    private Ward ward;
    private Patient_Manager patientManager;
        
    public WardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
     patientManager = new Patient_Manager();     
     ward = new Ward();   
    }
    
    @After
    public void tearDown() 
    {
     patientManager = null;     
    }

    
     
     /**
     * Test of allocateBed method, of class Ward.
     */
    @Test
    public void testAllocateBed() 
    {
        System.out.println("allocateBed");
        In_Patient patient = new In_Patient("P00005", "Sumio","Mondo", 50,"Male","Hypertension",1, null);
        patientManager.registerPatient(patient);
        ward.allocateBed("B13", patient);
        Bed bed = ward.findBed("B13");
        assertNotNull(bed);
        assertTrue(bed.isOccupied());
        assertEquals(patient, bed.getPatient());
        assertEquals("B13", patient.getBedNumber());
        assertEquals(1, ward.getOccupiedBedCount());
        assertEquals(19, ward.getAvailableBedCount());

    }

    
    
     /**
     * Test of releaseBed method, of class Ward.
     */
    @Test
    public void testReleaseBed() 
    {
        System.out.println("releaseBed");
        In_Patient patient = new In_Patient("P00006","Romeo","Stargazer", 32,"Male","Pneumonia", 1, null);
        ward.allocateBed("B20", patient);
        assertTrue(ward.findBed("B20").isOccupied());
        assertEquals("B20", patient.getBedNumber());
        ward.releaseBed("B20");
        Bed bed = ward.findBed("B20");
        assertFalse(bed.isOccupied());
        assertNull(bed.getPatient());
        assertNull(patient.getBedNumber());
        assertEquals(0, ward.getOccupiedBedCount());
        assertEquals(20, ward.getAvailableBedCount());

    }
    
    
}
