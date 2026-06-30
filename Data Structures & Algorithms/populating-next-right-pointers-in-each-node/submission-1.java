/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public void addNodeIfNotNull(Node root,Queue<Node> q){
        if(root != null) q.offer(root);
    }
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        addNodeIfNotNull(root,q);

        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            while(size > 0){
                Node current = q.poll();
                if(prev != null) prev.next = current;
                addNodeIfNotNull(current.left,q);
                addNodeIfNotNull(current.right,q);
                size--;
                prev=current;
            }
        }
        return root;
    }
}