package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BSTIterator_Revistin {


}

class BstIteratorMySolution {
    TreeNode root = new TreeNode();
    List<Integer> list = new ArrayList<>();

    public BstIteratorMySolution(TreeNode root) {
        this.root = root;
        AtomicBoolean isCompleted = new AtomicBoolean(false);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        readBst(root, isCompleted);
    }

    public void readBst(TreeNode currentNode, AtomicBoolean isCompleted) {

        if (isCompleted.get() || currentNode == null) {
            return;
        }
        var parentNode = currentNode;

        var leftNode = currentNode.left;
        var rightNode = currentNode.right;

        if (leftNode == null && rightNode == null) {
            isCompleted.set(true);
            return;
        }
        if (!isCompleted.get()) {
            if (leftNode != null && leftNode.left == null && leftNode.right == null) {
                list.add(leftNode.val);
            } else {
                currentNode = leftNode;
                readBst(currentNode, isCompleted);
            }
        }
        list.add(parentNode.val);
        if (!isCompleted.get()) {
            if (rightNode != null && rightNode.left == null && rightNode.right == null) {
                list.add(rightNode.val);
            } else {
                currentNode = rightNode;
                readBst(currentNode, isCompleted);
            }

        }


    }


    public int next() {
        return list.removeFirst();

    }

    public boolean hasNext() {

        return !list.isEmpty();
    }
}
