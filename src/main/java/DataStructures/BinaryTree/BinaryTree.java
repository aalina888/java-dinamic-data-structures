package DataStructures.BinaryTree;

import Data.City;

public class BinaryTree {
    private Node head;
    private int size;

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

            // Examine all elements from the tree
            while (head != null) {

                // If city to insert is less
                if (city.compareTo(head.getData()) < 0) {

                    // And there is less element
                    if (head.getLess() != null) {

                        // Go to the element
                        head = head.getLess();
                    } else {

                        // Insert new element
                        head.setLess(new Node(city));
                        size++;
                        return;
                    }
                } else {

                    // If there is more element
                    if (head.getMore() != null) {

                        // Go to the element
                        head = head.getMore();
                    } else {

                        // Insert new element
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
