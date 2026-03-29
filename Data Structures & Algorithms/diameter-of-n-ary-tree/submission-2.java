/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max_diameter = 0;
    public int dfs(Node root){
        if(root==null) return 0;
        else{
            int first_max = 0;
            int second_max = 0;
            for(Node child : root.children){
                int child_len = dfs(child);
                if(first_max==0) first_max = child_len;
                else if(second_max==0){
                    if(child_len>=first_max){
                        second_max=first_max;
                        first_max=child_len;
                    }else{
                        second_max=child_len;
                    }
                }
                else{
                    if(child_len>=first_max){
                        second_max=first_max;
                        first_max=child_len;
                    }else if(child_len>second_max){
                        second_max=child_len;
                    }
                }
            }

            int current_max_diameter = first_max + second_max;
            int current_height =  1+Math.max(first_max,second_max);
            max_diameter = Math.max(current_max_diameter,max_diameter);
            return current_height;
        }
    }
    public int diameter(Node root) {
        dfs(root);
        return max_diameter;
    }
}
