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
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || k==0 || head.next==null) {return head;}
        
        ListNode temp = head;
        int length=0, i=0, rotate=0;

        while(temp!=null) {
            length++;
            temp = temp.next;
        }

        while(k > length) {
            k = Math.abs(k-length);
        }

        if(k==length) {
            return head;
        }
        
        rotate = length - k - 1;

        temp=head;
        while(i<rotate) {
            temp = temp.next;
            i++;
        }

        ListNode t1 = temp.next;
        temp.next = null;
        ListNode new_head = t1;

        while(t1.next!=null) {
            t1=t1.next;
        }
        t1.next = head;

        return new_head;

    }

    // Time Complexity = O(N)
    // Space Complexity = O(1) -> no extra space used apart from constants
}