
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
    
    // Test to prevention of allocation of an occupied bed feature
    @Test(expected = IllegalStateException.class)
    public void testPreventAllocatingOccupiedBed() 
    {
        In_Patient patient1 = new In_Patient("P00011","Alan","Moore",30,"Male","Flu",1,null);
        In_Patient patient2 = new In_Patient("P00012","Ziggy","Stardust", 40,"Male","Liver Cancer",1,null);
        ward.allocateBed("B01", patient1);
        ward.allocateBed("B01", patient2);
    }

    
    // Test for preventing bed allocation when all beds are occupied(DOES NOT WORK)
    @Test(expected = IllegalStateException.class)
    public void testPreventAllocationWhenAllBedsOccupied() 
    {
        
        for (int i = 1; i <= 20; i++) 
        {
         String patientId = String.format("P%05d", i);
         In_Patient patient = new In_Patient(patientId,"Patient","Test" + i, 20 + i,"Male","General",1,null);
         String bedNumber = String.format("B%02d", i);
         ward.allocateBed(bedNumber, patient);
        }
        
        assertEquals(20, ward.getOccupiedBedCount());
        assertEquals(0, ward.getAvailableBedCount());
        In_Patient extraPatient = new In_Patient("P00021","Extra","Patient",30,"Female","General",1,null);

 
        ward.allocateBed("B01", extraPatient);
    }

    
}
