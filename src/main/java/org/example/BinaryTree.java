package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree()
    {
        root=null;
        size=0;
    }

    public BinaryTree(BinaryTreeNode<T> root)
    {
        this.root=root;
        size=1;
    }

    public BinaryTreeNode getRoot()
    {
        return root;
    }

    public void setRoot(BinaryTreeNode root){

        this.root=root;
    }

    public boolean isEmpty()
    {
        if(root==null) return true;

        if (root.getElement() == null && root.getRightChild() == null && root.getLeftChild() == null) return true;

        return false;
    }

    public int size()
    {
        return size(root);
    }

    private int size(BinaryTreeNode<T> node){
        if(node ==null)
            return 0;
        return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
    }


    public boolean contains(T element)
    {
        return contains(element,root);
    }

    private boolean contains(T element, BinaryTreeNode<T> nodeADT) {

        if (nodeADT == null) return false;
        if (nodeADT.getElement().equals(element)) return true;
        boolean inLeft = contains(element, nodeADT.getLeftChild());
        if (inLeft) return true;
        boolean inRight = contains(element, nodeADT.getRightChild());
        if (inRight) return true;

        return false;
    }

    public ArrayList<T> inOrder(){
        ArrayList<T> temp = new ArrayList<>();
        addInOrder(root, temp);
        return temp;
    }

    private void addInOrder(BinaryTreeNode<T> node, List<T> listToAddOn){
        if (node==null){
            return;
        }
        if (listToAddOn ==null){
            listToAddOn = new ArrayList<>();
        }
        addInOrder(node.getLeftChild(), listToAddOn);

        listToAddOn.add(node.getElement());

        addInOrder(node.getRightChild(), listToAddOn);
    }

    public ArrayList<T> preOrder(){
        ArrayList<T> temp= new ArrayList<>();
        addPreOrder(root, temp);
        return temp;
    }

    private void addPreOrder(BinaryTreeNode<T> node,List<T> listToAddOn){
        if (node==null){
            return;
        }
        if (listToAddOn ==null){
            listToAddOn = new ArrayList<>();
        }
        listToAddOn.add(node.getElement());

        addPreOrder(node.getLeftChild(), listToAddOn);
        addPreOrder(node.getRightChild(), listToAddOn);

    }

    public ArrayList<T> postOrder()
    {
        ArrayList<T> temp= new ArrayList<>();
        addPreOrder(root, temp);
        return temp;
    }

    private void addPostOrder(BinaryTreeNode<T> node,List<T> listToAddOn){
        if (node==null){
            return;
        }
        if (listToAddOn ==null){
            listToAddOn = new ArrayList<>();
        }

        addPostOrder(node.getLeftChild(), listToAddOn);
        addPostOrder(node.getRightChild(), listToAddOn);
        listToAddOn.add(node.getElement());

    }

    public ArrayList<T> levelOrder(){
        int height = height();
        ArrayList<T> temp = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            addCurrentLevel(root, i,temp );
        }
        return temp;
    }

    private void addCurrentLevel(BinaryTreeNode<T> node, int level, List<T> listToAddOn) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            listToAddOn.add(node.getElement());
        } else if (level > 1) {
            addCurrentLevel(node.getLeftChild(), level - 1, listToAddOn);
            addCurrentLevel(node.getRightChild(), level - 1, listToAddOn);
        }
    }

    public int height() {
        return maxHeight(root);
    }

    private int maxHeight(BinaryTreeNode<T> node){
        if (node == null){
            return 0;
        }
        int leftHeight = maxHeight(node.getLeftChild());
        int rightHeight = maxHeight(node.getRightChild());

        // return whichever has more height+1;
        return leftHeight > rightHeight ? (leftHeight+1) : (rightHeight+1);

    }
}
