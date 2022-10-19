package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> binarySearchTree;
    private int size;

    @BeforeEach
    void setup() {
        binarySearchTree = new BinarySearchTree<>();
        size = 15;
    }

    @AfterEach
    void tearDown() {
        binarySearchTree=null;
        size=0;
    }

    @Test
    void isRootNull() {
        assertNull(binarySearchTree.getRoot());
    }

    @Test
    void insertIntoEmptyRoot() {
        binarySearchTree.insert(5);
        assertEquals(binarySearchTree.getRoot().getElement(), 5);

    }

    @Test
    void containsWorksOnComplexTrees() {
        setupComplexBinarySearchTree();
        assertTrue(binarySearchTree.contains(2));
    }

    @Test
    void testIfRemoveWorksWhenExists() {

        setupComplexBinarySearchTree();

        assertEquals(binarySearchTree, binarySearchTree.size());
        boolean doesExist = binarySearchTree.removeElement(size);

        assertTrue(doesExist);

        // Need to not contain the last element
        assertFalse(binarySearchTree.contains(size));
        // Need one less element
        assertEquals(size-1, binarySearchTree.size());
    }

    @Test
    void testIfRemoveWorksWhenRemovingTheRoot() {

        setupComplexBinarySearchTree();
        assertEquals(size, binarySearchTree.size());

        Integer root = (Integer) binarySearchTree.getRoot().getElement();
        boolean doesExist = binarySearchTree.removeElement(root);

        assertTrue(doesExist);

        // Need to not contain the last element
        assertFalse(binarySearchTree.contains(root));
        // Need one less element
        assertEquals(size-1, binarySearchTree.size());



    }
    @Test
    void testIfRemoveWorksWhenDoesNotExists() {

        setupComplexBinarySearchTree();

        assertEquals(15, binarySearchTree.size());
        boolean doesExist = binarySearchTree.removeElement(size+1);

        assertFalse(doesExist);
        //Sizw doesnt change
        assertEquals(size, binarySearchTree.size());
        // Need to not contain 11
        assertFalse(binarySearchTree.contains(size+1));


    }

    @Test
    void testFindMin(){
        setupComplexBinarySearchTree();
        assertEquals(1, binarySearchTree.findMin());
    }

    @Test
    void testFindMax(){
        setupComplexBinarySearchTree();
        // Since, size is the max item
        assertEquals(size, binarySearchTree.findMax());
    }

    @Test
    void testRebalance(){
        setupComplexBinarySearchTree();
        Integer[] correctPreOrderAtBalance  ={8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        ArrayList<Integer> expectedPreOrder = new ArrayList<>(List.of(correctPreOrderAtBalance));

        binarySearchTree.reBalance();

        assertEquals(expectedPreOrder, binarySearchTree.preOrder());

    }



    private void setupComplexBinarySearchTree() {
        for (int i = 1; i <= size; i++) {
            binarySearchTree.insert(i);
        }
    }
}