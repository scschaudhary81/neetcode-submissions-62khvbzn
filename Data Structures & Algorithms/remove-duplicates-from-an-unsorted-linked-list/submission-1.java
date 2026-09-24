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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode start = new ListNode(-1); start.next = head;
        ListNode prev = start;
        ListNode current = head;
        HashMap<Integer,Integer> memory = new HashMap<>();

        ListNode iterate = head;
        // keep track of duplicate elements
        while(iterate != null){
            memory.put(iterate.val,memory.getOrDefault(iterate.val,0)+1);
            iterate = iterate.next;
        }

        // eliminate the duplicate elements
        while(current != null){
            if(memory.get(current.val) > 1){
                prev.next = current.next;
            }else{
                prev=current;
            }
            current = current.next;
        }   
        return start.next;
    }
}
