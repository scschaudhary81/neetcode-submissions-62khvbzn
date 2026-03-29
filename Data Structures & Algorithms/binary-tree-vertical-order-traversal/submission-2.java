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
    HashMap<Integer,List<Integer>> memory = new HashMap<>();

    public void bfs(TreeNode current){
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        // add intial node with level 0
        if(current!=null) queue.offer(new Pair(current,0));

        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> currentPair = queue.poll();
            TreeNode node = currentPair.getKey();
            int level = currentPair.getValue();
            // add left right nodes
            if(node.left!=null) queue.add(new Pair(node.left,level-1));
            if(node.right!=null) queue.add(new Pair(node.right,level+1));
            // add current value in memory
            memory.putIfAbsent(level,new ArrayList<Integer>());
            memory.get(level).add(node.val);
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        bfs(root); // do level order travesal to get from left to right
        List<List<Integer>> result = new ArrayList<>();
    
        // get levels in sorted manner
        List<Integer> levels = new ArrayList<>();
        for(int level : memory.keySet()) levels.add(level);
        Collections.sort(levels);

        // add value in result level by level
        for(int level : levels) result.add(memory.get(level));
        
        return result;
    }
}