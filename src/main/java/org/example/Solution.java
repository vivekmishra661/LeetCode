package org.example;

import java.util.*;

class Tree {
    // List of node data values:
    Vector<Integer> values;
    // Total number of nodes in the tree:
    private int count;

    Tree() {
        this.values = new Vector<Integer>();
        this.count = 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/


    boolean checkBST(Node root) {
        java.util.concurrent.atomic.AtomicBoolean isNotBst = new java.util.concurrent.atomic.AtomicBoolean(false);

        int rootNodeVal = root.data;
        if (root.left != null) {
            traverseLeft(root,rootNodeVal, isNotBst, false);
        }


        return !isNotBst.get();
    }

    public void traverseLeft(Node root, int rootNodeVal, java.util.concurrent.atomic.AtomicBoolean isNotBst,
                              boolean fromLeft
    ) {
        Node left = root.left;
        if (left.data > root.data ||( fromLeft && rootNodeVal> left.data))
         {
            isNotBst.set(true);
            return;
        }
        if (left.left != null) {
            traverseLeft(root.left,root.data, isNotBst, false);
        }
        if (left.right != null) {
            traverseRight(root.right,root.data, isNotBst, true);
        }
    }

    public void traverseRight(Node root,int rootNodeVal, java.util.concurrent.atomic.AtomicBoolean isNotBst,
                              boolean fromRight) {
        Node right = root.right;
        if (right.data < root.data || ( fromRight && rootNodeVal < right.data)) {
            isNotBst.set(true);
            return;
        }
        if (right.left != null) {
            traverseLeft(root.left, root.data,isNotBst,true);
        }
        if (right.right != null) {
            traverseRight(root.right,root.data, isNotBst, false);
        }
    }


    void inOrder(Node root, int levels) {

        if (root != null) {
            // If there are still unfilled levels, fill left subtree:
            if (levels > 0) {
                // Create a new left child node:
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }

            // Set node data:
            root.data = values.elementAt(count);
            count++;

            // If there are still unfilled levels, fill right subtree:
            if (levels > 0) {
                // Create a new right child node:
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }
}

public class Solution{

    public static void main(String[] args) {
      //int[] x = {1, 2, 4, 3, 5, 6, 7};
        int[] x = {1 ,2 ,3 ,4 ,5 ,6 ,7};


        // Read data values for tree's nodes:
        Tree tree = new Tree();
        for(int i =0;i< x.length; i++) {
            tree.values.add(x[i]);
        }
        //scanner.close();

        // Fill tree:
        Tree.Node root = new Tree.Node();
        tree.inOrder(root, 2);

        // Print result:
        System.out.println( (tree.checkBST(root) == true) ? "Yes" : "No" );

    }
}
