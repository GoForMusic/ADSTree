package org.example;

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
        BinarySearchTreeNode<T> temp = new BinarySearchTreeNode<>();
        temp.addRightChild(node);
        int size=treeToVine(temp);
        int height=(int)(Math.log(size+1)/Math.log(2));
        int noOfNodes=(int)Math.pow(2,height)-1;
        for(noOfNodes=noOfNodes/2;noOfNodes>0;noOfNodes/=2){
            compressVine(temp,noOfNodes);
        }
        return (BinarySearchTreeNode<T>) temp.getRightChild();
    }

    private int treeToVine(BinarySearchTreeNode<T> current)
    {
        int i=0;
        BinarySearchTreeNode<T> temp= (BinarySearchTreeNode<T>) current.getRightChild();

        while(temp!=null){
            if(temp.getLeftChild()!=null){
                BinarySearchTreeNode<T> temp2=temp;
                temp= (BinarySearchTreeNode<T>) temp.getLeftChild();
                temp2.addLeftChild(temp.getRightChild());
                temp.addRightChild(temp2);
                current.addRightChild(temp);
            }else{
                i++;
                current=temp;
                temp= (BinarySearchTreeNode<T>) temp.getRightChild();
            }
        }
        return i;
    }

    private void compressVine(BinarySearchTreeNode<T> current, int m){
        BinarySearchTreeNode<T> temp = (BinarySearchTreeNode<T>) current.getRightChild();

        for(int i=0;i<m;i++){
            BinarySearchTreeNode<T> temp2=temp;
            temp= (BinarySearchTreeNode<T>) temp.getRightChild();
            current.addRightChild(temp);
            temp2.addRightChild(temp.getLeftChild());
            temp.addLeftChild(temp2);
            current=temp;
            temp= (BinarySearchTreeNode<T>) temp.getRightChild();
        }
    }

}
