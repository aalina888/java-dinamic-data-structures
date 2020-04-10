package DataStructures.CircularLinkedList;

import Data.City;

// todo
public class CircularLinkedList {
    private Node head;

    public void print() {
        if (head != null) {
            System.out.println(head.getData());
            Node iterator = head.getNext();

            while (!iterator.getData().equals(head.getData())) {
                System.out.print(iterator.getData());
                iterator = iterator.getNext();
            }
        }
    }

    public void printReverse() {
        if (head != null) {
            System.out.println(head.getData());
            Node iterator = head.getNext();

            while (!iterator.getData().equals(head.getData())) {
                System.out.print(iterator.getData());
                iterator = iterator.getPrevious();
            }
        }
    }

    public void insert(City city, int position) {
        if (position < 0 && position > 50) {
            System.out.println("Bad position!");
            return;
        }

        if (head == null) {
            if (position == 0) {
                head = new Node(city, new Node(city), new Node(city));
            } else {
                System.out.println("Bad position!");
            }
        } else {
            Node last = head;
            int counter = 0;

            while (counter < position && !last.getNext().getData().equals(head.getData())) {
                last = last.getNext();
                counter++;
            }

            last.setNext(new Node(city, last, last.getNext()));

            if (last.getNext().getNext() == null) {
                head.setPrevious(last.getNext());
                last.getNext().setNext(head);
            }
        }
    }

    public Node search(String city) {
        if (head == null) {
            return null;
        } else {
            Node iterator = head;

            while (!iterator.getNext().getData().equals(head.getData())) {
                if (iterator.getData().getName().equals(city)) {
                    return iterator;
                }

                iterator = iterator.getNext();
            }

            return null;
        }
    }

    // todo (situation with 1 element)
    public void delete(String city) {
        if (head == null) {
            return;
        }

        if (head.getData().getName().equals(city)) {
            if (head.getData().equals(head.getNext().getData())) {
                head.setPrevious(null);
                head.setNext(null);
                head = null;
            } else {
                head = head.getNext();
                head.setPrevious(null);
            }
        } else {
            Node iterator = head;
            Node next = head.getNext();

            while (!next.getNext().getData().equals(head.getData())) {
                if (next.getData().getName().equals(city)) {
                    iterator.setNext(next.getNext());
                    next.getNext().setPrevious(iterator);
                }

                iterator = next;
                next = next.getNext();
            }

            if (next.getData().getName().equals(city)) {
                iterator.setNext(null);
                head.setPrevious(iterator);
            }
        }
    }
}
