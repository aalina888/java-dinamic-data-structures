package DataStructures.BinaryTree;

import Data.City;

public class BinaryTree {
    private Node head;
    private int size;

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void insert(City city) {
        // If tree is empty
        if (head == null) {

            // Create head
            head = new Node(city);
            size++;
        } else {
            Node iterator = head;

            // Examine all elements from the tree
            while (iterator != null) {

                // If city to insert is less
                if (city.compareTo(iterator.getData()) < 0) {

                    // And there is less element
                    if (iterator.getLess() != null) {

                        // Go to the element
                        iterator = iterator.getLess();
                    } else {

                        // Insert new element
                        iterator.setLess(new Node(city));
                        size++;
                        return;
                    }
                } else {

                    // If there is more element
                    if (iterator.getMore() != null) {

                        // Go to the element
                        iterator = iterator.getMore();
                    } else {

                        // Insert new element
                        iterator.setMore(new Node(city));
                        size++;
                        return;
                    }
                }
            }
        }
    }

    public void printInorder(Node head) {
        // Stop when there are no elements in the tree
        if (head == null) {
            return;
        }

        // Go to left subtree
        printInorder(head.getLess());

        // Print root
        System.out.print(head.getData());

        // Go to right subtree
        printInorder(head.getMore());
    }

    public void printPreorder(Node head) {
        // Stop when there are no elements in the tree
        if (head == null) {
            return;
        }

        // Print root
        System.out.print(head.getData());

        // Go to left subtree
        printPreorder(head.getLess());

        // Go to right subtree
        printPreorder(head.getMore());

    }

    public void printPostorder(Node head) {
        // Stop when there are no elements in the tree
        if (head == null) {
            return;
        }

        // Go to left subtree
        printPostorder(head.getLess());

        // Go to right subtree
        printPostorder(head.getMore());

        // Print root
        System.out.print(head.getData());
    }

    public Node search(String city) {
        // If tree is empty
        if (head == null) {

            return null;
        } else {
            Node iterator = head;

            // Examine all elements from the tree
            while (iterator != null) {

                // If city to find is less
                if (city.compareTo(iterator.getData().getName()) < 0) {

                    // And there is less element
                    if (iterator.getLess() != null) {

                        // Go to the element
                        iterator = iterator.getLess();
                    } else {

                        // There is no such element in the tree
                        return null;
                    }
                } else if (city.equals(iterator.getData().getName())){

                    // Element was found
                    return iterator;
                } else {

                    // And there is more element
                    if (iterator.getMore() != null) {

                        // Go to the element
                        iterator = iterator.getMore();
                    } else {

                        // There is no such element in the tree
                        return null;
                    }
                }
            }
        }

        return null;
    }

    public void delete() {

    }
}
