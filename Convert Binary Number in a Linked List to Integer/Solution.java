/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int power = 0;
        ListNode temp_head = head;

        while (temp_head != null) {
            power++;
            temp_head = temp_head.next;
        }

        temp_head = head;

        int decimal = 0;

        for (int i = power - 1; i >= 0; i--) {
            if (temp_head.val == 1 && temp_head != null)
                decimal += (int) Math.pow(2, i);
            temp_head = temp_head.next;
        }

        return decimal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode ln = new ListNode(0);
        ln.next = new ListNode(0);
        // ln.next.next = new ListNode(1);
        System.out.println(s.getDecimalValue(ln));
    }
}