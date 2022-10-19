package org.example;

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode()
    {
        this.element=null;
        leftChild=rightChild=null;
    }

    public BinaryTreeNode(T element)
    {
        this.element=element;
        leftChild=rightChild=null;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTreeNode child) {
        this.rightChild = child;
    }

    public BinaryTreeNode getLeftChild()
    {
        return leftChild;
    }

    public BinaryTreeNode getRightChild()
    {
        return rightChild;
    }
}
