package DataStructures;

import Data.City;
import Data.JSONFileGenerator;
import DataStructures.BinaryTree.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    private BinaryTree binaryTree;
    private City[] citiesArray;

    @Before
    public void setUp(){
        binaryTree = new BinaryTree();
        citiesArray = JSONFileGenerator.createCitiesArray();
    }

    @Test
    public void insertTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        assertEquals(50, binaryTree.getSize());
    }

    @Test
    public void printInorderTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        binaryTree.printInorder(binaryTree.getHead());
    }

    @Test
    public void printPreorderTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        binaryTree.printPreorder(binaryTree.getHead());
    }

    @Test
    public void printPostorderTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        binaryTree.printPostorder(binaryTree.getHead());
    }

    @Test
    public void searchTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        // Searching for cities from the list
        assertNotNull(binaryTree.search("Canillo"));
        assertNotNull(binaryTree.search("Wien"));
        assertNotNull(binaryTree.search("Skopje"));
        assertNotNull(binaryTree.search("Kangar"));
        assertNotNull(binaryTree.search("Lisboa"));

        // Searching for cities that are not present in the list
        assertNull(binaryTree.search("Moscow"));
        assertNull(binaryTree.search("Tiraspol"));
    }

    @Test
    public void deleteTest() {
    }
}