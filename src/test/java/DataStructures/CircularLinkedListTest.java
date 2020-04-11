package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.CircularLinkedList.CircularLinkedList;
import DataStructures.DoublyLinkedList.DoublyLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {
    private CircularLinkedList circularLinkedList;
    private City[] citiesArray;

    @Before
    public void setUp() {
        circularLinkedList = new CircularLinkedList();
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    private void insert() {
        int count = 0;

        for (City cityToInsert : citiesArray) {
            circularLinkedList.insert(cityToInsert, count);
            count++;
        }
    }

    @Test
    public void printTest() {
        circularLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if list from one element is printed
        circularLinkedList.print();

        circularLinkedList.delete("Chisinau");

        // Checking if nothing is printed
        circularLinkedList.print();

        // Inserting All Cities in the list...
        insert();

        // Checking if list is printed
        circularLinkedList.print();
    }

    @Test
    public void insertTest() {
        // Inserting on bad position
        circularLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), -15);

        // Checking if size is still equal to 1
        assertEquals(0, circularLinkedList.getSize());

        // Inserting all cities in the list
        insert();

        // Now there are 51 elements in the list
        assertEquals(50, circularLinkedList.getSize());
    }

    @Test
    public void searchTest() {
        // Inserting all cities in the list
        insert();

        // Searching for cities from the list
        assertNotNull(circularLinkedList.search("Canillo"));
        assertNotNull(circularLinkedList.search("Wien"));
        assertNotNull(circularLinkedList.search("Skopje"));
        assertNotNull(circularLinkedList.search("Kangar"));
        assertNotNull(circularLinkedList.search("Lisboa"));

        // Searching for cities that are not present in the list
        assertNull(circularLinkedList.search("Moscow"));
        assertNull(circularLinkedList.search("Tiraspol"));
    }

    @Test
    public void deleteTest() {
        circularLinkedList.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01), 0);

        // Checking if size is equal to 1
        assertEquals(1, circularLinkedList.getSize());

        circularLinkedList.delete("Chisinau");

        // Checking if size is equal to 1
        assertEquals(0, circularLinkedList.getSize());

        // Inserting all cities in the list
        insert();

        // Deleting cities from the list and checking list's size
        circularLinkedList.delete("Canillo");
        assertEquals(49, circularLinkedList.getSize());

        circularLinkedList.delete("Wien");
        assertEquals(48, circularLinkedList.getSize());

        circularLinkedList.delete("Skopje");
        assertEquals(47, circularLinkedList.getSize());

        // Deleting cities that are not present in the list
        circularLinkedList.delete("Moscow");
        assertEquals(47, circularLinkedList.getSize());

        circularLinkedList.delete("Tiraspol");
        assertEquals(47, circularLinkedList.getSize());
    }
}