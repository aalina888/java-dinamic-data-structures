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

    private void insert() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }
    }

    @Test
    public void insertTest() {
        insert();

        assertEquals(50, binaryTree.getSize());
    }

    @Test
    public void printInorderTest() {
        insert();

        binaryTree.printInorder(binaryTree.getHead());
    }

    @Test
    public void printPreorderTest() {
        insert();

        binaryTree.printPreorder(binaryTree.getHead());
    }

    @Test
    public void printPostorderTest() {
        insert();

        binaryTree.printPostorder(binaryTree.getHead());
    }

    @Test
    public void searchTest() {
        insert();

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
        insert();

        assertEquals(50, binaryTree.getSize());

        // Deleting cities from the tree
        binaryTree.delete(binaryTree.getHead(), "Canillo");
        assertEquals(49, binaryTree.getSize());

        binaryTree.delete(binaryTree.getHead(), "Skopje");
        assertEquals(48, binaryTree.getSize());

        binaryTree.delete(binaryTree.getHead(), "Lisboa");
        assertEquals(47, binaryTree.getSize());

        // Deleting cities that doesn't exist in the tree
        binaryTree.delete(binaryTree.getHead(), "Moscow");
        assertEquals(47, binaryTree.getSize());

        binaryTree.delete(binaryTree.getHead(), "Tiraspol");
        assertEquals(47, binaryTree.getSize());
    }
}