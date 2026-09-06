package datastructures;

import models.Patient;

public class TreatmentStack {

    private class Node {
        Patient patient;
        Node next;

        public Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        this.top = null;
    }

    public void push(Patient patient) {
        Node newNode = new Node(patient);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record for patient " + patient.getPatientName() + " added to stack.");
    }

    public Patient pop() {
        if (isEmpty()) {
            System.out.println("Treatment history stack is empty. No records to pop.");
            return null;
        }
        
        Patient poppedPatient = top.patient;
        top = top.next;
        System.out.println("Removed most recent treatment record for patient: " + poppedPatient.getPatientName() + ".");
        return poppedPatient;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Treatment history stack is currently empty.");
            return;
        }
        
        System.out.println("---------------------------------------------------------");
        System.out.println("Completed Treatment Records (Most Recent First):");
        System.out.println("---------------------------------------------------------");
        Node current = top;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.patient);
            current = current.next;
            count++;
        }
        System.out.println("---------------------------------------------------------");
    }

    public boolean isEmpty() {
        return top == null;
    }
}
