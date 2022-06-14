import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    //Space Complexity = O(N)
    //Time Complexity = O(N) 
    //N -> no. of elements
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(head!=null && set.add(head)) {
            head = head.next;
        }

        return !(head == null);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = null; 
        System.out.println(new Solution().hasCycle(listNode));
    }
}