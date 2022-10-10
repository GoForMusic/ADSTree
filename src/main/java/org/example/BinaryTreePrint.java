package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrint {
    public static <T extends Comparable<?>> void printNode(BinaryTreeNode<T> root) {
        int maxLevel = BinaryTreePrint.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BinaryTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrint.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrint.printWhitespaces(firstSpaces);

        List<BinaryTreeNode<T>> newNodes = new ArrayList<BinaryTreeNode<T>>();
        for (BinaryTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getElement());
                newNodes.add(node.getLeftChild());
                newNodes.add(node.getRightChild());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrint.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrint.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrint.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeftChild() != null)
                    System.out.print("/");
                else
                    BinaryTreePrint.printWhitespaces(1);

                BinaryTreePrint.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRightChild() != null)
                    System.out.print("\\");
                else
                    BinaryTreePrint.printWhitespaces(1);

                BinaryTreePrint.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryTreeNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrint.maxLevel(node.getLeftChild()), BinaryTreePrint.maxLevel(node.getRightChild())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }


}
