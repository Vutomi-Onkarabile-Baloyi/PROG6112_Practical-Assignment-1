
package com.mycompany.medical_records;

import java.util.List;
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
public class Patient_ManagerTest {
   
    private Patient_Manager patientManager;
    
    public Patient_ManagerTest() {
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
     Patient_Manager patientManager = new Patient_Manager();   
    }
    
    @After
    public void tearDown() {
    }
    
    
    private In_Patient createInPatient(String id, String firstName, String lastName, int age) 
    {
     return new In_Patient(id, firstName, lastName, age,"Male", "General", 1, null);
    };


    /**
     * Test of registerPatient method, of class Patient_Manager.
     */
    @Test
    public void testRegisterPatient() 
    {
        
        System.out.println("registerPatient");
        Patient patient = createInPatient("P05728", "Joshua","Clay",30);
        patientManager.registerPatient(patient);
        assertEquals(1, patientManager.getPatientCount());
        assertSame(patient, patientManager.searchPatient("P05728"));

    }

    /**
     * Test of searchPatient method, of class Patient_Manager.
     */
    @Test
    public void testSearchPatient() 
    {
        System.out.println("searchPatient");
        Patient patient = createInPatient("P05728", "Joshua","Clay",30);
        patientManager.registerPatient(patient);
        Patient result = patientManager.searchPatient("P00001");
        assertNotNull(result);
        assertEquals("P00001", result.getPatientId());
        assertEquals("John", result.getFirstName());
        assertEquals("Smith", result.getLastName());

    }

    /**
     * Test of updatePatient method, of class Patient_Manager.
     */
    @Test
    public void testUpdatePatient() 
    {
        System.out.println("updatePatient");
        Patient patient = createInPatient("P05728", "Joshua","Clay",30);
        patientManager.registerPatient(patient);
        patientManager.updatePatient("P00001","Michael","Brown", 35, "Male", "Asthma");
        Patient updatedPatient = patientManager.searchPatient("P00001");
        assertEquals("Michael", updatedPatient.getFirstName());
        assertEquals("Brown", updatedPatient.getLastName());
        assertEquals(35, updatedPatient.getAge());
        assertEquals("Male", updatedPatient.getGender());
        assertEquals("Asthma", updatedPatient.getMedicalCondition());

    }

    /**
     * Test of deletePatient method, of class Patient_Manager.
     */
    @Test
    public void testDeletePatient() 
    {
        System.out.println("deletePatient");
        Patient patient = createInPatient("P05728", "Joshua","Clay",30);
        patientManager.registerPatient(patient);
        assertEquals(1, patientManager.getPatientCount());
        patientManager.deletePatient("P00001");
        assertEquals(0, patientManager.getPatientCount());
        assertNull(patientManager.searchPatient("P00001"));

    }
    
}
