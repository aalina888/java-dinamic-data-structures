package DataStructures.CircularLinkedList;

import Data.City;

public class CircularLinkedList {
    private Node head;
    private int size;

    public void setSize() {
        Node iterator;
        int count = 0;

        // If list is not empty
        // Count head and go to next element
        if (head != null) {
            iterator = head.getNext();
            count++;
        } else {
            size = 0;
            return;
        }

        // While elements are not the same as head
        // Count them
        while (!iterator.getData().equals(head.getData())) {
            count++;
            iterator = iterator.getNext();
        }

        size = count;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        if (head != null) {
            System.out.print(head.getData());
            Node iterator = head.getNext();

            while (!iterator.getData().equals(head.getData())) {
                System.out.print(iterator.getData());
                iterator = iterator.getNext();
            }
        }
    }

    public void insert(City city, int position) {
        if (position < 0 || position > getSize()) {
            System.out.println("Bad position!");
            return;
        }

        // If list is empty
        if (head == null) {

            // Assign new element to head
            head = new Node(city, new Node(city));
        } else {
            Node last = head;
            int counter = 0;

            while (counter < position - 1) {
                last = last.getNext();
                counter++;
            }

            // If there are more than 1 element in the list
            if (!last.getNext().getData().equals(head.getData())) {
                last.setNext(new Node(city, last.getNext()));
            } else {
                last.setNext(new Node(city, head));
            }
        }

        setSize();
    }

    public Node search(String city) {
        if (head == null) {
            return null;
        } else {
            if (city.equals(head.getData().getName())) {
                return head;
            }
            Node iterator = head.getNext();

            while (!iterator.getData().equals(head.getData())) {
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

            // And there are at least 2 elements in the list
            if (!head.getNext().getData().equals(head.getData())) {

                // Go to the element before head
                while (!head.getNext().getData().getName().equals(city)){
                    head = head.getNext();
                }

                head.setNext(head.getNext().getNext());
            } else {
                head = null;
            }
        } else {
            Node iterator = head;
            Node next = head.getNext();

            // Searching for an element
            while (!next.getData().equals(head.getData())) {
                if (next.getData().getName().equals(city)) {
                    iterator.setNext(next.getNext());
                }

                iterator = next;
                next = next.getNext();
            }
        }

        setSize();
    }
}
