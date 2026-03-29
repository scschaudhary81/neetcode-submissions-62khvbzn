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
    ArrayList<TreeNode> leaf = new ArrayList<>();
    ArrayList<TreeNode> left = new ArrayList<>();
    ArrayList<TreeNode> right = new ArrayList<>();


    public void cal_leaf(TreeNode current){
        if(current==null) return;
        else{
            if(current.left==null && current.right==null){
                leaf.add(current);
            }else{
                cal_leaf(current.left);
                cal_leaf(current.right);
            }
        }
    }

    public void cal_left(TreeNode node,int level){
        if(node==null) return;
        else{
            if(left.size()<level) left.add(node);
            cal_left(node.left,level+1);
            cal_left(node.right,level+1);
        }
    }

    public void cal_right(TreeNode node,int level){
        if(node==null) return;
        else{
            if(right.size()<level) right.add(node);
            cal_right(node.right,level+1);
            cal_right(node.left,level+1);
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // do bfs 

        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        else{
            list.add(root.val); // add root
            if(root.left==null && root.right==null) return list;
            cal_leaf(root);
            cal_left(root.left,1);
            cal_right(root.right,1);

            // ignore all leaf nodes in left
            for(TreeNode l : left){
                if(l.left!=null || l.right!=null){
                    list.add(l.val);
                }
            }
            // add all leaf nodes
            list.addAll(leaf.stream().map(a->a.val).collect(Collectors.toList()));
            // ignore leaf nodes in right
            for(int i=right.size()-1;i>=0;i--){
                TreeNode r = right.get(i);
                if(r.left!=null || r.right!=null){
                    list.add(r.val);
                }
            }
            return list;
        }
    }
}
