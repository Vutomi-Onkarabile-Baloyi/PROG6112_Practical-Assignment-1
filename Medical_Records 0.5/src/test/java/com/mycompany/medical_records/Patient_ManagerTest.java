
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
    
    
    //Test for Prevent duplicate Id's method
    @Test(expected = IllegalArgumentException.class)
    public void testPreventDuplicatePatientIds() 
    {
        Patient patient1 = new Patient("P00007","Frank","Miller", 60,"Male", "Bladder Cancer",
                                       Patient.PatientCategory.OUTPATIENT);
        Patient patient2 = new Patient("P00007","Rebecca","Wilson",55,"Female","Ehrlichiosis",
                                       Patient.PatientCategory.OUTPATIENT);
        patientManager.registerPatient(patient1);
        patientManager.registerPatient(patient2);
    
    }



    //Test for sorting by surname
    @Test
    public void testSortPatientsBySurname() 
    {

        Patient patient1 = new Patient("P00008","Marcus","Zeele",30,"Male","Fibromyalgia",
                                       Patient.PatientCategory.OUTPATIENT);
        Patient patient2 = new Patient("P00009","Ramona","Adams",25,"Female","Enterovirus",
                                       Patient.PatientCategory.OUTPATIENT);
        Patient patient3 = new Patient("P00010","Peter","Murphy",40,"Male","Diabetes",
                                       Patient.PatientCategory.OUTPATIENT);
        patientManager.registerPatient(patient1);
        patientManager.registerPatient(patient2);
        patientManager.registerPatient(patient3);
        patientManager.sortBySurname();
        assertEquals("Adams", patientManager.getPatients().get(0).getLastName());
        assertEquals("Murphy", patientManager.getPatients().get(1).getLastName());
        assertEquals("Zeele", patientManager.getPatients().get(2).getLastName());
    }

   
 
    //Test for Sorting patients by Patient ID
    @Test
    public void testSortPatientsByPatientId() 
    {

        Patient patient1 = new Patient("P99627","Ian","Curtis", 30,"Male", "Giardiasis",
                                       Patient.PatientCategory.OUTPATIENT);
        Patient patient2 = new Patient("P48793","Ramona","Flowers",25,"Female","Hantaviruses",
                                       Patient.PatientCategory.OUTPATIENT);
        Patient patient3 = new Patient("P03397","Emerson","Lake",40,"Male","Mumps",
                                       Patient.PatientCategory.OUTPATIENT);
        patientManager.registerPatient(patient1);
        patientManager.registerPatient(patient2);
        patientManager.registerPatient(patient3);
        patientManager.sortByPatientId();
        assertEquals("P03397", patientManager.getPatients().get(0).getPatientId());
        assertEquals("P48793", patientManager.getPatients().get(1).getPatientId());
        assertEquals("P99627", patientManager.getPatients().get(2).getPatientId());
    }

}
