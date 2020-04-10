package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.Queue.Queue;
import DataStructures.Stack.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;
    private City[] citiesArray;

    @Before
    public void setUp() {
        stack = new Stack();
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    @Test
    public void printTest() {
        stack.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));

        // Checking if Stack from one element is printed
        stack.print();

        stack.delete();

        // Checking if nothing is printed
        stack.print();

        System.out.println("Inserting All Cities in the Stack...");
        for (City cityToInsert : citiesArray) {
            stack.insert(cityToInsert);
        }

        // Checking if the Queue is printed
        stack.print();
    }

    @Test
    public void insertTest() {
        stack.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));
        stack.setSize();

        assertEquals(1, stack.getSize());

        // Inserting all cities in the Stack
        for (City cityToInsert : citiesArray) {
            stack.insert(cityToInsert);
        }
        assertEquals(51, stack.getSize());
    }

    @Test
    public void searchTest() {
        // Inserting all cities in the Stack
        for (City cityToInsert : citiesArray) {
            stack.insert(cityToInsert);
        }

        // Searching for cities from the Stack
        assertNotNull(stack.search("Canillo"));
        assertNotNull(stack.search("Wien"));
        assertNotNull(stack.search("Skopje"));
        assertNotNull(stack.search("Kangar"));
        assertNotNull(stack.search("Lisboa"));

        // Searching for cities that are not present in the Stack
        assertNull(stack.search("Moscow"));
        assertNull(stack.search("Tiraspol"));
    }

    @Test
    public void deleteTest() {
        stack.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));

        // Checking if size is equal to 1
        assertEquals(1, stack.getSize());

        stack.delete();

        // Checking if size is equal to 1
        assertEquals(0, stack.getSize());

        // Inserting all cities in the Stack
        for (City cityToInsert : citiesArray) {
            stack.insert(cityToInsert);
        }

        // Deleting cities from the Stack
        stack.delete();

        assertEquals(49, stack.getSize());

        stack.delete();

        assertEquals(48, stack.getSize());

        stack.delete();

        assertEquals(47, stack.getSize());
    }
}