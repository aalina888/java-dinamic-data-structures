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

        binaryTree.printInorder();
    }

    @Test
    public void printPreorderTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        binaryTree.printPreorder();
    }

    @Test
    public void printPostorderTest() {
        for (City cityToInsert : citiesArray) {
            binaryTree.insert(cityToInsert);
        }

        binaryTree.printPostorder();

    }

    @Test
    public void searchTest() {
    }

    @Test
    public void deleteTest() {
    }
}