package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.LinkedList.LinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList linkedList;
    private City[] citiesArray;

    @Before
    public void setUp() {
        linkedList = new LinkedList();
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    private void insert() {
        int count = 0;

        for (City cityToInsert : citiesArray) {
            linkedList.insert(cityToInsert, count);
            count++;
        }
    }

    @Test
    public void setSizeTest() {
        linkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if size is equal to 1
        assertEquals(1, linkedList.getSize());

        linkedList.delete("Chisinau");

        // Checking if list is empty
        assertEquals(0, linkedList.getSize());

        // Inserting All Cities in the Linked List
        insert();

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

        // Inserting All Cities in the Linked List
        insert();

        // Checking if list is printed
        linkedList.print();
    }

    @Test
    public void insertTest() {
        City chisinau = new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01);
        // Inserting on the 0 position
        linkedList.insert(chisinau, 0);

        // Checking if size is equal to 1
        assertEquals(1, linkedList.getSize());

        // Inserting on bad position
        linkedList.insert(chisinau, -15);

        // Checking if size is still equal to 1
        assertEquals(1, linkedList.getSize());

        // Inserting all cities in the Linked List
        insert();

        // Now there are 51 elements in the list
        assertEquals(51, linkedList.getSize());
    }

    @Test
    public void searchTest() {
        // Inserting all cities in the Linked List
        insert();

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

        // Checking if size is equal to 1
        assertEquals(1, linkedList.getSize());

        linkedList.delete("Chisinau");

        // Checking if size is equal to 1
        assertEquals(0, linkedList.getSize());

        // Inserting all cities in the Linked List
        insert();

        // Deleting cities from the Linked List and checking list's size
        linkedList.delete("Canillo");
        assertEquals(49, linkedList.getSize());

        linkedList.delete("Wien");
        assertEquals(48, linkedList.getSize());

        linkedList.delete("Skopje");
        assertEquals(47, linkedList.getSize());

        // Deleting cities that are not present in the Linked List
        linkedList.delete("Moscow");
        assertEquals(47, linkedList.getSize());

        linkedList.delete("Tiraspol");
        assertEquals(47, linkedList.getSize());
    }
}