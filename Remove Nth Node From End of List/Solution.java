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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp = head;
        int length = 0;

        while(temp!=null) {
            length++;
            temp = temp.next;
        }

        if(length-n < 0) { 
            return null;
        }
        if( length-n == 0) {
            if(length==1) return null;
            return head.next;
        }

        temp = head;
        int i=0;
        while(i < length - n - 1  && temp.next!=null) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next==null? null : temp.next.next;

        return head;
    }
}