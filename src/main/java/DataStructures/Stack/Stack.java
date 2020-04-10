package DataStructures.Stack;

import Data.City;

public class Stack {
    private Node head;

    public void print() {
        Node iterator = head;

        while (iterator != null) {
            System.out.print(iterator.getData());
            iterator = iterator.getPrevious();
        }
    }

    public void insert(City city) {
        if (head == null) {
            head = new Node(city);
        } else {
            head = new Node(city, head);
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

                iterator = iterator.getPrevious();
            }

            return null;
        }
    }

    public void delete() {
        if (head != null) {
            head = head.getPrevious();
        }
    }
}
