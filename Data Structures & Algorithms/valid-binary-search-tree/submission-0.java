/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean checkIfValid(TreeNode root , long left,long right){
        if(root == null) return true;
        int rootValue = root.val;
        boolean isValidNode = rootValue > left && rootValue < right;
        return isValidNode &&
        checkIfValid(root.left,left,rootValue) &&
        checkIfValid(root.right,rootValue,right);
    }
    public boolean isValidBST(TreeNode root) {
        return checkIfValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}