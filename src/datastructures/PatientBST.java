package datastructures;

import models.Patient;

public class PatientBST {

    private class Node {
        Patient patient;
        Node left;
        Node right;

        public Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public PatientBST() {
        this.root = null;
    }

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return root;
        }
        
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient with ID " + patient.getPatientId() + " already exists.");
        }

        return root;
    }

    public Patient search(int patientId) {
        Node result = searchRec(root, patientId);
        if (result != null) {
            return result.patient;
        }
        return null;
    }

    private Node searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return root;
        }

        if (root.patient.getPatientId() > patientId) {
            return searchRec(root.left, patientId);
        }

        return searchRec(root.right, patientId);
    }

    public void delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient with ID " + patientId + " not found.");
            return;
        }
        root = deleteRec(root, patientId);
        System.out.println("Patient " + patientId + " deleted successfully.");
    }

    private Node deleteRec(Node root, int patientId) {
        if (root == null) {
            return root;
        }

        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.patient = minValue(root.right);

            root.right = deleteRec(root.right, root.patient.getPatientId());
        }

        return root;
    }

    private Patient minValue(Node root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients found in the records.");
            return;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Patient Records (Sorted by ID):");
        System.out.println("---------------------------------------------------------");
        inorderRec(root);
        System.out.println("---------------------------------------------------------");
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }
}
