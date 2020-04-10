package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.LinkedList.LinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedList linkedList = new LinkedList();
    private City[] citiesArray;

    @Before
    public void setUp() {
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    @Test
    public void setSizeTest() {
        linkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);
        linkedList.setSize();

        // Checking if size is equal to 1
        assertEquals(1, linkedList.getSize());

        linkedList.delete("Chisinau");
        linkedList.setSize();

        // Checking if list is empty
        assertEquals(0, linkedList.getSize());

        System.out.println("Inserting All Cities in the Linked List...");
        int count = 0;
        for (City cityToInsert : citiesArray) {
            linkedList.insert(cityToInsert, count);
            count++;
        }
        linkedList.setSize();

        // Checking if size is equal to 50
        assertEquals(50, linkedList.getSize());
    }

    @Test
    public void printTest() {
        linkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if list from one element is printed
        linkedList.print();

        linkedList.delete("Chisinau");

        // Checking if nothing is printed
        linkedList.print();

        System.out.println("Inserting All Cities in the Linked List...");
        int count = 0;
        for (City cityToInsert : citiesArray) {
            linkedList.insert(cityToInsert, count);
            count++;
        }

        // Checking if list is printed
        linkedList.print();
    }

    @Test
    public void insertTest() {
        City chisinau = new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01);
        // Inserting on the 0 position
        linkedList.insert(chisinau, 0);
        linkedList.setSize();

        // Checking if size is equal to 1
        assertEquals(1, linkedList.getSize());

        // Inserting on bad position
        linkedList.insert(chisinau, -15);

        // Checking if size is still equal to 1
        assertEquals(1, linkedList.getSize());

        // Inserting all cities in the Linked List
        int count = 0;
        for (City cityToInsert : citiesArray) {
            linkedList.insert(cityToInsert, count);
            count++;
        }
        linkedList.setSize();

        // Now there are 51 elements in the list
        assertEquals(51, linkedList.getSize());
    }

    @Test
    public void searchTest() {
        // Inserting all cities in the Linked List
        int count = 0;
        for (City cityToInsert : citiesArray) {
            linkedList.insert(cityToInsert, count);
            count++;
        }

        // Searching for cities from the Linked List
        assertNotNull(linkedList.search("Canillo"));
        assertNotNull(linkedList.search("Wien"));
        assertNotNull(linkedList.search("Skopje"));
        assertNotNull(linkedList.search("Kangar"));
        assertNotNull(linkedList.search("Lisboa"));

        // Searching for cities that are not present in the Linked List
        assertNull(linkedList.search("Moscow"));
        assertNull(linkedList.search("Tiraspol"));
    }

    @Test
    public void deleteTest() {
        linkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);
        linkedList.setSize();

        // Checking if size is equal to 1
        assertEquals(1, linkedList.getSize());

        linkedList.delete("Chisinau");
        linkedList.setSize();

        // Checking if size is equal to 1
        assertEquals(0, linkedList.getSize());

        // Inserting all cities in the Linked List
        int count = 0;
        for (City cityToInsert : citiesArray) {
            linkedList.insert(cityToInsert, count);
            count++;
        }

        // Deleting cities from the Linked List and checking list's size
        linkedList.delete("Canillo");
        linkedList.setSize();

        assertEquals(49, linkedList.getSize());

        linkedList.delete("Wien");
        linkedList.setSize();

        assertEquals(48, linkedList.getSize());

        linkedList.delete("Skopje");
        linkedList.setSize();

        assertEquals(47, linkedList.getSize());

        // Deleting cities that are not present in the Linked List
        linkedList.delete("Moscow");
        linkedList.setSize();

        assertEquals(47, linkedList.getSize());

        linkedList.delete("Tiraspol");
        linkedList.setSize();

        assertEquals(47, linkedList.getSize());
    }
}