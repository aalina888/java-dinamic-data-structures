package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.DoublyLinkedList.DoublyLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList doublyLinkedList;
    private City[] citiesArray;

    @Before
    public void setUp() {
        doublyLinkedList = new DoublyLinkedList();
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    @Test
    public void printTest() {
        doublyLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if list from one element is printed
        doublyLinkedList.print();

        doublyLinkedList.delete("Chisinau");

        // Checking if nothing is printed
        doublyLinkedList.print();

        System.out.println("Inserting All Cities in the Linked List...");
        int count = 0;
        for (City cityToInsert : citiesArray) {
            doublyLinkedList.insert(cityToInsert, count);
            count++;
        }

        // Checking if list is printed
        doublyLinkedList.print();
    }

    @Test
    public void printReverseTest() {
        doublyLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if list from one element is printed
        doublyLinkedList.printReverse();

        doublyLinkedList.delete("Chisinau");

        // Checking if nothing is printed
        doublyLinkedList.print();

        System.out.println("Inserting All Cities in the Linked List...");
        int count = 0;
        for (City cityToInsert : citiesArray) {
            doublyLinkedList.insert(cityToInsert, count);
            count++;
        }

        // Checking if list is printed in reverse order
        doublyLinkedList.printReverse();
    }

    @Test
    public void insertTest() {
        City chisinau = new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01);
        // Inserting on the 0 position
        doublyLinkedList.insert(chisinau, 0);

        // Checking if size is equal to 1
        assertEquals(1, doublyLinkedList.getSize());

        // Inserting on bad position
        doublyLinkedList.insert(chisinau, -15);

        // Checking if size is still equal to 1
        assertEquals(1, doublyLinkedList.getSize());

        // Inserting all cities in the Linked List
        int count = 0;
        for (City cityToInsert : citiesArray) {
            doublyLinkedList.insert(cityToInsert, count + 1);
            count++;
        }

        // Now there are 51 elements in the list
        assertEquals(51, doublyLinkedList.getSize());
    }

    @Test
    public void searchTest() {
        // Inserting all cities in the Linked List
        int count = 0;
        for (City cityToInsert : citiesArray) {
            doublyLinkedList.insert(cityToInsert, count);
            count++;
        }

        // Searching for cities from the Linked List
        assertNotNull(doublyLinkedList.search("Canillo"));
        assertNotNull(doublyLinkedList.search("Wien"));
        assertNotNull(doublyLinkedList.search("Skopje"));
        assertNotNull(doublyLinkedList.search("Kangar"));
        assertNotNull(doublyLinkedList.search("Lisboa"));

        // Searching for cities that are not present in the Linked List
        assertNull(doublyLinkedList.search("Moscow"));
        assertNull(doublyLinkedList.search("Tiraspol"));
    }

    @Test
    public void deleteTest() {
        doublyLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if size is equal to 1
        assertEquals(1, doublyLinkedList.getSize());

        doublyLinkedList.delete("Chisinau");

        // Checking if size is equal to 1
        assertEquals(0, doublyLinkedList.getSize());

        // Inserting all cities in the Linked List
        int count = 0;
        for (City cityToInsert : citiesArray) {
            doublyLinkedList.insert(cityToInsert, count);
            count++;
        }

        // Deleting cities from the Linked List and checking list's size
        doublyLinkedList.delete("Canillo");

        assertEquals(49, doublyLinkedList.getSize());

        doublyLinkedList.delete("Wien");

        assertEquals(48, doublyLinkedList.getSize());

        doublyLinkedList.delete("Skopje");

        assertEquals(47, doublyLinkedList.getSize());

        // Deleting cities that are not present in the Linked List
        doublyLinkedList.delete("Moscow");

        assertEquals(47, doublyLinkedList.getSize());

        doublyLinkedList.delete("Tiraspol");

        assertEquals(47, doublyLinkedList.getSize());
    }
}