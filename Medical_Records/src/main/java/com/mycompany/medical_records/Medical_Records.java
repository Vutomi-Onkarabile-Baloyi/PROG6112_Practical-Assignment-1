

package com.mycompany.medical_records;
import java.util.Scanner;

public class Medical_Records 
{
    public enum PatientCategory 
    {
    INPATIENT,
    OUTPATIENT,
    EMERGENCY
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static final Patient_Manager Manager = new Patient_Manager();

    private static final Ward ward = new Ward();

    public static void main(String[] args) 
    {

     System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
     System.out.println("       MEDICARE HOSPITAL SYSTEM");
     System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");

     boolean running = true;

     while (running) 
     {
      displayMainMenu();
      int choice = readInt("Enter your choice: ");

      try
      { 
       switch (choice) 
       {
        case 1: registerPatient();
        break;

        case 2: searchPatient();
        break;

        case 3:updatePatient();
        break;

        case 4: deletePatient();
        break;

        case 5: Manager.displayAllPatients();
        break;

        case 6: allocateBed();
        break;

        case 7: releaseBed();
        break;

        case 8: ward.displayWardLayout();
        break;

        case 9: ward.displayAvailableBeds();
        break;

        case 10: ward.displayOccupiedBeds();
        break;

        case 11: displayReports();
        break;

        case 12: sortPatients();
        break;

        case 0: running = false;
        System.out.println("Thank you for using MediCare Hospital System.");
        break;

        default:
        System.out.println("Invalid choice. Please select a NUMBER from the options given");
                
       }
      } 
      catch (IllegalArgumentException | IllegalStateException e) 
      {
       System.out.println("\nERROR: " + e.getMessage());
      }
     }

    scanner.close();
    }

    // Main menu
    private static void displayMainMenu() 
    {
     System.out.println("\n<><><><><><><><><><><><><><><><><><><><><><>");
     System.out.println("              MAIN MENU");
     System.out.println("{Select a the number to perform the Action}");
     System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
     System.out.println("1 - Register Patient");
     System.out.println("2 - Patient search");
     System.out.println("3 - Update Patient");
     System.out.println("4 - Delete Patient");
     System.out.println("5 - Display All Patients");
     System.out.println("6 - Allocate Bed");
     System.out.println("7 - Release Bed");
     System.out.println("8 - Ward Layout");
     System.out.println("9 - Number of Available Beds");
     System.out.println("10 - Display Occupied Beds");
     System.out.println("11 - Reports");
     System.out.println("12 - Sort Patients");
     System.out.println("0 - Exit");
     System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
    }

    // Register patient
    private static void registerPatient() 
    {
     System.out.println("\n<<<<<<<<<<< PATIENT REGISTRATION >>>>>>>>>>>");

     String patientId = readString("Patient ID: ");

     String firstName = readString("First Name: ");

     String lastName = readString("Last Name: ");

     int age = readInt("Age: ");

     String gender = readString("Gender: ");

     String condition = readString("Medical Condition: ");

     PatientCategory category = readCategory();

     Patient patient;

     if (category == PatientCategory.INPATIENT) 
     {
      int wardNumber = readInt("Ward Number: ");

      patient = new In_Patient(patientId, firstName, lastName, age, gender, condition,
                    wardNumber, null);

     } 
     else 
     {
      patient = new Patient(patientId, firstName, lastName, age, gender, condition, category);
     }

      Manager.registerPatient(patient);

      System.out.println( "Patient registered successfully.");
    }

    // Search patient
    private static void searchPatient() 
    {
     System.out.println("\n<<<<<<<<<< PATIENT SEARCH >>>>>>>>>>");

     String id = readString("Enter Patient ID: ");

     Patient patient = Manager.searchPatient(id);

     if (patient == null) 
     {
      System.out.println( "Patient not found.");
     } 
     else 
     {
      patient.displayDetails();
     }
    }

    // Update patient
    private static void updatePatient() 
    {
     System.out.println("\n<<<<<<<<<< UPDATE PATIENT >>>>>>>>>>");

     String id = readString("Enter Patient ID: ");

     Patient existing = Manager.searchPatient(id);

     if (existing == null) 
     {
      System.out.println("Patient not found.");
      return;
     }

     System.out.println( "Enter the new patient details:");

     String firstName = readString("First Name: ");

     String lastName = readString("Last Name: ");

     int age = readInt("Age: ");

     String gender = readString("Gender: ");

     String condition = readString("Medical Condition: ");

     Manager.updatePatient(id, firstName, lastName, age, gender,condition);

     System.out.println("Patient updated successfully.");
    }

