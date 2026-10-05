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
    public ListNode plusOne(ListNode head) {
        int add = 1;
        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        while(current != null){
            stack.push(current);
            current = current.next;
        }

        while(!stack.isEmpty() && add != 0){
            current  = stack.pop();
            int update = current.val + add;
            add = update / 10;
            update = update % 10;
            current.val = update;
        }
        if(add != 0){
            head = new ListNode(add,head);
        }

        return head;
    }
}
