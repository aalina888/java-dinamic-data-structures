package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.DoublyLinkedList.DoublyLinkedList;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        City[] citiesArray = JSONFileGenerator.createCitiesArray();

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        System.out.println("Inserting a City in new Doubly Linked List...");
        doublyLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        System.out.println("Checking the Result...");
        doublyLinkedList.print();

        System.out.println("Deleting the city...");
        doublyLinkedList.delete("Chisinau");

        System.out.println("Inserting All Cities in the Doubly Linked List...");
        for(int i = 0; i < citiesArray.length; i++) {
            doublyLinkedList.insert(citiesArray[i], i);
        }

        System.out.println("\nPrinting the Doubly Linked List:");
        doublyLinkedList.print();

        System.out.println("Printing in Reverse Order...");
        doublyLinkedList.printReverse();

        System.out.println("Deleting Last City...");
        doublyLinkedList.delete(citiesArray[49].getName());

        System.out.println("Checking the Result...");
        doublyLinkedList.print();

        System.out.println("Searching for Canillo...");
        System.out.println(doublyLinkedList.search("Canillo").getData());

        System.out.println("Searching for Moscow...");
        System.out.println(doublyLinkedList.search("Moscow"));

        System.out.println("Searching for Chicago...");
        System.out.println(doublyLinkedList.search("Chicago").getData());

        System.out.println("Searching for Woodhill...");
        System.out.println(doublyLinkedList.search("Woodhill").getData());

        System.out.println("Inserting new City on position 4...");
        doublyLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 4);

        System.out.println("Checking the Results...");
        doublyLinkedList.print();

        System.out.println("Printing in Reverse Order...");
        doublyLinkedList.printReverse();
    }
}
