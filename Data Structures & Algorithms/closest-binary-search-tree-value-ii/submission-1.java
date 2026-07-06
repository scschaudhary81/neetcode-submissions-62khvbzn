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
    PriorityQueue<Pair<Integer,Double>> minHeap = new PriorityQueue<>((a,b)->Double.compare(a.getValue(),b.getValue()));

    public void dfs(TreeNode current,double target){
        if(current == null) return;
        else{
            minHeap.offer(new Pair(current.val,Math.abs(((double) current.val)-target)));
            dfs(current.left,target);
            dfs(current.right,target);
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,target);
        while(minHeap.size() > 0 && k > 0){
            list.add(minHeap.poll().getKey());
            k--;
        }
        return list;
    }
}
