package DataStructures.BinaryTree;

import Data.City;

public class BinaryTree {
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public void insert(City city) {
        if (head == null) {
            head = new Node(city);
            size++;
        } else {
            while (head != null) {
                if (city.compareTo(head.getData()) < 0) {
                    if (head.getLess() != null) {
                        head = head.getLess();
                    } else {
                        head.setLess(new Node(city));
                        size++;
                        return;
                    }
                } else {
                    if (head.getMore() != null) {
                        head = head.getMore();
                    } else {
                        head.setMore(new Node(city));
                        size++;
                        return;
                    }
                }
            }
        }
    }

    public void printInorder() {

    }

    public void printPreorder() {

    }

    public void printPostorder() {

    }

    public void search() {

    }

    public void delete() {

    }
}
