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
    int count = 0;
    boolean isUniRoot(TreeNode root){
        if(root==null) return true;
        else{
            boolean left = 
            isUniRoot(root.left) && (root.left==null || root.left.val == root.val);
            boolean right = 
            isUniRoot(root.right) && (root.right==null || root.right.val == root.val);

            boolean isCurrentUniNode =  left && right;
            if(isCurrentUniNode) count++;
            return isCurrentUniNode;
        }
    }
    public int countUnivalSubtrees(TreeNode root) {
        isUniRoot(root);
        return count;
    }
}
