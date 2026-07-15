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
    double diff = Double.MAX_VALUE;
    int value = Integer.MAX_VALUE;
    public void dfs(TreeNode root,double target){
        if(root == null) return;
        else{
            double currentDiff = Math.abs((double)root.val-target);
            if(currentDiff <= diff){
                value = currentDiff == diff 
                ? Math.min(value,root.val) 
                : root.val;
                diff = currentDiff;
            }
            dfs(root.left,target);
            dfs(root.right,target);
        }
    }
    public int closestValue(TreeNode root, double target) {
        dfs(root,target);
        return value;
    }
}
