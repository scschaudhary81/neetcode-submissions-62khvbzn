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


class Node{
    double sum;
    int count;
    Node(double sum,int count){
        this.sum=sum;
        this.count=count;
    }
}
class Solution {
    double maxAverage  = 0;
    public Node calAvg(TreeNode current){
        if(current==null) return new Node(0,0);
        else{
            Node left = calAvg(current.left);
            Node right = calAvg(current.right);
            double c_sum = left.sum + right.sum + current.val;
            int c_count = left.count+right.count+1;
            double c_avg = c_sum/c_count;
            maxAverage = maxAverage>c_avg?maxAverage:c_avg;
            return new Node(c_sum,c_count);
        }
    }
    public double maximumAverageSubtree(TreeNode root) {
        calAvg(root);
        return maxAverage;
    }
}
