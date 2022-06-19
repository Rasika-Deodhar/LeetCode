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
        if( length-n == 0) { // removing 1st element from end i.e 0th index
            if(length==1) return null; // list has only 1 element, so empty list
            return head.next; // return 0th index element
        }

        temp = head;
        int i=0;
        while(i < length - n - 1) {
            temp = temp.next; // traverse list till index is len-n-1, and change pointer to next of next
            i++;
        }
        temp.next = temp.next.next;

        return head;
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
}