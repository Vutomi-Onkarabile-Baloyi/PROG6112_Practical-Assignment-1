
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
     patientManager = new Patient_Manager();   
    }
    
    @After
    public void tearDown() 
    {
     patientManager = null;   
    }
    


    /**
     * Test of registerPatient method, of class Patient_Manager.
     */
    @Test
    public void testRegisterPatient() 
    {
        System.out.println("registerPatient");
        Patient patient = new Patient("P00001","Joshua", "Clay", 30,"Male", "Influenza",
                                      Patient.PatientCategory.OUTPATIENT);
        patientManager.registerPatient(patient);
        assertEquals(1, patientManager.getPatientCount());
        assertNotNull(patientManager.searchPatient("P00001"));
        assertEquals("Joshua", patientManager.searchPatient("P00001").getFirstName());
    
    }


    
    /**
     * Test of searchPatient method, of class Patient_Manager.
     */
    @Test
    public void testSearchPatient() 
    {
        System.out.println("searchPatient");
        Patient patient = new Patient("P00002","Cliff","Steele",25,"Male", "Asthma",
                                      Patient.PatientCategory.OUTPATIENT);
        patientManager.registerPatient(patient);
        Patient result = patientManager.searchPatient("P00002");
        assertNotNull(result);
        assertEquals("P00002", result.getPatientId());
        assertEquals("Cliff", result.getFirstName());
        assertEquals("Steele", result.getLastName());
    
    }



    /**
     * Test of updatePatient method, of class Patient_Manager.
     */
    @Test
    public void testUpdatePatient() 
    {
        System.out.println("updatePatient");
        Patient patient = new Patient("P00003","Michael","Jones",40, "Male","Diabetes",
                                       Patient.PatientCategory.OUTPATIENT);
        patientManager.registerPatient(patient);
        patientManager.updatePatient("P00003","Michael","Johnson",41, "Male"," Tibia Fracture");
        Patient updated = patientManager.searchPatient("P00003");
        assertNotNull(updated);
        assertEquals("Michael", updated.getFirstName());
        assertEquals("Johnson", updated.getLastName());
        assertEquals(41, updated.getAge());
        assertEquals("Male", updated.getGender());
        assertEquals("Hypertension", updated.getMedicalCondition());


    }

    /**
     * Test of deletePatient method, of class Patient_Manager.
     */
    @Test
    public void testDeletePatient() 
    {
       System.out.println("deletePatient");
       Patient patient = new Patient("P00004","Rac","Shade", 35,"Male","Migraine",
                                      Patient.PatientCategory.OUTPATIENT);
       patientManager.registerPatient(patient);
       assertEquals(1, patientManager.getPatientCount());
       patientManager.deletePatient("P00004");
       assertEquals(0, patientManager.getPatientCount());
       assertNull(patientManager.searchPatient("P00004"));
    
    }


    
    
    
    
}
