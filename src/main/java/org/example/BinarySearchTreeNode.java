package org.example;

public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {
    private T element;

    public BinarySearchTreeNode() {
        super();
        this.element = null;

    }

    public BinarySearchTreeNode(T element){
        this.element=element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}
