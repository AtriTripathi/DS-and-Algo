/*
 * Developed by Atri Tripathi on 14/7/19 9:39 PM
 * Last modified 14/7/19 1:03 PM
 * Copyright (c) 2019. All rights reserved
 */

class Link {
    String bookName;
    int price;
    Link next;

    Link(String bookName, int price) {
        this.bookName = bookName;
        this.price = price;
    }

    public void display() {
        System.out.println("Book Name: " + bookName + " | " + "Price: " + price);
    }

    public String toString() {
        return bookName;
    }
}

public class LinkedList {
    private Link firstLink;     // Default value: null

    private boolean isEmpty() {
        return firstLink == null;
    }

    private void insertFirst(String bookame, int price) {
        Link newLink = new Link(bookame,price);

        newLink.next = firstLink;
        firstLink = newLink;
    }

    private Link removeFirst() {
        Link deleteLink = firstLink;

        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else System.out.println("Empty LinkedList");

        return deleteLink;
    }

    private void displayList() {
        Link currentLink = firstLink;

        while (currentLink != null) {
            currentLink.display();

            System.out.println("Next Link: " + currentLink.next);
            currentLink = currentLink.next;

            System.out.println();
        }
    }

    private Link find(String bookName) {
        Link currentLink = firstLink;

        if (!isEmpty()) {
            while (!currentLink.bookName.equals(bookName)) {
                if (currentLink.next == null) {
                    return null;        // Book not in the list
                } else {
                    currentLink = currentLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return currentLink;
    }

    private Link removeLink(String bookName) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (!currentLink.bookName.equals(bookName)) {

            if (currentLink.next == null) {
                return null;        // Book not in the list
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if (currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst("A Tale of Two Cities",500);
        linkedList.insertFirst("Atomic Habits",350);
        linkedList.insertFirst("Kite Runner",220);
        linkedList.insertFirst("Bhagvad Gita",150);

        linkedList.displayList();

        linkedList.removeFirst();
        linkedList.displayList();

        System.out.println(linkedList.find("Atomic Habits") + " was found");

        linkedList.removeLink("Atomic Habits");
        linkedList.displayList();
    }
}
