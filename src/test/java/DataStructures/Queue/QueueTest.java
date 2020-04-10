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
    }

    @Test
    public void insertTest() {
        queue.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));
        queue.setSize();

        assertEquals(1, queue.getSize());

    }

    @Test
    public void searchTest() {
    }

    @Test
    public void deleteTest() {
    }
}