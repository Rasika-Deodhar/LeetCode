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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Time Complexity = O(max(m,n))
        // Space Complexity = O(m+n)
        
        if(list1==null && list2==null) { return null; }
        if(list1==null && list2!=null) { return list2;}
        if(list2==null && list1!=null) { return list1;}

        ListNode resultList = null;
        ListNode resultListTemp = null;

        while(list1!=null && list2!=null) {
            if(list1.val == list2.val) {
                if(resultList == null) {
                    resultList = new ListNode(list1.val);
                    resultList.next = new ListNode(list2.val);
                    resultListTemp = resultList.next;
                } else {
                    resultListTemp.next = new ListNode(list1.val);
                    resultListTemp.next.next = new ListNode(list2.val);
                    resultListTemp = resultListTemp.next.next;
                }
                list1 = list1.next;
                list2 = list2.next;
            } else if(list1.val < list2.val) {
                if(resultList == null) {
                    resultList = new ListNode(list1.val);
                    resultListTemp = resultList;
                } else {
                    resultListTemp.next = new ListNode(list1.val);
                    resultListTemp = resultListTemp.next;
                }
                list1 = list1.next;
            }  else if(list1.val > list2.val) {
                if(resultList == null) {
                    resultList = new ListNode(list2.val);
                    resultListTemp = resultList;
                } else {
                    resultListTemp.next = new ListNode(list2.val);
                    resultListTemp = resultListTemp.next;
                }
                list2 = list2.next;
            }            
        }

        while(list1!=null) {
            resultListTemp.next = new ListNode(list1.val);
            resultListTemp = resultListTemp.next;
            list1 = list1.next;
        }
        while(list2!=null) {
            resultListTemp.next = new ListNode(list2.val);
            resultListTemp = resultListTemp.next;
            list2 = list2.next;
        }

        return resultList;
    } 
}