package DataStructures.Stack;

import Data.City;

public class Stack {
    private Node head;
    private int size;

    public void setSize() {
        Node iterator = head;
        int count = 0;

        while (iterator != null) {
            count++;
            iterator = iterator.getPrevious();
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
            iterator = iterator.getPrevious();
        }
    }

    public void insert(City city) {
        // Inserting at the top of the stack
        if (head == null) {

            // If Stack was empty
            // Assign head to new element
            head = new Node(city);
        } else {

            // Previous element is head
            // Assign head to a new element
            head = new Node(city, head);
        }

        size++;
    }

    public Node search(String city) {
        if (head == null) {
            return null;
        } else {
            Node iterator = head;

            // Searching for element beginning with the head
            while(iterator != null) {
                if (iterator.getData().getName().equals(city)) {
                    return iterator;
                }

                iterator = iterator.getPrevious();
            }

            return null;
        }
    }

    public void delete() {
        // Deleting the element from the top of the Stack
        if (head != null) {
            head = head.getPrevious();
        }

        size--;
    }
}
