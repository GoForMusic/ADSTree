package org.example;

import java.util.Vector;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    private boolean isFound=false;

    public BinarySearchTree(){
        super();
    }

    public boolean insert(T element) {

        try {
            setRoot(insert(element, (BinarySearchTreeNode<T>) getRoot()));
            return true;
        } catch (Exception e) {
            return false;
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

    public boolean removeElement(T element) {


        setRoot(removeElement(element, (BinarySearchTreeNode<T>) getRoot()));
        return isFound;
    }

    private BinarySearchTreeNode<T> removeElement(T element, BinarySearchTreeNode<T> node) {
        isFound = false;
        // Base case : if the tree is empty
        if (node == null) return null;

        // Recur down the tree
        if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(removeElement(element, (BinarySearchTreeNode<T>) node.getLeftChild()));
            return node;

        } else if (element.compareTo(node.getElement()) > 0) {
            node.addRightChild(removeElement(element, (BinarySearchTreeNode<T>) node.getRightChild()));
            return node;
        }

        // Here, the element is finally found.
        isFound = true;

        // Now there are three cases..
        // The found root might have zero, one or two childs..


        // If one child is empty, the corresponding is going to be the new root

        if (node.getLeftChild() == null) {
            return (BinarySearchTreeNode<T>) node.getRightChild();
        } else if (node.getRightChild() == null) {
            return (BinarySearchTreeNode<T>) node.getLeftChild();
        }


        // If both children exist, this is super complex...
        else {
            BinarySearchTreeNode<T> succParent = node;

            // Mission : Finding the successor for the node...
            BinarySearchTreeNode<T> succ = (BinarySearchTreeNode<T>) node.getRightChild();

            while (succ.getLeftChild() != null) {
                succParent = succ;
                succ = (BinarySearchTreeNode<T>) succ.getLeftChild();
            }

            // Here, we delete the successor .
            // Since, the succsesor is always the left child of the parent (the smaller one), we can
            // make the successors right-right child to the left of its parent.
            if (succParent != node) {
                succParent.addLeftChild(succ.getRightChild());
            } else {
                succParent.addRightChild(succ.getRightChild());
            }


            // Well, if there is no sucessor, then assign suceessor -> right  to tempParent->right..
            node.setElement(succ.getElement());
            return node;
        }

    }

    public T findMin() {

        BinarySearchTreeNode<T> startNode = (BinarySearchTreeNode<T>) getRoot();

        T minVal = (T) startNode.getElement();
        while (startNode.getLeftChild() != null) {
            minVal = (T) startNode.getLeftChild().getElement();
            startNode = (BinarySearchTreeNode<T>) startNode.getLeftChild();

        }
        return minVal;
    }

    public T findMax() {
        BinarySearchTreeNode<T> startNode = (BinarySearchTreeNode<T>) getRoot();

        T maxVal = (T) startNode.getElement();
        while (startNode.getRightChild() != null) {
            maxVal = (T) startNode.getRightChild().getElement();
            startNode = (BinarySearchTreeNode<T>) startNode.getRightChild();

        }
        return maxVal;
    }

    public boolean contains(T element) {
        return contains(element, (BinarySearchTreeNode) getRoot());
    }

    private boolean contains(T element, BinarySearchTreeNode node) {

        if (node == null || node.getElement() == null) return false;
       // if (node.getElement().compareTo(element) > 0) {
        //    return contains(element, (BinarySearchTreeNode) node.getLeftChild());
        //} else if (node.getElement().compareTo(element) < 0) {
        //    return contains(element, (BinarySearchTreeNode) node.getRightChild());
        //} else {
        //    // If compare to method returns 0, its equal
         //   return true;
       // }
        return false;
    }

    public void reBalance() {
        setRoot( reBalance((BinarySearchTreeNode<T>) getRoot()));
    }

    private BinarySearchTreeNode<T> reBalance(BinarySearchTreeNode<T> node){
        Vector<BinarySearchTreeNode<T>> nodes = new Vector<>();
        storeBinarySearchTreeNodes(node, nodes);


        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n-1);
    }

    private void storeBinarySearchTreeNodes(BinarySearchTreeNode<T> node, Vector<BinarySearchTreeNode<T>> nodes) {
        // Base case
        if (node ==null) return;

        storeBinarySearchTreeNodes((BinarySearchTreeNode<T>) node.getLeftChild(), nodes);
        nodes.add(node);
        storeBinarySearchTreeNodes((BinarySearchTreeNode<T>) node.getRightChild(), nodes);

    }

    private BinarySearchTreeNode<T> buildTreeUtil(Vector<BinarySearchTreeNode<T>> nodes, int start, int end) {
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
