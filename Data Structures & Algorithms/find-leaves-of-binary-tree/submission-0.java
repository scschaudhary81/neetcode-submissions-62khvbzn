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
    public TreeNode deleteLeafs(TreeNode root,List<Integer> list){
        if(root==null) return null;
        else{
            if(root.left==null && root.right==null){ // if leaf node
                list.add(root.val);
                return null;
            }else{ // not leaf node
                root.left = deleteLeafs(root.left,list);
                root.right = deleteLeafs(root.right,list);
                return root;
            }
            
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leafNodesLevelByLevel = new ArrayList<>();
        while(root!=null){
            List<Integer> current = new ArrayList<>();
            root = deleteLeafs(root,current);
            leafNodesLevelByLevel.add(current);
        }
        return leafNodesLevelByLevel;
    }
}
