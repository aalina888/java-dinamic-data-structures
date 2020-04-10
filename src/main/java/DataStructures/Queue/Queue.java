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
        if (head == null) {
            head = new Node(city);
        } else {
            Node last = head;

            while (last.getNext() != null) {
                last = last.getNext();
            }

            last.setNext(new Node(city));
        }

        // Increment Size of the List
        size++;
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

    public void delete() {
        if (head != null) {
            head = head.getNext();
        }

        // Decrement Size of the List
        size--;
    }
}
