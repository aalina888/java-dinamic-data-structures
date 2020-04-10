package DataStructures.DoublyLinkedList;

import Data.City;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

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
        if (position < 0 || position > 50) {
            System.out.println("Bad position!");
            return;
        }

        if (head == null) {
            if (position == 0) {
                head = new Node(city);
                tail = new Node(city);
            } else {
                System.out.println("Bad position!");
                return;
            }
        } else {
            Node last = head;
            int counter = 0;

            while (counter < position && last.getNext() != null) {
                last = last.getNext();
                counter++;
            }

            last.setNext(new Node(city, last, last.getNext()));

            if (last.getNext().getNext() == null) {
                tail = last.getNext();
            }
        }
    }

    public Node search(String city) {
        if (head == null) {
            return null;
        } else {
            Node iterator = head;

            while (iterator != null) {
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

        if (head.getData().getName().equals(city)) {
            head = null;
        } else {
            Node iterator = head;
            Node next = head.getNext();

            while (next.getNext() != null) {
                if (next.getData().getName().equals(city)) {
                    iterator.setNext(next.getNext());
                    next.getNext().setPrevious(iterator);
                }

                iterator = next;
                next = next.getNext();
            }

            if (next.getData().getName().equals(city)) {
                iterator.setNext(null);
                tail = iterator;
            }
        }
    }
}

