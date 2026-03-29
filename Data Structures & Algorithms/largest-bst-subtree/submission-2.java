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

/*
1. Inution for a root to valid subtree
    Left is valid
    Right is valid
    max value from left < current.val
    min value from right > current.val
*/
class Node{
    int count;
    boolean isValid;
    int min;
    int max;
    Node(int count,boolean isValid,int min,int max){
        this.count = count;
        this.isValid = isValid;
        this.min = min;
        this.max = max;

    }
}
class Solution {
    int max_sub_tree = 0;
    public Node bst(TreeNode current){
        if(current == null){
            return new Node(0,true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }else{
            Node left = bst(current.left);
            Node right = bst(current.right);
            boolean isCurrentValid = left.isValid && right.isValid &&
            left.max < current.val && right.min > current.val;

            int validCount = isCurrentValid ? left.count + right.count + 1 : 0;
            
            int c_min = Math.min(current.val,Math.min(left.min,right.min));
            int c_max = Math.max(current.val,Math.max(left.max,right.max));

            max_sub_tree = Math.max(max_sub_tree,validCount);

            return new Node(validCount,isCurrentValid,c_min,c_max);
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        bst(root);
        return max_sub_tree;
    }
}
