package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.CircularLinkedList.CircularLinkedList;

public class CircularLinkedListTest {
    public static void main(String[] args) {
        City[] citiesArray = JSONFileGenerator.createCitiesArray();

        CircularLinkedList circularLinkedList = new CircularLinkedList();

        System.out.println("Inserting a City in new Circular Linked List...");
        circularLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        System.out.println("Checking the Result...");
        circularLinkedList.print();

        System.out.println("Deleting the city...");
        circularLinkedList.delete("Chisinau");

        System.out.println("Inserting All Cities in the Circular Linked List...");
        for(int i = 0; i < citiesArray.length; i++) {
            circularLinkedList.insert(citiesArray[i], i);
        }

        System.out.println("\nPrinting the Circular Linked List:");
        circularLinkedList.print();

        System.out.println("Printing in Reverse Order...");
        circularLinkedList.printReverse();

        System.out.println("Deleting Last City...");
        circularLinkedList.delete(citiesArray[49].getName());

        System.out.println("Checking the Result...");
        circularLinkedList.print();

        System.out.println("Searching for Canillo...");
        System.out.println(circularLinkedList.search("Canillo").getData());

        System.out.println("Searching for Moscow...");
        System.out.println(circularLinkedList.search("Moscow"));

        System.out.println("Searching for Chicago...");
        System.out.println(circularLinkedList.search("Chicago").getData());

        System.out.println("Searching for Woodhill...");
        System.out.println(circularLinkedList.search("Woodhill").getData());

        System.out.println("Inserting new City on position 4...");
        circularLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 4);

        System.out.println("Checking the Results...");
        circularLinkedList.print();

        System.out.println("Printing in Reverse Order...");
        circularLinkedList.printReverse();
    }
}
