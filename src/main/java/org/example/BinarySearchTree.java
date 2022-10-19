package org.example;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {



    public BinarySearchTree(){
        super();
    }

    public boolean insert(T element) throws Exception {
        if(contains(element)) return false;
        else {
            setRoot(insert(element, (BinarySearchTreeNode<T>) getRoot()));
            return true;
        }
    }

    private BinarySearchTreeNode<T> insert(T element, BinarySearchTreeNode<T> node) throws Exception {
        if (node == null) {
            node = new BinarySearchTreeNode<>(element);
            return node;
        } else if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(insert(element, (BinarySearchTreeNode<T>) node.getLeftChild()));
        } else if (element.compareTo(node.getElement()) > 0) {
            node.addRightChild(insert(element, (BinarySearchTreeNode<T>) node.getRightChild()));

        }

        return node;

    }
    public boolean removeElement(T element){
        if(!contains(element)) return false;
        {
            setRoot(removeElement(element, (BinarySearchTreeNode<T>) getRoot()));
            return true;
        }
    }

    private BinarySearchTreeNode<T> removeElement(T element, BinarySearchTreeNode<T> node){
        if (node == null) return null;

        // Recur down the tree
        if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(removeElement(element, (BinarySearchTreeNode<T>) node.getLeftChild()));
            return node;

        } else if (element.compareTo(node.getElement()) > 0) {
            node.addRightChild(removeElement(element, (BinarySearchTreeNode<T>) node.getRightChild()));
            return node;
        }


        if (node.getLeftChild() == null) {
            return (BinarySearchTreeNode<T>) node.getRightChild();
        } else if (node.getRightChild() == null) {
            return (BinarySearchTreeNode<T>) node.getLeftChild();
        }
        return node;
    }

    public T findMin(){
        BinarySearchTreeNode<T> root = (BinarySearchTreeNode<T>) getRoot();

        T min = root.getElement();
        while (root.getLeftChild() != null) {
            min = (T) root.getLeftChild().getElement();
            root = (BinarySearchTreeNode<T>) root.getLeftChild();

        }
        return min;
    }

    public T findMax(){
        BinarySearchTreeNode<T> root = (BinarySearchTreeNode<T>) getRoot();

        T max = (T) root.getElement();
        while (root.getRightChild() != null) {
            max = (T) root.getRightChild().getElement();
            root = (BinarySearchTreeNode<T>) root.getRightChild();

        }
        return max;
    }

    public boolean constains(T element){
        return contains(element);
    }

    void rebalance(){
        setRoot(rebalance((BinarySearchTreeNode<T>) getRoot()));
    }

    private BinarySearchTreeNode<T> rebalance(BinarySearchTreeNode<T> node){
        ArrayList<BinarySearchTreeNode<T>> nodes = new ArrayList<>();
        storeBinarySearchTreeNodes(node, nodes);


        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n-1);
    }


    private void storeBinarySearchTreeNodes(BinarySearchTreeNode<T> node, ArrayList<BinarySearchTreeNode<T>> nodes) {
        // Base case
        if (node ==null) return;

        storeBinarySearchTreeNodes((BinarySearchTreeNode<T>) node.getLeftChild(), nodes);
        nodes.add(node);
        storeBinarySearchTreeNodes((BinarySearchTreeNode<T>) node.getRightChild(), nodes);

    }

    private BinarySearchTreeNode<T> buildTreeUtil(ArrayList<BinarySearchTreeNode<T>> nodes, int start, int end) {
        // base case
        if (start > end) return null;

        // Make the middle element root
        int mid = (start + end) /2;
        BinarySearchTreeNode<T> node = nodes.get(mid);

        // Construct left and right subtrees using inorder traversal
        node.addLeftChild(buildTreeUtil(nodes, start, mid-1));
        node.addRightChild(buildTreeUtil(nodes, mid+1, end));

        return node;

    }
}
