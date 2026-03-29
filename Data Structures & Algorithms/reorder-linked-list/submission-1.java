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


    public ListNode reverse(ListNode node){
        ListNode prev=null,current = node,next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev=current;
            current = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode first=head;
        ListNode second=null;

        ListNode slow = head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        second=slow.next;
        slow.next = null;
        second = reverse(second);
        while(second!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
             first.next = second;
             second.next = firstNext;
             second=secondNext;
             first=firstNext;
        }
        
        

    }
}
