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

        if(length-n == 0) { 
            return null;
        }

        temp = head;
        int i=0;
        while(i++ < length - n - 1) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}