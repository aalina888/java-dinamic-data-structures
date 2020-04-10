package DataStructures.Queue;

import Data.City;

public class Queue {
    private Node head;
    private int size;

    public void setSize() {
        Node iterator = head;
        int count = 0;

        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }

        size = count;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        Node iterator = head;

        while (iterator != null) {
            System.out.print(iterator.getData());
            iterator = iterator.getNext();
        }
    }

    public void insert(City city) {
        // Insert a new element at the end of the Queue
        if (head == null) {
            head = new Node(city);
        } else {
            Node last = head;

            // Go to the last element of the Queue
            while (last.getNext() != null) {
                last = last.getNext();
            }

            // Create new element
            // It will be next for the last
            last.setNext(new Node(city));
        }

        // Increment Size of the Queue
        size++;
    }

    public Node search(String city) {
        // If Queue is empty return null
        if (head == null) {
            return null;
        } else {
            Node iterator = head;

            // Searching for the element
            while(iterator != null) {

                // If the element was found
                // Return it
                if (iterator.getData().getName().equals(city)) {
                    return iterator;
                }

                iterator = iterator.getNext();
            }

            return null;
        }
    }

    public void delete() {
        // Delete first element from the Queue
        // If Queue is not empty
        // Assign head to next
        if (head != null) {
            head = head.getNext();
        }

        // Decrement Size of the Queue
        size--;
    }
}
