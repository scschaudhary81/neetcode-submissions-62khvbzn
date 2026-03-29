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
    class Result{
        int height;
        int diameter;
        Result(int height,int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public Result maxDiameter(TreeNode root){
        if(root == null) return new Result(0,0);
        Result left = maxDiameter(root.left);
        Result right = maxDiameter(root.right);

        int maxHeight = Math.max(left.height,right.height)+1;

        int diameterCurrent = Math.max(left.height+right.height,0);
        int preDiamaterLeft  = left.diameter;
        int preDiameterRight = right.diameter;

        int maxDiamater = Math.max(diameterCurrent,Math.max(preDiamaterLeft,preDiameterRight));

        return new Result(maxHeight,maxDiamater);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return maxDiameter(root).diameter;
    }
}
