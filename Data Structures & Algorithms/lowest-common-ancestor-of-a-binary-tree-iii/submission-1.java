/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
/*
Move Up and track the path
If Any Node found to be repeating then it is the answer
*/

class Solution {
    Node lca = null;
    HashSet<Node> memory = new HashSet<>();
    void moveAndMemorize(Node node){
        if(node==null) return;
        else if(memory.contains(node)){
            lca = node;
            return;
        }else{
            memory.add(node);
            moveAndMemorize(node.parent);
        }
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        moveAndMemorize(p);
        moveAndMemorize(q);
        System.out.println(lca);
        return lca;
    }
}