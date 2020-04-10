package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.Queue.Queue;

public class QueueTest {
    public static void main(String[] args) {
        City[] citiesArray = JSONFileGenerator.createCitiesArray();

        Queue queue = new Queue();

        System.out.println("Inserting a City in new Queue...");
        queue.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));

        System.out.println("Checking the Result...");
        queue.print();

        System.out.println("Deleting the city...");
        queue.delete();

        System.out.println("Inserting All Cities in the Queue...");
        for (City cityToInsert : citiesArray) {
            queue.insert(cityToInsert);
        }

        System.out.println("\nPrinting the Queue:");
        queue.print();

        System.out.println("Deleting First City...");
        queue.delete();

        System.out.println("Checking the Result...");
        queue.print();

        System.out.println("Searching for Canillo...");
        System.out.println(queue.search("Canillo"));

        System.out.println("Searching for Washington...");
        System.out.println(queue.search("Washington").getData());

        System.out.println("Searching for Moscow...");
        System.out.println(queue.search("Moscow"));

        System.out.println("Searching for Chicago...");
        System.out.println(queue.search("Chicago").getData());

        System.out.println("Searching for Lisboa...");
        System.out.println(queue.search("Lisboa").getData());
    }
}
