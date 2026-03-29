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
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while(a!=null && b!=null){
            int i = a.val;
            int j = b.val;
            int total = i+j+carry;
            carry = total/10;
            temp.next = new ListNode(total%10);
            temp = temp.next;
            a=a.next;
            b=b.next;
        }

        while(a!=null){
            int i = a.val;
            int total = i+carry;
            carry = total/10;
            temp.next = new ListNode(total%10);
            temp = temp.next;
            a=a.next;
        }
        while(b!=null){
            int j = b.val;
            int total = j+carry;
            carry = total/10;
            temp.next = new ListNode(total%10);
            temp = temp.next;
            b=b.next;
        }

        if(carry!=0)  temp.next = new ListNode(carry);


        return result.next;
    }
}
