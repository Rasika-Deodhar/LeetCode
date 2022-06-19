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
    public ListNode oddEvenList(ListNode head) {

        //assuring min. 3 nodes in the list
        if(head==null || head.next==null || head.next.next==null) {return head;}
        
        ListNode temp = head;
        ListNode tail_original = head;
        ListNode tail_new = head;

        while(tail_original.next!=null) {
            tail_original = tail_original.next;
        }
        tail_new = tail_original;

        // till you reach original tail
        while(temp!=tail_original && temp.next!=tail_original) {

            // Move even node to end, by changing pointers
            ListNode even_node = temp.next;
            temp.next = temp.next.next; // odd element points to next odd element
            even_node.next = null;
            tail_new.next = even_node; // adding even to end
            tail_new = tail_new.next; // saving new tail

            temp = temp.next;
        }

        if(temp.next == tail_original) { // moving element just before original tail to the end -> in case of even no. of elements in list
            ListNode even_node = temp.next;
            temp.next = temp.next.next;
            even_node.next = null;
            tail_new.next = even_node;
        }

        return head;

    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        
        ListNode result = new Solution().oddEvenList(listNode1);

        while(result!=null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}