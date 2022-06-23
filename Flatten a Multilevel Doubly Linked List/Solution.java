/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node flatten;
    static Node temp;
    public Node flatten(Node head) {
        if(head==null) {return head;}
       while(head!=null) {
            if(flatten == null) {
                flatten = new Node();
                flatten.val = head.val;
                flatten.next = null;
                flatten.prev = null;
                temp = flatten;
            } else {
                temp.next = new Node();
                temp.next.val = head.val;
                temp.next.next = null;
                temp.next.prev = temp;
                temp = temp.next;
            }
            if(head.child!=null) {
                flatten(head.child);
            }
            
            head = head.next;
        }

        return flatten;
    }
}