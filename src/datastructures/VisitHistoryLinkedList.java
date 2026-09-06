package datastructures;

import models.Visit;

public class VisitHistoryLinkedList {
    
    private class Node {
        Visit visit;
        Node next;

        public Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    public VisitHistoryLinkedList() {
        this.head = null;
    }
    
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit ID " + visit.getVisitId() + " added to patient's history.");
    }
    
    public void removeVisit(String visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.getVisitId().equals(visitId)) {
            head = head.next;
            System.out.println("Visit ID " + visitId + " removed successfully.");
            return;
        }

        Node current = head;
        Node prev = null;
        
        while (current != null && !current.visit.getVisitId().equals(visitId)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Visit ID " + visitId + " not found in history.");
            return;
        }

        prev.next = current.next;
        System.out.println("Visit ID " + visitId + " removed successfully.");
    }

    public Visit searchVisit(String visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId().equals(visitId)) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }
    
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        
        System.out.println("---------------------------------------------------------");
        System.out.println("Patient Visit History:");
        System.out.println("---------------------------------------------------------");
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.visit);
            current = current.next;
            count++;
        }
        System.out.println("---------------------------------------------------------");
    }
}
