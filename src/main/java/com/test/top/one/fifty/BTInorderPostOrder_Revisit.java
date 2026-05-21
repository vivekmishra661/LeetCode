package com.test.top.one.fifty;

import java.util.*;

public class BTInorderPostOrder_Revisit {

    //preorder -> root-> left-> right
    //inorder -> left-> root-> right (use for breaking small trees)
    //postOrder -> left -> right -> root (last element is always root)

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        build(Arrays.stream(inorder).boxed().toList(), Arrays.stream(postorder).boxed().toList(), rootVal, root);
        return root;

    }


    //THIS is brute force Approach
    private void build(List<Integer> inorder, List<Integer> preorder, int rootVal, TreeNode currentNode) {
        List<Integer> leftPostOrder = new ArrayList<>();
        List<Integer> leftInOrder = new ArrayList<>();
        List<Integer> rightPostOrder = new ArrayList<>();
        List<Integer> rightInOrder = new ArrayList<>();
        boolean isLeft = true;
        for (int i = 0; i < inorder.size(); i++) {
            if (rootVal == inorder.get(i)) {
                isLeft = false;
                continue;
            }
            if (isLeft) {
                leftInOrder.add(inorder.get(i));
            } else {
                rightInOrder.add(inorder.get(i));
            }
        }
        int countL = leftInOrder.size() - 1;
        int countR = rightInOrder.size() - 1;
        for (int i = 0; i < preorder.size()-1; i++) {
            if (countL >= 0) {
                leftPostOrder.add(preorder.get(i));
                countL--;
                continue;
            }
            if (countR >= 0) {
                rightPostOrder.add(preorder.get(i));
                countR--;
            }
        }
        if (!leftPostOrder.isEmpty()) {
            int leftVal = leftPostOrder.getLast();
            TreeNode left = new TreeNode(leftVal);
            currentNode.left = left;
            build(leftInOrder, leftPostOrder, leftVal, left);
        }
        if (!rightPostOrder.isEmpty()) {
            int rightVal = rightPostOrder.getLast();
            TreeNode right = new TreeNode(rightVal);
            currentNode.right = right;
            build(rightInOrder, rightPostOrder, rightVal, right);
        }

    }
}
