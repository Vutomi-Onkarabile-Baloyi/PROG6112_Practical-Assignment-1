
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
    
    public WardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalBeds method, of class Ward.
     */
    @Test
    public void testGetTotalBeds() {
        System.out.println("getTotalBeds");
        Ward instance = new Ward();
        int expResult = 0;
        int result = instance.getTotalBeds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBed method, of class Ward.
     */
    @Test
    public void testFindBed() {
        System.out.println("findBed");
        String bedNumber = "";
        Ward instance = new Ward();
        Bed expResult = null;
        Bed result = instance.findBed(bedNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allocateBed method, of class Ward.
     */
    @Test
    public void testAllocateBed() {
        System.out.println("allocateBed");
        String bedNumber = "";
        Patient patient = null;
        Ward instance = new Ward();
        instance.allocateBed(bedNumber, patient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of releaseBed method, of class Ward.
     */
    @Test
    public void testReleaseBed() {
        System.out.println("releaseBed");
        String bedNumber = "";
        Ward instance = new Ward();
        instance.releaseBed(bedNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayWardLayout method, of class Ward.
     */
    @Test
    public void testDisplayWardLayout() {
        System.out.println("displayWardLayout");
        Ward instance = new Ward();
        instance.displayWardLayout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAvailableBeds method, of class Ward.
     */
    @Test
    public void testDisplayAvailableBeds() {
        System.out.println("displayAvailableBeds");
        Ward instance = new Ward();
        instance.displayAvailableBeds();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayOccupiedBeds method, of class Ward.
     */
    @Test
    public void testDisplayOccupiedBeds() {
        System.out.println("displayOccupiedBeds");
        Ward instance = new Ward();
        instance.displayOccupiedBeds();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableBedCount method, of class Ward.
     */
    @Test
    public void testGetAvailableBedCount() {
        System.out.println("getAvailableBedCount");
        Ward instance = new Ward();
        int expResult = 0;
        int result = instance.getAvailableBedCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupiedBedCount method, of class Ward.
     */
    @Test
    public void testGetOccupiedBedCount() {
        System.out.println("getOccupiedBedCount");
        Ward instance = new Ward();
        int expResult = 0;
        int result = instance.getOccupiedBedCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupancyPercentage method, of class Ward.
     */
    @Test
    public void testGetOccupancyPercentage() {
        System.out.println("getOccupancyPercentage");
        Ward instance = new Ward();
        double expResult = 0.0;
        double result = instance.getOccupancyPercentage();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBeds method, of class Ward.
     */
    @Test
    public void testGetBeds() {
        System.out.println("getBeds");
        Ward instance = new Ward();
        Bed[][] expResult = null;
        Bed[][] result = instance.getBeds();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
