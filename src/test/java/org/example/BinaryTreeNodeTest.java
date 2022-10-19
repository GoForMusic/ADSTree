package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    BinaryTreeNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new BinaryTreeNode<>();
    }

    @AfterEach
    void tearDown() {
        node=null;
    }

    @Test
    void setElementAndGetElement() {
            node.setElement(10);
            assertEquals(10, node.getElement());
    }

    @Test
    void addLeftChildAndGetLeftChild() {
        node.addLeftChild(new BinaryTreeNode<>(15));
        assertEquals(15, node.getLeftChild().getElement());
    }

    @Test
    void addRightChildAndGetRightChild() {
        node.addRightChild(new BinaryTreeNode<>(15));
        assertEquals(15, node.getRightChild().getElement());
    }

    @Test
    void nullLeftChild(){
        assertNull(node.getLeftChild());
    }

    @Test
    void nullRightChild(){
        assertNull(node.getLeftChild());
    }
}