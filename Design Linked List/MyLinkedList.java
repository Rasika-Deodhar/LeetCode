class MyLinkedList {

    int value;
    MyLinkedList next;
    MyLinkedList head;
    int length=0;

    public MyLinkedList() {
        value = 0;
        next = null;
        head = null;
        length = 0;
    }
    
    public int get(int index) {
        if(index >= length) { return -1; }
        if(index==0) {
            return head==null ? -1 : head.value;
        } else {
            int i=0;
            MyLinkedList temp = head;
            while(i < index && temp.next!=null) {
                temp = temp.next;
                i++;
            }

            return temp == null ? -1 : 
                   i==index ? temp.value : -1;
        }
    }
    
    public void addAtHead(int val) {
        if(head==null) {
            head = new MyLinkedList();
            head.value = val;
        } else {
            MyLinkedList temp = new MyLinkedList();
            temp.value = val;
            temp.next = head;
            head = temp;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            head = new MyLinkedList();
            head.value = val;
        } else {
            MyLinkedList tail = new MyLinkedList();
            tail.value = val;
            tail.next = null;

            MyLinkedList temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = tail;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > length) { return; }
        else if(index==0) { addAtHead(val);}
        else if(index==length) {addAtTail(val);}
        else {
            int i=0;
            MyLinkedList node = new MyLinkedList();
            node.value = val;
            MyLinkedList temp = head;

            while (i<index-1){
                i++;
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;

            
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >=length) {return;}
        if(index==0) {head = head.next;}
        else if(index==length-1) {
            MyLinkedList temp = head;
            while(temp.next.next!=null){
                temp = temp.next;
            }
            temp.next = null;
        }
        else {
            int i=0;
            MyLinkedList temp = head;
            while (i<index-1){
                i++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        length--;
    }

    public static void main(String[] args) {
        
        MyLinkedList myLinkedList = null;

        String[] strArr = new String[] { "MyLinkedList","addAtHead","addAtIndex","addAtTail","addAtTail","addAtTail",
        "addAtIndex","addAtTail","addAtHead","deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtIndex","addAtTail","get",
        "get","addAtHead","addAtTail","addAtTail","get","addAtTail","addAtTail","deleteAtIndex","deleteAtIndex","addAtHead",
        "addAtTail","addAtIndex","get","addAtTail","addAtIndex","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail",
        "addAtIndex","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtHead","deleteAtIndex","get",
        "addAtIndex","get","addAtIndex","addAtTail","addAtTail","get","deleteAtIndex","get","addAtHead","addAtTail","addAtIndex",
        "addAtIndex","addAtIndex","addAtHead","addAtTail","addAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtTail","get",
        "addAtTail","addAtIndex","addAtHead","deleteAtIndex","addAtHead","deleteAtIndex","get","get","addAtTail","addAtIndex","get",
        "deleteAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtIndex","get","addAtTail","addAtHead","addAtIndex","get",
        "addAtHead","deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtTail","addAtHead",
        "addAtHead","deleteAtIndex","get","addAtHead"};

        int[][] arr = new int [][] {{},{55},{1,90},{51},{91},{12},{2,72},{17},{82},{4},{7},{7},{5,75},{54},{6},{2},{8},{35},{36},
        {10},{40},{43},{12},{3},{78},{89},{3,41},{10},{96},{5,37},{51},{26},{16,91},{18},{11},{66},{22,20},{44},{17,16},{95},{2},
        {14,2},{99},{51},{1},{11},{22,99},{20},{25,42},{72},{45},{2},{4},{32},{55},{84},{32,64},{26,14},{30,80},{88},{51},{27,71},
        {15},{8},{60},{37},{25},{96},{25,53},{36},{8},{85},{42},{20},{34},{78},{42,76},{26},{30},{39},{27},{93},{19,75},{8},{24},
        {32},{25,98},{21},{95},{18},{45},{24},{38},{8},{20},{83},{71},{78},{55},{29},{11},{84}};

        int i = 1;
        for (String str : strArr) {
            switch (str) {
                case "addAtHead":
                    System.out.println("addAtHead: " + arr[i][0]);
                    myLinkedList.addAtHead(arr[i++][0]);
                    myLinkedList.showLinkedList();
                    break;
                case "addAtTail":
                    System.out.println("addAtTail" + arr[i][0]);
                    myLinkedList.addAtTail(arr[i++][0]);
                    myLinkedList.showLinkedList();
                    break;
                case "addAtIndex":
                    System.out.println("addAtIndex at " + arr[i][1]);
                    myLinkedList.addAtIndex(arr[i][0], arr[i++][1]);
                    myLinkedList.showLinkedList();
                    break;
                case "get":
                    System.out.println("get at " + arr[i][0]);
                    System.out.println(myLinkedList.get(arr[i++][0]));
                    myLinkedList.showLinkedList();
                    break;
                case "deleteAtIndex":
                    System.out.println("deleteAtIndex at " + arr[i][0]);
                    myLinkedList.deleteAtIndex(arr[i++][0]);
                    myLinkedList.showLinkedList();
                    break;
                case "MyLinkedList":
                    myLinkedList = new MyLinkedList();
                    myLinkedList.showLinkedList();
                    break;
            }
        }
        
    }

    public void showLinkedList() {
        MyLinkedList temp = head;
        System.out.println("");
        System.out.println("Linked list status : ------------------- ");
        System.out.println("");
        while(temp!=null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("");
        System.out.println("--------------------------");
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */