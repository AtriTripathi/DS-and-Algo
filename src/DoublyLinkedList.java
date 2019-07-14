/*
 * Developed by Atri Tripathi on 14/7/19 9:39 PM
 * Last modified 14/7/19 8:41 PM
 * Copyright (c) 2019. All rights reserved
 */

class Neighbor {
    public String homeOwnerName;
    public int houseNumber;

    public Neighbor next;
    public Neighbor previous;

    public Neighbor(String homeOwnerName, int houseNumber) {
        this.homeOwnerName = homeOwnerName;
        this.houseNumber = houseNumber;
    }

    public void display() {
        System.out.println(homeOwnerName + " : " + houseNumber);
    }

    @Override
    public String toString() {
        return homeOwnerName;
    }
}

public class DoublyLinkedList {
    Neighbor firstLink;
    Neighbor lastLink;

    private boolean isEmpty() {
        return firstLink == null;
    }

    public void insertFirst(String homeOwnerName, int houseNumber) {
        Neighbor newLink = new Neighbor(homeOwnerName,houseNumber);

        if (isEmpty()) {
            lastLink = newLink;
        } else {
            firstLink.previous = newLink;
        }
        newLink.next = firstLink;
        firstLink =  newLink;
    }

    public void insertLast(String homeOwnerName, int houseNumber) {
        Neighbor newLink = new Neighbor(homeOwnerName,houseNumber);

        if (isEmpty()) {
            firstLink = newLink;
        } else {
            lastLink.next = newLink;
            newLink.previous = lastLink;
        }

        lastLink = newLink;
    }

    public void displayList() {
        Neighbor currentLink = firstLink;

        while (currentLink != null) {
            currentLink.display();
            System.out.println("Next Link: " + currentLink.next);

            currentLink = currentLink.next;

            System.out.println();
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst("Mark",453);
        doublyLinkedList.insertFirst("Alice",235);
        doublyLinkedList.insertLast("John",110);
        doublyLinkedList.insertFirst("Lisa",726);

        doublyLinkedList.displayList();
    }
}
