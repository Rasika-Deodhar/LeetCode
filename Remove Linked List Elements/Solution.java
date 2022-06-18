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
    public ListNode removeElements(ListNode head, int val) {

        if(head==null) {return null;}
        if(head.next == null && head.val == val) {return null;}
        
        ListNode temp = head;
        ListNode prev = head;

        while(temp!=null) {
            if(temp.val == val) {
                if(temp==head) { head = head.next; }
                else { prev.next = temp.next; temp = temp.next; continue;}
            }
            prev = temp;
            temp = temp.next;
        }

        return head;

    }
}