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
    public ListNode reverseList(ListNode head) {
        if(head==null) {return null;}
        if(head.next == null) {return head;}
        ListNode new_head = null;
        ListNode a,b;

        a= head;

        while(a.next!=null) {
            b = a.next;
            a.next = b.next;
            if(new_head==null){ 
                new_head = b; new_head.next = a;
            }
            else{
                b.next = new_head;
                new_head = b;
            }
        }
        return new_head;
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
}