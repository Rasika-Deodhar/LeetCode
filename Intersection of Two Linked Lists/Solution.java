import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode> set = new HashSet<>();
        

        // if headA = headB -> return
        // if headA not null -> add in set
        // if headB not null -> add in set
        // if set add false, return the node

        while( (headA!=null || headB!=null) && headA!=headB) {
            if(headA!=null && !set.add(headA)) { return headA; }
            if(headB!=null && !set.add(headB)) { return headB; }
            headA = headA!=null ? headA.next : null;
            headB = headB!=null ? headB.next : null;
        }

        return headA == headB ? headB : null;
    }

    public static void main(String[] args) {


        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = headB.next.next.next;


        System.out.println(new Solution().getIntersectionNode(headA, headB).val);
    }
}