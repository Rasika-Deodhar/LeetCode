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

        while(temp!=tail_original && temp.next!=tail_original) {

            ListNode even_node = temp.next;
            temp.next = temp.next.next;
            even_node.next = null;
            tail_new.next = even_node;
            tail_new = tail_new.next;

            temp = temp.next;
        }

        if(temp.next == tail_original) {
            ListNode even_node = temp.next;
            temp.next = temp.next.next;
            even_node.next = null;
            tail_new.next = even_node;
        }

        return head;

    }

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