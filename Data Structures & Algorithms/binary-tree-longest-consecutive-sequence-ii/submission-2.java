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


class Path{
    int increase;
    int decrease;
    Path(int increase,int decrease){
        this.increase=increase;
        this.decrease=decrease;
    }
}

class Solution {
    int max = -1;
    public Path dfs(TreeNode current){
        if(current==null) return new Path(0,0);
        else{
            // left
            Path left = dfs(current.left);
            // right
            Path right = dfs(current.right);
            // final computation
            int left_increase = 1;
            int left_decrease = 1;

            // left
            if(current.left!=null){
                if(current.left.val-current.val==1) left_increase+=left.increase;
                if(current.val-current.left.val==1) left_decrease+=left.decrease;
            }
            // right

            int right_increase=1;
            int right_decrease=1;
            if(current.right!=null){
                if(current.right.val-current.val==1) right_increase+=right.increase;
                if(current.val-current.right.val==1) right_decrease+=right.decrease;
            }

            int current_max = Math.max(left_increase+right_decrease,left_decrease+right_increase)-1;
            max = Math.max(current_max,max);

            //System.out.println("node: "  + current.val + " decrease: " + Math.max(left_decrease,right_decrease) + " increase: " + Math.max(left_increase,right_increase)+ " max: "+max);

            return new Path(
                Math.max(left_increase,right_increase),
                Math.max(left_decrease,right_decrease)
            );
        }
    }
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
}
