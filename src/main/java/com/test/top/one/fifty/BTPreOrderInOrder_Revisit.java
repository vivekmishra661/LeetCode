package com.test.top.one.fifty;

import java.util.*;

public class BTPreOrderInOrder_Revisit {

    static void main() {
        BTPreOrderInOrder_Revisit btPreOrderInOrder = new BTPreOrderInOrder_Revisit();
        btPreOrderInOrder.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //preorder -> root-> left-> right
        //inorder -> left-> root-> right (use for breaking small trees)
        //find root
        //any thing left of root in inorder is left tree
        //any thing right of root in inorder is right tree
        Map<Integer, Integer> preOrderIndexMap = new HashMap<>();
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        for(int i =0; i< preorder.length; i++){
            preOrderIndexMap.put(preorder[i],i);
            preOrderList.add(preorder[i]);
            inOrderIndexMap.put(inorder[i],i);
            inOrderList.add(inorder[i]);
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
       // build(Arrays.stream(inorder).boxed().toList(), Arrays.stream(preorder).boxed().toList(), rootVal, root);
        build2(preOrderList,inOrderList,root, preOrderIndexMap,inOrderIndexMap);
        return root;

    }

    public void build2(List<Integer> preorder, List<Integer> inorder, TreeNode currentNode, Map<Integer, Integer> preOrderIndexMap ,Map<Integer, Integer> inOrderIndexMap ){
        var rootElementInorder = inOrderIndexMap.get(currentNode.val);
        var rootElementPreOrder  = preOrderIndexMap.get(currentNode.val);
        var leftTreeInOrderList = inorder.subList(0, rootElementInorder);
        var rightTreeInOrderList = inorder.subList(rootElementInorder+1, inorder.size());
        var leftTreePreOrderList = preorder.subList(1, leftTreeInOrderList.size()+1);
        var rightTreePreOrderList = preorder.subList(leftTreeInOrderList.size()+1, preorder.size());
        if (!leftTreeInOrderList.isEmpty()) {
            int leftVal = leftTreePreOrderList.get(0);
            TreeNode left = new TreeNode(leftVal);
            currentNode.left = left;
            build2(leftTreeInOrderList, leftTreePreOrderList, left, preOrderIndexMap, inOrderIndexMap);
        }
        if (!rightTreeInOrderList.isEmpty()) {
            int rightVal = rightTreePreOrderList.get(0);
            TreeNode right = new TreeNode(rightVal);
            currentNode.right = right;
            build2(rightTreeInOrderList, rightTreePreOrderList, right, preOrderIndexMap, inOrderIndexMap);
        }


    }




//THIS is brute force Approach
    private void build(List<Integer> inorder, List<Integer> preorder, int rootVal, TreeNode currentNode) {
        List<Integer> leftPreOrder = new ArrayList<>();
        List<Integer> leftInOrder = new ArrayList<>();
        List<Integer> rightPreOrder = new ArrayList<>();
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
        for (int i = 1; i < preorder.size(); i++) {
            if (countL >= 0) {
                leftPreOrder.add(preorder.get(i));
                countL--;
                continue;
            }
            if (countR >= 0) {
                rightPreOrder.add(preorder.get(i));
                countR--;
            }
        }
        if (!leftPreOrder.isEmpty()) {
            int leftVal = leftPreOrder.get(0);
            TreeNode left = new TreeNode(leftVal);
            currentNode.left = left;
            build(leftInOrder, leftPreOrder, leftVal, left);
        }
        if (!rightPreOrder.isEmpty()) {
            int rightVal = rightPreOrder.get(0);
            TreeNode right = new TreeNode(rightVal);
            currentNode.right = right;
            build(rightInOrder, rightPreOrder, rightVal, right);
        }

    }

    //TODO
    /*
    Approach 2: Optimal Approach 🚀
Key Optimization:
Use hashmap to store:
value → index in inorder
👉 This makes lookup O(1)

Step-by-Step Logic
Maintain index idx for preorder
Build root using preorder[idx]
Find its position in inorder using map
Recursively:
Left subtree → (l → mid-1)
Right subtree → (mid+1 → r)

     */

}
