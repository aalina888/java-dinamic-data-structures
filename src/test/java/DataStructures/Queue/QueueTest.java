package DataStructures.Queue;

import Data.City;
import Data.JSONFileGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;
    private City[] citiesArray;

    @Before
    public void setUp() {
        queue = new Queue();
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    @Test
    public void printTest() {
        queue.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));

        // Checking if Queue from one element is printed
        queue.print();

        queue.delete();

        // Checking if nothing is printed
        queue.print();

        System.out.println("Inserting All Cities in the Queue...");
        for (City cityToInsert : citiesArray) {
            queue.insert(cityToInsert);
        }

        // Checking if the Queue is printed
        queue.print();
    }

    @Test
    public void insertTest() {
        queue.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));
        queue.setSize();

        assertEquals(1, queue.getSize());

        // Inserting all cities in the Queue
        for (City cityToInsert : citiesArray) {
            queue.insert(cityToInsert);
        }
        assertEquals(51, queue.getSize());
    }

    @Test
    public void searchTest() {
        // Inserting all cities in the Queue
        for (City cityToInsert : citiesArray) {
            queue.insert(cityToInsert);
        }

        // Searching for cities from the Queue
        assertNotNull(queue.search("Canillo"));
        assertNotNull(queue.search("Wien"));
        assertNotNull(queue.search("Skopje"));
        assertNotNull(queue.search("Kangar"));
        assertNotNull(queue.search("Lisboa"));

        // Searching for cities that are not present in the Queue
        assertNull(queue.search("Moscow"));
        assertNull(queue.search("Tiraspol"));
    }

    @Test
    public void deleteTest() {
        queue.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));

        // Checking if size is equal to 1
        assertEquals(1, queue.getSize());

        queue.delete();

        // Checking if size is equal to 1
        assertEquals(0, queue.getSize());

        // Inserting all cities in the Linked List
        for (City cityToInsert : citiesArray) {
            queue.insert(cityToInsert);
        }

        // Deleting cities from the Linked List and checking list's size
        queue.delete();

        assertEquals(49, queue.getSize());

        queue.delete();

        assertEquals(48, queue.getSize());

        queue.delete();

        assertEquals(47, queue.getSize());
    }
}