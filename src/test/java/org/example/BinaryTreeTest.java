package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

class BinaryTreeTest {
    BinaryTree<Integer> binaryTree;

    private void setTemporaryTree(){
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2= new BinaryTreeNode(10);
        BinaryTreeNode node3= new BinaryTreeNode(11);
        BinaryTreeNode node4 = new BinaryTreeNode(99);
        BinaryTreeNode node5 = new BinaryTreeNode(65464);
        BinaryTreeNode node6 = new BinaryTreeNode(5555);
        BinaryTreeNode node7= new BinaryTreeNode(3166);
        BinaryTreeNode node8= new BinaryTreeNode(450);
        BinaryTreeNode node9= new BinaryTreeNode(85);
        BinaryTreeNode node10= new BinaryTreeNode(71);
        BinaryTreeNode node11= new BinaryTreeNode(152);
        BinaryTreeNode node12= new BinaryTreeNode(10);

        node.addLeftChild(node1);
        node.addRightChild(node2);
        node1.addRightChild(node3);
        node1.addLeftChild(node4);
        node2.addLeftChild(node5);
        node5.addLeftChild(node6);
        node6.addRightChild(node7);
        node4.addRightChild(node8);
        node5.addRightChild(node9);
        node9.addRightChild(node10);
        node9.addLeftChild(node11);
        node10.addRightChild(node12);
        binaryTree.setRoot(node);
    }

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>();

    }

    @AfterEach
    void tearDown() {
        binaryTree=null;
    }

    @Test
    void rootNull()
    {
        assertNull(binaryTree.getRoot());
    }

    @Test
    void setAndGetRoot()
    {
        binaryTree.setRoot(new BinaryTreeNode<>(10));
        assertEquals(10, binaryTree.getRoot().getElement());
    }

    @Test
    void isEmptyTreeTest() {
        assertTrue(binaryTree.isEmpty());
    }


    @Test
    void isNOTEmptyTreeTest() {
        binaryTree.setRoot(new BinaryTreeNode<>(10));
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void treeContainsTheObjectInRoot()
    {
        binaryTree.setRoot(new BinaryTreeNode<>(10));
        assertTrue(binaryTree.contains(10));
    }

    @Test
    void containsTrueWhenLeftChildContainsTheValue() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(15);
        node1.addLeftChild(childNode);
        binaryTree.setRoot(node1);

        assertTrue(binaryTree.contains(15));

    }

    @Test
    void containsTrueWhenRightChildContainsTheValue() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(15);
        node1.addRightChild(childNode);
        binaryTree.setRoot(node1);

        assertTrue(binaryTree.contains(15));

    }

    @Test
    void constainsTheValueInTheChild(){

        setTemporaryTree();
        assertTrue(binaryTree.contains(5555));
    }

    @Test
    void testInOrder() {
        setTemporaryTree();
        ArrayList<Integer> inOrderArray = new ArrayList<>(Arrays.asList(99, 450, 2, 11, 1, 5555, 3166, 65464, 152, 85, 71, 10, 10));
        assertEquals(inOrderArray, binaryTree.inOrder());
    }

    @Test
    void testInCorrectInOrder() {
        setTemporaryTree();
        ArrayList<Integer> inOrderArray = new ArrayList<>(Arrays.asList(99, 450, 2, 11, 1, 5555, 3166, 65464, 152, 85, 71, 10, 10));
        assertEquals(inOrderArray, binaryTree.inOrder());
    }

    @Test
    void testPreOrder() {
        setTemporaryTree();
        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(1, 2, 99, 450, 11, 10, 65464, 5555, 3166, 85, 152, 71, 10));
        assertEquals(preOrder, binaryTree.preOrder());
    }

    @Test
    void testInCorrectPreOrder() {
        setTemporaryTree();
        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(10, 15, 21, 40, 11, 5, 27, 1, 31, 8, 152, 7, 311));
        assertNotEquals(preOrder, binaryTree.preOrder());
    }

    @Test
    void testPostOrder() {
        setTemporaryTree();
        ArrayList<Integer> postOrder = new ArrayList<>(Arrays.asList(1, 2, 99, 450, 11, 10, 65464, 5555, 3166, 85, 152, 71, 10));
        assertEquals(postOrder, binaryTree.postOrder());
    }

    @Test
    void testLevelOrder() {
        setTemporaryTree();
        ArrayList<Integer> levelOrder = new ArrayList<>(Arrays.asList(1, 2, 10, 99, 11, 65464, 450, 5555, 85, 3166, 152, 71, 10));
        assertEquals(levelOrder, binaryTree.levelOrder());
    }
}