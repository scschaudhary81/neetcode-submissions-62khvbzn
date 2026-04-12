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
        for(ListNode terminalNode : terminalNodes) System.out.println(terminalNode.val);
        int first = 0;
        int second = 1;
        ListNode last = null;
        while(first < terminalNodes.size() && second<terminalNodes.size()){
            ListNode one = terminalNodes.get(first);
            ListNode two = terminalNodes.get(second);
            last = two;
            one.next = two;
            first+=2;;
            second+=2;
        }
        if(terminalNodes.size()>0 && terminalNodes.size()%2!=0) terminalNodes.get(terminalNodes.size()-1).next = null;
        return head;
    }
}
