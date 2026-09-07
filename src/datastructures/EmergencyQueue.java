package datastructures;

import models.Patient;

public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        public Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + patient.getPatientName() + " (ID: " + patient.getPatientId() + ") added to the emergency queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("The emergency queue is empty. No patients to treat.");
            return null;
        }
        
        Patient patientToTreat = front.patient;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        System.out.println("Patient " + patientToTreat.getPatientName() + " (ID: " + patientToTreat.getPatientId() + ") is now being treated.");
        return patientToTreat;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The emergency queue is currently empty.");
            return;
        }
        
        System.out.println("---------------------------------------------------------");
        System.out.println("Patients Waiting in Emergency Queue:");
        System.out.println("---------------------------------------------------------");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
        System.out.println("---------------------------------------------------------");
    }

    public boolean isEmpty() {
        return front == null;
    }
}
