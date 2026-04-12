/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode currentNode = head;
        ListNode lastNode = null;

        while(currentNode != null){
            // first skip the nodes
            int countM = m;
            while(countM > 0 && currentNode != null){
                lastNode = currentNode;
                currentNode = currentNode.next;
                countM--;
            }
            // delete the nodes
            int countN=n;
            while(countN > 0 && currentNode != null){
                currentNode = currentNode.next;
                countN--;
            }
            lastNode.next = currentNode;
        }

        return head;
    }

    /*
    public List<ListNode> findTerminalNodes(ListNode node, int m,int n){
        List<ListNode> list = new ArrayList<>();
        ListNode current = node;
        int idx = 0;
        int toStore = m-1;
        int increase = n+1;
        while(current!=null){
            if(idx==toStore){
                list.add(current);
                toStore = idx+increase;
                increase = increase == n+1 ? m-1 : n+1;
            }
            // incase again same node is reffered take m=1 and n=3
            if(idx==toStore){
                list.add(current);
                toStore = idx+increase;
                increase = increase == n+1 ? m-1 : n+1;
            }
            current = current.next;
            idx++; // keep track of node
        }

        return list;
    }
    public ListNode deleteNodes(ListNode head, int m, int n) {
        List<ListNode> terminalNodes = findTerminalNodes(head,m,n);
        int open = 0;
        int close = 1;
        ListNode last = null;
        while(open < terminalNodes.size() && close<terminalNodes.size()){
            ListNode one = terminalNodes.get(open);
            ListNode two = terminalNodes.get(close);
            last = two;
            one.next = two;
            open+=2;;
            close+=2;
        }
        // if the last nodes is not closing nodes
        if(terminalNodes.size()>0 && terminalNodes.size()%2!=0) terminalNodes.get(terminalNodes.size()-1).next = null;
        return head;
    }
    */
}
