
package com.mycompany.medical_records;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Patient_Manager 
{
 private ArrayList<Patient> patients;

 public Patient_Manager() 
 {
  patients = new ArrayList<>();
 }

 // Register patient
 public void registerPatient(Patient patient) 
 {
  if (patient == null) 
  {
   throw new IllegalArgumentException("Patient cannot be null.");
  }

  if (searchPatient(patient.getPatientId()) != null) 
  {
   throw new IllegalArgumentException("Patient ID already exists.");
  }

  patients.add(patient);
 }

 // Search patient
 public Patient searchPatient(String patientId) 
 {
  if (patientId == null || patientId.trim().isEmpty()) 
  {
   return null;
  }

  for (Patient patient : patients) 
  {
   if (patient.getPatientId().equalsIgnoreCase(patientId.trim())) 
   {
    return patient;
   }
  }

  return null;
 }

 // Update patient
 public void updatePatient(String patientId, String firstName, String lastName,
                           int age, String gender,String medicalCondition) 
 {
  Patient patient = searchPatient(patientId);

  if (patient == null) 
  {
   throw new IllegalArgumentException("Patient not found.");
  }

  patient.setFirstName(firstName);
  patient.setLastName(lastName);
  patient.setAge(age);
  patient.setGender(gender);
  patient.setMedicalCondition(medicalCondition);
 }

 // Delete patient
 public void deletePatient(String patientId) 
 {
  Patient patient = searchPatient(patientId);

  if (patient == null) 
  {
   throw new IllegalArgumentException("Patient not found.");
  }

  patients.remove(patient);
 }

 // Return number of registered patients
 public int getPatientCount() 
 {
  return patients.size();
 }

 // Return a copy of the list
 public List<Patient> getPatients() 
 {
  return new ArrayList<>(patients);
 }

 // Display all patients
 public void displayAllPatients() 
 {
  if (patients.isEmpty()) 
  {
   System.out.println("No patients are registered.");
   return;
  }

  System.out.println("\n<<<<<<<<<< ALL PATIENTS >>>>>>>>>>");

  for (Patient patient : patients) 
  {
   patient.displayDetails();
  }
 }

 // Sort by surname
 public void sortBySurname() 
 {
  patients.sort(Comparator.comparing(Patient::getLastName,String.CASE_INSENSITIVE_ORDER));
 }

 // Sort by Patient ID
 public void sortByPatientId() 
 {
  patients.sort(Comparator.comparing(Patient::getPatientId,String.CASE_INSENSITIVE_ORDER));
 }

 // Sort by surname and then first name
 public void sortBySurnameThenFirstName() 
 {
  patients.sort(Comparator.comparing(Patient::getLastName,String.CASE_INSENSITIVE_ORDER)
          .thenComparing(Patient::getFirstName, String.CASE_INSENSITIVE_ORDER));
 }   
}
