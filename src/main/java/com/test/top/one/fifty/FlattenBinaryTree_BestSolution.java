package com.test.top.one.fifty;

public class FlattenBinaryTree_BestSolution {

    static void main() {
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(3);
        FlattenBinaryTree_BestSolution flattenBinaryTree = new FlattenBinaryTree_BestSolution();
        flattenBinaryTree.flatten(t);
        System.out.println(t);
    }

    public void flatten(TreeNode root) {
        if(root ==null) return;
        //Morris Traversal logic
        if(root.left != null){
               var rightMostNode =  findRightMostNode(root.left);
               if(rightMostNode!= null){
                   var right = root.right;
                   rightMostNode.right = right;
                   root.right = root.left;
                   root.left = null;
                   root = root.right;
                   flatten(root);
               }else{
                   var right = root.right;
                   root.right = root.left;
                   root.left = null;
                   root.right.right = right;
                   root = root.right;
                   flatten(root);
               }
        }else{
            root = root.right;
            flatten(root);
        }
    }

    public TreeNode findRightMostNode(TreeNode currentNode){

        var rightNode = currentNode.right;
       while(rightNode!= null){
           var right = rightNode.right;
           if(right==null){
               return rightNode;
           }else{
               rightNode = right;
           }
       }
       return rightNode;
    }
}
