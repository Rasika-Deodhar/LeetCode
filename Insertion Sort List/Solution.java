/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode head_val = head, temp = null, iter = head;

        while (iter != null) {
            if (iter.val < iter.next.val) {
                temp = iter;
                iter.next.next = temp;
                // unable to do logic from here
            }
        }

        return head_val;

    }

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        s.insertionSortList(_1);

    }
}