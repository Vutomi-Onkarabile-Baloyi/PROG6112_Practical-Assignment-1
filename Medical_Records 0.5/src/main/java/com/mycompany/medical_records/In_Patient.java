
package com.mycompany.medical_records;

public class In_Patient extends Patient
{
  private int wardNumber;
  private String bedNumber;

   public In_Patient(String patientId, String firstName, String lastName, int age,
                     String gender, String medicalCondition, int wardNumber, String bedNumber) 
   {
     // Call superclass constructor
     super(patientId,firstName,lastName,age,gender,medicalCondition, Patient.PatientCategory.INPATIENT);

     setWardNumber(wardNumber);
     setBedNumber(bedNumber);
    }

    public int getWardNumber() 
    {
     return wardNumber;
    }

    public String getBedNumber() 
    {
     return bedNumber;
    }

    public void setWardNumber(int wardNumber) 
    {
      if (wardNumber <= 0) 
      {
       throw new IllegalArgumentException("Ward number must be greater than zero.");
      }

      this.wardNumber = wardNumber;
    }

    public void setBedNumber(String bedNumber) 
    {
      if (bedNumber == null || bedNumber.trim().isEmpty()) 
      {
       this.bedNumber = null;
      } 
      else 
      {
       this.bedNumber = bedNumber.trim();
      }
    }

    @Override
    public void displayDetails() 
    {

        // Call superclass displayDetails()
        super.displayDetails();

        System.out.println("Ward Number: " + wardNumber);

        if (bedNumber == null) 
        {
         System.out.println("Bed Number: Not Allocated");
        } 
        else 
        {
         System.out.println("Bed Number: " + bedNumber);
        }

        System.out.println("----------------------------------------");
    }    
}
