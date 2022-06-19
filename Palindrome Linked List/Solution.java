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
    public boolean isPalindrome(ListNode head) {

        //ensure atlease 3 elements in the list
        if(head==null) {return false;}
        if(head.next == null) {return true;}
        if(head.next.next == null) { return head.val==head.next.val;}

        ListNode temp = head;
        ListNode temp1 = head;
        ListNode slow = head;
        ListNode fast = head;

        //traverse slow to mid and fast to end
        while (slow != null && fast != null && fast.next != null) {
            if(fast.next.next == null) { //even number of elements, fast reaches 2nd last
                fast = fast.next; //move fast to tail
                break;
            }
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
        }
        
        ListNode reverse_list = slow.next;
        slow.next = null; // break 2nd half

        reverse_list = reverseLinkedList(reverse_list);

        while(reverse_list!=null) {
            if(reverse_list.val != head.val) {
                return false;
            }
            reverse_list = reverse_list.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverseLinkedList(ListNode head) {
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
    // Space Complexity = O(N/2)

    public static void main(String[] args) {

        ListNode listNode4 = new ListNode(1, null);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        System.out.println(new Solution().isPalindrome(listNode1));
    }
}