    // Delete patient
    private static void deletePatient() 
    {
      System.out.println("\n<<<<<<<<<< DELETE PATIENT >>>>>>>>>>");

      String id = readString("Enter Patient ID: ");

      Patient patient = Manager.searchPatient(id);

      if (patient == null) 
      {
       System.out.println("Patient not found.");
       return;
      }

        
     // Prevent deleting an inpatient with a bed
     if (patient instanceof In_Patient) 
     {
      In_Patient inpatient = (In_Patient) patient;

      if (inpatient.getBedNumber() != null) 
      {
       System.out.println("Patient issued bed " + inpatient.getBedNumber() + ". Release the bed before deleting.");
       return;
      }
     }

     Manager.deletePatient(id);

     System.out.println("Patient deleted successfully.");
    }

    
    // Allocate bed
    private static void allocateBed() 
    {
     System.out.println("\n<<<<<<<<<< ALLOCATE BED >>>>>>>>>>");

     if (ward.getAvailableBedCount() == 0) 
     {
      System.out.println("No beds are currently available.");
      return;
     }

     String patientId = readString("Patient ID: ");

     Patient patient = Manager.searchPatient(patientId);

     if (patient == null) 
     {
      System.out.println("Patient not found.");
      return;
     }

     if (!(patient instanceof In_Patient)) 
     {
      System.out.println("Only Inpatients can be allocated a bed.");
      return;
     }

     String bedNumber = readString("Bed Number (e.g. B01): ");

     ward.allocateBed(bedNumber,patient);

     System.out.println("Bed " + bedNumber +" successfully allocated to " + patient.getFirstName() +
                        " " + patient.getLastName() + ".");
    }

   
    // Release bed
    private static void releaseBed() 
    {
     System.out.println("\n<<<<<<<<<< RELEASE BED >>>>>>>>>>");

     String bedNumber = readString("Bed Number: ");

     ward.releaseBed(bedNumber);

     System.out.println("Bed " + bedNumber + " has been released successfully.");
    }

    
    // Reports
    private static void displayReports() 
    {
     boolean back = false;

     while (!back) 
     {

       System.out.println("\n<<<<<<<<<< REPORTS >>>>>>>>>>");

       System.out.println("1 - Display All Registered Patients");

       System.out.println("2 - Display Available Beds");

       System.out.println("3 - Display Occupied Beds");

       System.out.println("4 - Total Registered Patients");

       System.out.println("5 - Total Occupied Beds");

       System.out.println("6 - Ward Occupancy Percentage");

       System.out.println("0 - Back to Main Menu");

       int choice = readInt("Pick an Action(number): ");

       switch (choice) 
       {

        case 1: Manager.displayAllPatients();
                break;

        case 2: ward.displayAvailableBeds();
                break;

        case 3: ward.displayOccupiedBeds();
                break;

        case 4: System.out.println("Total Registered Patients: " + Manager.getPatientCount());
                break;

        case 5: System.out.println("Total Occupied Beds: " + ward.getOccupiedBedCount());
                break;

        case 6: System.out.printf("Ward Occupancy: %.2f%%%n", ward.getOccupancyPercentage());
                break;

        case 0: back = true;
                break;

        default: System.out.println("Invalid choice.");
       
       }
     }
    }

    // Sorting
    private static void sortPatients() 
    {
     System.out.println("\n<<<<<<<<<<< SORT PATIENTS >>>>>>>>>>>");
     System.out.println("1 - Sort by Surname");
     System.out.println("2 - Sort by Patient ID");
     System.out.println("3 - Sort by Surname then First Name");
     System.out.println("0 - Cancel");

     int choice = readInt("Enter choice: ");

     switch (choice) 
     {
      case 1: Manager.sortBySurname();
              System.out.println("Patients sorted by surname.");
              Manager.displayAllPatients();
              break;

      case 2: Manager.sortByPatientId();
              System.out.println("Patients sorted by Patient ID.");
              Manager.displayAllPatients();
              break;

      case 3: Manager.sortBySurnameThenFirstName();
              System.out.println("Patients sorted by surname and first name.");
              Manager.displayAllPatients();
              break;

      case 0: break;

      default: System.out.println("Invalid choice.");
     }
    }

    
    // Read String safely
    private static String readString(String message) 
    {
     while (true) 
     {
      System.out.print(message);

      String input = scanner.nextLine().trim();

      if (!input.isEmpty()) 
      {
       return input;
      }

      System.out.println("You can't input nothing. Please try again.");
     }
    }

    
    // Read integer safely
    private static int readInt(String message) 
    {
     while (true) 
     {
      System.out.print(message);

      String input = scanner.nextLine().trim();

      try 
      {
       return Integer.parseInt(input);
      } 
      catch (NumberFormatException e) 
      {
       System.out.println( "Please enter a valid number.");
      }
     }
    }

    
    // Read patient category using enum
    private static PatientCategory readCategory() 
    {
     while (true) 
     {
      System.out.println("\nPatient Category: ");

      System.out.println("1 - Inpatient");

      System.out.println("2 - Outpatient");

      System.out.println("3 - Emergency");

      int choice = readInt("Select category: ");

      switch (choice) 
      {
       case 1: return PatientCategory.INPATIENT;

       case 2: return PatientCategory.OUTPATIENT;

       case 3: return PatientCategory.EMERGENCY;

       default: System.out.println("Invalid category.");
      }
     }
    }
}
    

//Bibliography
//W3Schools (2020). Java Exceptions (Try...Catch). [online] W3Schools. Available at: https://www.w3schools.com/java/java_try_catch.asp [Accessed 30 August 2026].
//W3Schools (2019). Java Enums. [online] W3schools.com. Available at: https://www.w3schools.com/java/java_enums.asp [Accessed 25 August 2026].
//W3Schools (2019). Java ArrayList. [online] W3schools.com. Available at: https://www.w3schools.com/java/java_arraylist.asp [Accessed 25 August 2026]