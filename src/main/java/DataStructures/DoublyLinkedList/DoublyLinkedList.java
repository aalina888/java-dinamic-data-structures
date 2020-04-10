package DataStructures.DoublyLinkedList;

import Data.City;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void setSize() {
        Node iterator = head;
        int count1 = 0;

        while (iterator != null) {
            count1++;
            iterator = iterator.getNext();
        }

        iterator = tail;
        int count2 = 0;

        while (iterator != null) {
            count2++;
            iterator = iterator.getPrevious();
        }

        if (count1 == count2) {
            size = count1;
        } else {
            System.out.println("Error! List has holes!");
        }
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

    public void printReverse() {
        Node iterator = tail;

        while (iterator != null) {
            System.out.print(iterator.getData());
            iterator = iterator.getPrevious();
        }
    }

    public void insert(City city, int position) {
        if (position < 0 || position > getSize()) {
            System.out.println("Bad position!");
            return;
        }

        if (head == null) {

            // Inserting first element in the list
            head = new Node(city);
            tail = new Node(city);
        } else {
            Node last = head;
            int counter = 0;

            // Go to element after which you want to insert a new one
            while (counter < position - 1) {
                last = last.getNext();
                counter++;
            }

            // Last element will be previous for a new one
            // And next element for last will be next for a new one
            // New element will be next for last
            last.setNext(new Node(city, last, last.getNext()));

            // If there are no elements after last
            // New element becomes the tail of the list
            if (last.getNext().getNext() == null) {
                tail = last.getNext();
            }
        }

        // Change the size of the list
        setSize();
    }

    public Node search(String city) {
        // If list is empty return null
        if (head == null) {
            return null;
        } else {
            Node iterator = head;

            // Go through the list to find the element
            while (iterator != null) {

                // Return if found
                if (iterator.getData().getName().equals(city)) {
                    return iterator;
                }

                iterator = iterator.getNext();
            }

            return null;
        }
    }

    public void delete(String city) {
        if (head == null) {
            return;
        }

        // If head should be removed
        if (head.getData().getName().equals(city)) {

            // Change head to next element
            head = head.getNext();

            // If there was only one element in the list
            // Assign tail to null
            if (head == null) {
                tail = null;
            } else {

                // Head doesn't have previous element
                head.setPrevious(null);
            }
        } else {
            Node iterator = head;
            Node next = head.getNext();

            // Searching for an element
            while (next.getNext() != null) {
                if (next.getData().getName().equals(city)) {

                    // Set next for iterator to next for next
                    // Next for next has previous equals to iterator
                    iterator.setNext(next.getNext());
                    next.getNext().setPrevious(iterator);
                }

                iterator = next;
                next = next.getNext();
            }

            tail = next;
        }

        setSize();
    }
}

