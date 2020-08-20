

class Solution {
    public void reorderList(ListNode head) {

        //Done using Nick White's Youtube video

        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode list1 = head, head2 = head, tail1 = null, tail2 = head;

        while (tail2 != null && tail2.next != null) {
            tail1 = head2;
            head2 = head2.next;
            tail2 = tail2.next.next;
        }
        tail1.next = null;

        ListNode list2 = reverseList(head2);

        mergeLists(list1, list2);

    }

    private void mergeLists(ListNode list1, ListNode list2) {
        while (list1 != null) {
            ListNode list1_next = list1.next;
            ListNode list2_next = list2.next;

            list1.next = list2;

            if (list1_next == null)
                break;

            list2.next = list1_next;
            list1 = list1_next;
            list2 = list2_next;
        }
    }

    private ListNode reverseList(ListNode head2) {
        ListNode prev = null;
        ListNode currentNode = head2;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }

        return prev;
    }
}