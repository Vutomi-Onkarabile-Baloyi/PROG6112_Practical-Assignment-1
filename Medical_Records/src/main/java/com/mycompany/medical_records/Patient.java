
package com.mycompany.medical_records;


public class Patient 
{

    Patient(String patientId, String firstName, String lastName, int age, String gender, String condition, Medical_Records.PatientCategory category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public enum PatientCategory 
    {
    INPATIENT,
    OUTPATIENT,
    EMERGENCY
    }
    
    // Information hiding: fields are private
    private String patientId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private PatientCategory category;

    // Constructor
    public Patient(String patientId, String firstName, String lastName,
                   int age, String gender, String medicalCondition,
                   PatientCategory category) 
    {

     setPatientId(patientId);
     setFirstName(firstName);
     setLastName(lastName);
     setAge(age);
     setGender(gender);
     setMedicalCondition(medicalCondition);

     if (category == null) 
     {
      throw new IllegalArgumentException("Patient category cannot be null.");
     }

     this.category = category;
    }

    // Getters
    public String getPatientId() 
    {
     return patientId;
    }

    public String getFirstName()
    {
     return firstName;
    }

    public String getLastName() 
    {
     return lastName;
    }

    public int getAge()
    {
     return age;
    }

    public String getGender()
    {
     return gender;
    }

    public String getMedicalCondition() 
    {
     return medicalCondition;
    }

    public PatientCategory getCategory() 
    {
     return category;
    }

    // Setters
    public void setPatientId(String patientId) 
    {
     if (patientId == null || patientId.trim().isEmpty()) 
     {
      throw new IllegalArgumentException("Patient ID cannot be empty.");
     }

     this.patientId = patientId.trim();
    }

    public void setFirstName(String firstName) 
    {
     if (firstName == null || firstName.trim().isEmpty()) 
     {
      throw new IllegalArgumentException("First name cannot be empty.");
     }

     this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) 
    {
     if (lastName == null || lastName.trim().isEmpty()) 
     {
      throw new IllegalArgumentException("Last name cannot be empty.");
     }

     this.lastName = lastName.trim();
    }

    public void setAge(int age) 
    {
     if (age < 0 || age > 120) 
     {
      throw new IllegalArgumentException("Age must be between 0 and 120.");
     }

     this.age = age;
    }

    public void setGender(String gender) 
    {
     if (gender == null || gender.trim().isEmpty()) 
     {
      throw new IllegalArgumentException("Gender cannot be empty.");
     }

    this.gender = gender.trim();
    }

    public void setMedicalCondition(String medicalCondition) 
    {
     if (medicalCondition == null || medicalCondition.trim().isEmpty()) 
     {
      throw new IllegalArgumentException("Medical condition cannot be empty.");
     }

    this.medicalCondition = medicalCondition.trim();
    }

    public void setCategory(PatientCategory category) 
    {
     if (category == null) 
     {
      throw new IllegalArgumentException("Patient category cannot be null.");
     }

     this.category = category;
    }

    // Method that will be overridden by Inpatient
    public void displayDetails() 
    {
     System.out.println("----------------------------------------");
     System.out.println("Patient ID: " + patientId);
     System.out.println("First Name: " + firstName);
     System.out.println("Last Name: " + lastName);
     System.out.println("Age: " + age);
     System.out.println("Gender: " + gender);
     System.out.println("Medical Condition: " + medicalCondition);
     System.out.println("Category: " + category);
     System.out.println("----------------------------------------");
    }

    @Override
    public String toString() 
    {
     return patientId + " - " + firstName + " " + lastName + " - " + category;
    }
} 

