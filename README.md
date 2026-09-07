# Mini Hospital Emergency Management System

## Task Overview
This project is an implementation of a Mini Hospital Emergency Management System using custom data structures in Java. It simulates the management of patients arriving at a hospital, including patient registration, emergency treatment requests, treatment completion, and patient visit history. 

This project was developed for the **CIT300 - Data Structures and Algorithms** Mid Assignment.

## Data Structures Implemented

All data structures in this project were implemented **from scratch** using custom `Node` classes, avoiding Java's built-in collections.

1. **Patient Records (Binary Search Tree - BST)**
   - Used to store registered patients using their `Patient ID` as the key.
   - Allows for efficient searching, insertion, and deletion of patient records.
   - Includes an in-order traversal to display patients in ascending ID order.

2. **Emergency Patient Queue (Queue)**
   - Used to manage patients waiting for emergency treatment.
   - Follows the **FIFO (First-In, First-Out)** principle to ensure fair, sequential treatment of arriving patients.

3. **Treatment History (Stack)**
   - Used to store records of completed treatments.
   - Follows the **LIFO (Last-In, First-Out)** principle, allowing hospital staff to review the most recent treatments first.

4. **Patient Visit History (Singly Linked List)**
   - Each patient record contains a linked list to dynamically store their previous hospital visits without fixed size limitations.

## Project Structure
```text
src/
├── models/
│   ├── Patient.java                # Represents a patient and holds their visit history
│   └── Visit.java                  # Represents a single hospital visit
├── datastructures/
│   ├── PatientBST.java             # BST implementation for patient records
│   ├── EmergencyQueue.java         # Queue implementation for waiting patients
│   ├── TreatmentStack.java         # Stack implementation for treatment history
│   └── VisitHistoryLinkedList.java # Linked List for patient visits
└── Main.java                       # Interactive CLI menu and system integration
```

## How to Run

1. Navigate to the `src` directory in your terminal:
   ```bash
   cd src
   ```

2. Compile all the Java files:
   ```bash
   javac Main.java models/*.java datastructures/*.java
   ```
   *(Note: If `javac` is not in your system's PATH, you can use the absolute path to your JDK `bin` folder, e.g., `"C:\Program Files\Java\jdk-26.0.2.1\bin\javac.exe" Main.java models/*.java datastructures/*.java`)*

3. Run the application:
   ```bash
   java Main
   ```

## Demonstration
A demonstration video of this system running, along with an explanation of the underlying data structure implementations, is provided alongside this repository as part of the assignment submission.
