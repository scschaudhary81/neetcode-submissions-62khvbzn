/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {


    public void insertNode(Node head, Node insert){
        HashSet<Node> visited = new HashSet<>();
        Node terminalNode = head;
        Node current = head;


        while(!visited.contains(current)){
            if(current.val <= insert.val && current.next.val >= insert.val){
                Node currentNext = current.next;
                current.next = insert;
                insert.next  = currentNext;
                return;
            }

            if(current.val > current.next.val){
               terminalNode = current;
            }
            visited.add(current);
            current = current.next;
        }

        System.out.println("yes");

        Node terminalNodeNext = terminalNode.next;
        terminalNode.next = insert;
        insert.next =  terminalNodeNext;       

    }
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal); insertNode.next = insertNode;
        if(head == null) return insertNode;
        insertNode(head,insertNode);
        return head;
    }
}
