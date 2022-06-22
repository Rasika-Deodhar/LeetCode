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
    static Node flatten ;
    static Node temp;
    static Node t1;
    public Node flatten(Node head) {
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
                t1 = head;
                return flatten(head.child);
            }
            if(t1!=null) {head = t1;}
            head = head.next;
        }

        return flatten;
    }
}