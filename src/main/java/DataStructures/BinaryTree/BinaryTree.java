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
                } else if (city.equals(iterator.getData().getName())) {

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

    public Node delete(Node root, String city) {
        // If tree is empty
        if (root == null) {
            return null;
        } else if (city.compareTo(root.getData().getName()) < 0) {

            // Search in left subtree (less elements)
            root.setLess(delete(root.getLess(), city));
        } else if (city.compareTo(root.getData().getName()) > 0) {

            // Search in right subtree (more elements)
            root.setMore(delete(root.getMore(), city));
        } else {
            // If element has no children
            if (root.getLess() == null && root.getMore() == null) {

                // Just assign the element to null
                // Ang increment the size of the tree
                root = null;
                size--;
            }
            // One child
            // Assign element to its child
            else if (root.getLess() == null) {
                root = root.getMore();
                size--;
            } else if (root.getMore() == null) {
                root = root.getLess();
                size--;
            }
            // Two children
            else {
                // Assign root to min element
                root.setData(findMin(root.getMore()).getData());
                // Delete min element
                root.setMore(delete(root.getMore(), findMin(root.getMore()).getData().getName()));
            }
        }

        return root;
    }

    private Node findMin(Node root) {
        // Go to less element while it's possible
        while (root.getLess() != null) {
            root = root.getLess();
        }

        return root;
    }
}
