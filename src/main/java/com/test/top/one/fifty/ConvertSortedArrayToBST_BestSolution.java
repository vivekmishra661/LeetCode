package com.test.top.one.fifty;

public class ConvertSortedArrayToBST_BestSolution {

    static void main() {
        ConvertSortedArrayToBST_BestSolution convertSortedArrayToBST = new ConvertSortedArrayToBST_BestSolution();
        convertSortedArrayToBST.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(0, nums.length - 1, nums);
    }

    private TreeNode bst(int l, int r, int[] nums) {
        if ( l > r) return null;
        int middleNode = l + (r - l) / 2;
        TreeNode parentNode = new TreeNode(nums[middleNode]);
        parentNode.val = nums[middleNode];
        parentNode.left = bst(l, middleNode-1, nums);
        parentNode.right = bst(middleNode+1,r , nums);
        return parentNode;

    }
}
