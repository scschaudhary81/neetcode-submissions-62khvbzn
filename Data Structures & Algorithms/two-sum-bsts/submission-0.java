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
    HashSet<Integer> memory = new HashSet<>();
    public void getHashSet(TreeNode current){
        if(current==null) return;
        else{
            memory.add(current.val);
            getHashSet(current.left);
            getHashSet(current.right);
        }
    }

    public boolean isPossible(TreeNode current,int target){
        if(current==null) return false;
        else{
            return 
            memory.contains(target-current.val)
            || isPossible(current.left,target)
            || isPossible(current.right,target);
        }
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        getHashSet(root1);
        return isPossible(root2,target);
    }
}
