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
    public Node findRoot(List<Node> tree) {
       HashSet<Node> children = new HashSet<>();
       for(Node parent : tree){
            if(parent == null) continue;
            for(Node child : parent.children){
                children.add(child);
            }
       }

       for(Node parent : tree){
         if(parent == null) continue;
         if(!children.contains(parent)){
            return parent;
         }
       }

       return null; 
    }
}
