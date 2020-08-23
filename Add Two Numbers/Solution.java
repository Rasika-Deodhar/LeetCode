class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_digit = 0;
        ListNode result = null;
        ListNode result_head = null;

        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            int ans = carry_digit + l1.val + l2.val;
            carry_digit=0;
            if (ans > 9) {
                carry_digit += (ans / 10);
                ans = ans % 10;
            }
            if (result == null) {
                result = new ListNode();
                result.val = ans;
                result_head = result;
            } else {
                result.next = new ListNode();
                result = result.next;
                result.val = ans;
            }
        }

        if (l1 != null && l2 == null) {
            while (l1 != null) {
                int ans = carry_digit + l1.val;
                carry_digit=0;
                if (ans > 9) {
                    carry_digit += (ans / 10);
                    ans = ans % 10;
                }
                if (result == null) {
                    result = new ListNode();
                    result.val = ans;
                    result_head = result;
                } else {
                    result.next = new ListNode();
                    result = result.next;
                    result.val = ans;
                }

                l1 = l1.next;
            }
        }

        if (l2 != null && l1 == null) {
            while (l2 != null) {
                int ans = carry_digit + l2.val;
                carry_digit=0;
                if (ans > 9) {
                    carry_digit += (ans / 10);
                    ans = ans % 10;
                }
                if (result == null) {
                    result = new ListNode();
                    result.val = ans;
                    result_head = result;
                } else {
                    result.next = new ListNode();
                    result = result.next;
                    result.val = ans;
                }
                l2 = l2.next;
            }
        }

        if (carry_digit != 0) {
            result.next = new ListNode();
            result = result.next;
            result.val = carry_digit;
        }

        return result_head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // add 2 single digits
        ListNode result = s.addTwoNumbers(new ListNode(9), new ListNode(9));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();
        // add 2 two-digit numbers
        ListNode digit1 = new ListNode(2);
        digit1.next = new ListNode(4);
        digit1.next.next = new ListNode(3);

        ListNode digit2 = new ListNode(5);
        digit2.next = new ListNode(6);
        digit2.next.next = new ListNode(4);
        result = s.addTwoNumbers(digit1, digit2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}