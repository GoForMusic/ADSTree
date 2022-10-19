package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchTreeNodeTest {
    private BinarySearchTreeNode<Integer> binarySearchTreeNode;

    @BeforeEach
    void setup(){
        binarySearchTreeNode = new BinarySearchTreeNode<>();
    }

    @AfterEach
    void TearDown(){
        binarySearchTreeNode=null;
    }

    @Test
    void initializeAsNull(){
        assertNull(binarySearchTreeNode.getRightChild());
        assertNull(binarySearchTreeNode.getElement());
        assertNull(binarySearchTreeNode.getLeftChild());
    }

    @Test
    void testGetLeftChild(){

        // Arrange
        BinarySearchTreeNode<Integer> leftChild = new BinarySearchTreeNode<>();
        leftChild.setElement(10);

        // Act
        binarySearchTreeNode.setElement(11);
        binarySearchTreeNode.addLeftChild(leftChild);

        // Assert
        assertEquals(leftChild, binarySearchTreeNode.getLeftChild());
        assertEquals(10, leftChild.getElement());


    }
    @Test
    void testGetRightChild(){

        // Arrange
        BinarySearchTreeNode<Integer> rightChild = new BinarySearchTreeNode<>();
        rightChild.setElement(10);

        // Act
        binarySearchTreeNode.setElement(11);
        binarySearchTreeNode.addRightChild(rightChild);

        // Assert
        assertEquals(10, binarySearchTreeNode.getRightChild().getElement());


    }
}