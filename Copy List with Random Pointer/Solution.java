import java.util.HashMap;

class Solution {
    static Node temp;
    static HashMap<Node, Node> copyOfNodes = new HashMap<>();

    public Node copyRandomList(Node head) {
       
        copyOfNodes.clear();
        temp = head;
        if(head==null) {return null;}

        copyOfNodes.put(temp, new Node(temp.val));

        while(temp!=null) {

            // check if random node exists - if not (add it), if yes (point it)
            if(temp.random !=null && !copyOfNodes.containsKey(temp.random)) {
                copyOfNodes.put(temp.random, new Node(temp.random.val));
            }
            copyOfNodes.get(temp).random = copyOfNodes.get(temp.random);


            // check if next node exists - if not (add it), if yes (point it)
            if(temp.next !=null && !copyOfNodes.containsKey(temp.next)) {
                copyOfNodes.put(temp.next, new Node(temp.next.val));
            }
            copyOfNodes.get(temp).next = copyOfNodes.get(temp.next);

            temp = temp.next;
        }

        return copyOfNodes.get(head);

        //Time Complexity = O(N)
        //Space Complexity = O(N)
        //Resource of solving - https://www.youtube.com/watch?v=toXiQdhGf64

    }

    public static void main(String[] args) {
        
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);

        node.random = null;
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;

        Node result = new Solution().copyRandomList(node);

        while(result!=null) {
            System.out.println(result.val + " ");
            result = result.next;
        }
    }
}