package DataStructures.LinkedList;

import Data.City;

public class LinkedList {
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize() {
        Node iterator = head;
        int count = 0;

        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }

        size = count;
    }

    public void print() {
        Node iterator = head;

        while (iterator != null) {
            System.out.print(iterator.getData());
            iterator = iterator.getNext();
        }
    }

    public void insert(City city, int position) {
        // Calculate size of the list for current moment
        setSize();

        if (position < 0 || position > getSize()) {
            System.out.println("Bad position!");
            return;
        }

        // If list is empty -> head is null
        if (head == null) {
            // We can insert in empty list only on the 0 position
            head = new Node(city);
        } else {
            Node last = head;
            int counter = 0;

            // Go to the element after which you wold like to insert a new one
            while (counter < position - 1) {
                last = last.getNext();
                counter++;
            }

            // To insert a new element
            // Say to a new one that its next element wold be next for the last
            // And to last that next element would be a new one
            last.setNext(new Node(city, last.getNext()));
        }
    }

    public Node search(String city) {
        if (head == null) {
            return null;
        } else {
            Node iterator = head;

            while(iterator != null) {
                if (iterator.getData().getName().equals(city)) {
                    return iterator;
                }

                iterator = iterator.getNext();
            }

            return null;
        }
    }

    public void delete(String city) {
        // We can't delete anything if the list is null
        if (head == null) {
            return;
        }

        // If head is equal to the element we want to remove
        if (head.getData().getName().equals(city)) {

            // And list has only one element
            // Just assign head to null -> list would be empty
            if (head.getNext() == null) {
                head = null;
            } else {

                // Set head to next element of the list
                head = head.getNext();
            }
        } else {
            Node iterator = head;
            Node next = head.getNext();

            // Searching for element to delete
            while (next.getNext() != null) {

                // If element is the one we want to delete
                if (next.getData().getName().equals(city)) {

                    // For iterator next element would be the next one for next
                    iterator.setNext(next.getNext());
                    // And next is next for next
                    if (next.getNext() != null) {
                        next = next.getNext();
                    }
                }

                iterator = next;
                next = next.getNext();
            }
        }
    }
}
