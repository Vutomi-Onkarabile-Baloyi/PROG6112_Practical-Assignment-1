
package com.mycompany.medical_records;


public class Bed 
{
  private String bedNumber;
  private boolean occupied;
  private In_Patient patient;

    public Bed(String bedNumber) 
    {
      this.bedNumber = bedNumber;
      this.occupied = false;
      this.patient = null;
    }

    public String getBedNumber() 
    {
     return bedNumber;
    }

    public boolean isOccupied() 
    {
     return occupied;
    }

    public In_Patient getPatient() 
    {
     return patient;
    }

    public void allocate(In_Patient patient) 
    {

      if (occupied) 
      {
       throw new IllegalStateException("Bed " + bedNumber + " is already occupied.");
      }

      if (patient == null) 
      {
       throw new IllegalArgumentException( "Patient cannot be null.");
      }

      this.patient = patient;
      this.occupied = true;

      patient.setBedNumber(bedNumber);
    }

    public void release() 
    {

      if (!occupied) 
      {
       throw new IllegalStateException("Bed " + bedNumber + " is already available.");
      }

      if (patient != null) 
      {
       patient.setBedNumber(null);
      }

      this.patient = null;
      this.occupied = false;
    }

    @Override
    public String toString()
    {

     if (occupied) 
     {
      return bedNumber + " - OCCUPIED - " + patient.getPatientId() + " " + patient.getFirstName() + " " +
      patient.getLastName();
     }

     return bedNumber + " - AVAILABLE";
    }   
}
