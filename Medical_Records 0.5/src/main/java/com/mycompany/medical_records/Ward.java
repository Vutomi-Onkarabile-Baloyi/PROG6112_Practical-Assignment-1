
package com.mycompany.medical_records;


public class Ward 
{
  private static final int ROWS = 4;
  private static final int COLUMNS = 5;
  private static final int TOTAL_BEDS = 20;
  private static final int WARD_NUMBER = 1;

  private Bed[][] beds;   
  

  public Ward() 
  {

   beds = new Bed[ROWS][COLUMNS];

   int bedNumber = 1;

   // Nested loops initialise the 4 x 5 array
   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++) 
    {
     String number = String.format("B%02d",bedNumber);

     beds[row][column] = new Bed(number);
    
     bedNumber++;
    }
   }
  }

  public int getTotalBeds() 
  {
   return TOTAL_BEDS;
  }

  // Find a bed by bed number
  public Bed findBed(String bedNumber) 
  {
   if (bedNumber == null) 
   {
    return null;
   }

   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++) 
    {
     if (beds[row][column].getBedNumber().equalsIgnoreCase(bedNumber.trim())) 
     {
      return beds[row][column];
     }
    }
   }

  return null;
  }

  // Allocate a bed
  public void allocateBed(String bedNumber, Patient patient) 
  {
   if (!(patient instanceof In_Patient)) 
   {
    throw new IllegalArgumentException( "Only Inpatients can be allocated a bed.");
   }

   In_Patient inpatient = (In_Patient) patient;

   if (inpatient.getBedNumber() != null) 
   {
    throw new IllegalStateException("This patient already has a bed.");
   }

   Bed bed = findBed(bedNumber);

   if (bed == null) 
   {
    throw new IllegalArgumentException( "Bed does not exist.");
   }

   if (bed.isOccupied()) 
   {
    throw new IllegalStateException( "Bed " + bedNumber + " is already occupied.");
   }

   if (getAvailableBedCount() == 0) 
   {
    throw new IllegalStateException("No beds are currently available.");
   }

   bed.allocate(inpatient);
  }

  // Release a bed
  public void releaseBed(String bedNumber) 
  {
   Bed bed = findBed(bedNumber);

   if (bed == null)
   {
    throw new IllegalArgumentException("Bed does not exist.");
   }

   if (!bed.isOccupied()) 
   {
    throw new IllegalStateException( "Bed " + bedNumber + " is already available.");
   }

   bed.release();
  }

  // Display complete ward layout
  public void displayWardLayout()
  {

   System.out.println("\n<<<<<<<<<< WARD LAYOUT >>>>>>>>>>");
   System.out.println("Ward Number: " + WARD_NUMBER);
   System.out.println();

   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++) 
    {
     Bed bed = beds[row][column];

     if (bed.isOccupied()) 
     {
      System.out.printf("[%-15s]", bed.getBedNumber() + " OCCUPIED");
     } 
     else 
     {
      System.out.printf("[%-15s]",bed.getBedNumber() + " AVAILABLE");
     }
    }

    System.out.println();
   }

   System.out.println();
  }

  // Display available beds
  public void displayAvailableBeds() 
  {
   System.out.println("\n<<<<<<<<<< AVAILABLE BEDS >>>>>>>>>>");

   boolean found = false;

   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++) 
    {
     Bed bed = beds[row][column];

     if (!bed.isOccupied()) 
     {
      System.out.println(bed.getBedNumber() + " - AVAILABLE");

      found = true;
     }
    }
   }

   if (!found) 
   {
    System.out.println("No beds are available.");
   }
  }

  // Display occupied beds
  public void displayOccupiedBeds() 
  {
   System.out.println("\n<<<<<<<<<< OCCUPIED BEDS >>>>>>>>>>");

   boolean found = false;

   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++) 
    {
     Bed bed = beds[row][column];

     if (bed.isOccupied()) 
     {
      In_Patient patient = bed.getPatient();

      System.out.println(bed.getBedNumber() + " - " + patient.getPatientId() + " - " +
                         patient.getFirstName() + " " + patient.getLastName());

      found = true;
     }
    }
   }

   if (!found) 
   {
    System.out.println("No beds are occupied.");
   }
  }

  // Count available beds
  public int getAvailableBedCount() 
  {
   int count = 0;

   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++) 
    {
     if (!beds[row][column].isOccupied())
     {
      count++;
     }
    }
   }

   return count;
  }

  // Count occupied beds
  public int getOccupiedBedCount() 
  {
   int count = 0;

   for (int row = 0; row < ROWS; row++) 
   {
    for (int column = 0; column < COLUMNS; column++)
    {
     if (beds[row][column].isOccupied()) 
     {
      count++;
     }
    }
   }

   return count;
  }

  // Occupancy percentage
  public double getOccupancyPercentage() 
  {
   return ((double) getOccupiedBedCount()/ TOTAL_BEDS) * 100;
  }

  public Bed[][] getBeds() 
  {
   return beds;
  }
}
