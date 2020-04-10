package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.Stack.Stack;

public class StackTest {
    public static void main(String[] args) {
        City[] citiesArray = JSONFileGenerator.createCitiesArray();

        Stack stack = new Stack();

        System.out.println("Inserting a City in new Stack...");
        stack.insert(new City("Chisinau", "Moldova", "MD2000", 28.86, 47.01));

        System.out.println("Checking the Result...");
        stack.print();

        System.out.println("Deleting the city...");
        stack.delete();

        System.out.println("Inserting All Cities in the Stack...");
        for (City cityToInsert : citiesArray) {
            stack.insert(cityToInsert);
        }

        System.out.println("\nPrinting the Stack:");
        stack.print();

        System.out.println("Deleting First City...");
        stack.delete();

        System.out.println("Checking the Result...");
        stack.print();

        System.out.println("Searching for Canillo...");
        System.out.println(stack.search("Canillo").getData());

        System.out.println("Searching for Washington...");
        System.out.println(stack.search("Washington").getData());

        System.out.println("Searching for Moscow...");
        System.out.println(stack.search("Moscow"));

        System.out.println("Searching for Woodhill...");
        System.out.println(stack.search("Woodhill").getData());

        System.out.println("Searching for Lisboa...");
        System.out.println(stack.search("Lisboa"));
    }
}
