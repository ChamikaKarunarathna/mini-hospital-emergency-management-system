import datastructures.EmergencyQueue;
import datastructures.PatientBST;
import datastructures.TreatmentStack;
import models.Patient;
import models.Visit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();

        boolean exit = false;

        System.out.println("==================================================");
        System.out.println("  Mini Hospital Emergency Management System");
        System.out.println("==================================================");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register a New Patient");
            System.out.println("2. Display All Registered Patients");
            System.out.println("3. Search for a Patient");
            System.out.println("4. Add Patient to Emergency Queue");
            System.out.println("5. View Emergency Queue");
            System.out.println("6. Treat Next Patient in Queue");
            System.out.println("7. View Treatment History Stack");
            System.out.println("8. Add Visit History to a Patient");
            System.out.println("9. View Patient Visit History");
            System.out.println("10. Delete a Patient");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Contact Number: ");
                        String contact = scanner.nextLine();
                        System.out.print("Enter Medical Condition: ");
                        String condition = scanner.nextLine();
                        
                        Patient newPatient = new Patient(id, name, age, contact, condition);
                        patientBST.insert(newPatient);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format. Registration aborted.");
                    }
                    break;

                case 2:
                    patientBST.displayInOrder();
                    break;

                case 3:
                    try {
                        System.out.print("Enter Patient ID to search: ");
                        int searchId = Integer.parseInt(scanner.nextLine());
                        Patient foundPatient = patientBST.search(searchId);
                        if (foundPatient != null) {
                            System.out.println("Patient Found: " + foundPatient);
                        } else {
                            System.out.println("Patient with ID " + searchId + " not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Patient ID to add to queue: ");
                        int qId = Integer.parseInt(scanner.nextLine());
                        Patient qPatient = patientBST.search(qId);
                        if (qPatient != null) {
                            emergencyQueue.enqueue(qPatient);
                        } else {
                            System.out.println("Patient not found. Please register first.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case 5:
                    emergencyQueue.displayQueue();
                    break;

                case 6:
                    Patient treatedPatient = emergencyQueue.dequeue();
                    if (treatedPatient != null) {
                        treatmentStack.push(treatedPatient);
                    }
                    break;

                case 7:
                    treatmentStack.displayStack();
                    break;

                case 8:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int vId = Integer.parseInt(scanner.nextLine());
                        Patient vPatient = patientBST.search(vId);
                        if (vPatient != null) {
                            System.out.print("Enter Visit ID: ");
                            String visitId = scanner.nextLine();
                            System.out.print("Enter Visit Date: ");
                            String date = scanner.nextLine();
                            System.out.print("Enter Doctor Name: ");
                            String doctor = scanner.nextLine();
                            System.out.print("Enter Diagnosis: ");
                            String diagnosis = scanner.nextLine();
                            System.out.print("Enter Treatment: ");
                            String treatment = scanner.nextLine();

                            Visit visit = new Visit(visitId, date, doctor, diagnosis, treatment);
                            vPatient.getVisitHistory().addVisit(visit);
                        } else {
                            System.out.println("Patient not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case 9:
                    try {
                        System.out.print("Enter Patient ID: ");
                        int hId = Integer.parseInt(scanner.nextLine());
                        Patient hPatient = patientBST.search(hId);
                        if (hPatient != null) {
                            hPatient.getVisitHistory().displayHistory();
                        } else {
                            System.out.println("Patient not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case 10:
                    try {
                        System.out.print("Enter Patient ID to delete: ");
                        int delId = Integer.parseInt(scanner.nextLine());
                        patientBST.delete(delId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case 11:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        }
        scanner.close();
    }
}
