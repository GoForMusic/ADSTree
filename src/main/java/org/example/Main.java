package org.example;

public class Main {
    public static void main(String[] args) {


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
        BinaryTree binaryTreeADT = new BinaryTree(node);

        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printNode((BinaryTreeNode) binaryTreeADT.getRoot());
    }
}