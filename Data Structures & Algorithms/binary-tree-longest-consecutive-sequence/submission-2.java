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
 Idea here is that if current-prev == 1 then include this + max(left,right)
 else max(left,right) (as it may be the case this should be skipped as well)
 */

class Solution {
    public int maxLen(TreeNode current,int prev){
        if(current==null) return 0;
        else{
            int left = maxLen(current.left,current.val);
            int right = maxLen(current.right,current.val);
            if(prev==Integer.MAX_VALUE || current.val-prev==1){
                return 1+Math.max(left,right);
            }else{
                return Math.max(left,right);
            }
        }
    }
    public int longestConsecutive(TreeNode root) {
        return maxLen(root,Integer.MAX_VALUE);
    }
}
