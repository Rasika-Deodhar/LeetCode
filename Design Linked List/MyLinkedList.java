import java.util.ArrayList;
import java.util.List;

class MyLinkedList {

    int val;
    MyLinkedList nextNode;
    int length;
    MyLinkedList head;
    MyLinkedList tail;

    public MyLinkedList() {
        val = 0;
        nextNode = null;
        head = null;
        tail = null;
        length = 0;
    }

    public int get(int index) {
        if (index == 0) {
            return head != null ? head.val : -1;
        } else if (index == length-1) {
            return tail != null ? tail.val : -1;
        } else if (index > length-1) {
            return -1;
        }
        int i = 0;
        MyLinkedList temp = head;
        while (i < index) {
            temp = temp.nextNode;
            i++;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        MyLinkedList newObj = new MyLinkedList();
        newObj.val = val;
        if (head == null) {
            head = newObj;
            tail = newObj;
        } else {
            newObj.nextNode = head;
            head = newObj;
        }
        length++;
    }

    public void addAtTail(int val) {
        MyLinkedList newObj = new MyLinkedList();
        newObj.val = val;
        if (tail == null) {
            head = newObj;
            tail = newObj;
        } else {
            tail.nextNode = newObj;
            tail = newObj;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else if (index == length-1) {
            MyLinkedList temp = head;
            while (temp.nextNode!=tail) {
                temp = temp.nextNode;
            }
            MyLinkedList newObj = new MyLinkedList();
            newObj.val = val;
            temp.nextNode = newObj;
            newObj.nextNode = tail;

            length++;
        } else if (index < length) {
            int i = 0;
            MyLinkedList temp = head;
            MyLinkedList temp_prev = head;
            while (i < index) {
                if (i == 0) {
                    temp = temp.nextNode;
                } else {
                    temp = temp.nextNode;
                    temp_prev = temp_prev.nextNode;
                }
                i++;
            }
            MyLinkedList newObj = new MyLinkedList();
            newObj.val = val;
            newObj.nextNode = temp;
            temp_prev.nextNode = newObj;

            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index > length-1) {
            return;
        }
        if (index == 0) {
            head = head.nextNode;
            length--;
        } else if(index == length-1) {
            MyLinkedList temp = head;
            MyLinkedList temp_prev = head;
            while(temp!=tail) {
                temp_prev = temp;
                temp = temp.nextNode;
            }
            temp_prev.nextNode = null;
            length--;
            return;
        } else {
            int i = 0;
            MyLinkedList temp = head;
            while (i++ < index-1) {
                temp = temp.nextNode;
            }
            temp.nextNode = temp.nextNode.nextNode;
            length--;
        }
        // else if (index == length) {
        // MyLinkedList temp = head;
        // MyLinkedList temp_prev = head;
        // while (temp.nextNode != null) {
        // temp_prev = temp;
        // temp = temp.nextNode;
        // }
        // temp_prev.nextNode = null;
        // }
    }

    public void showLinkedList() {
        MyLinkedList temp = head;
        System.out.println("");
        System.out.println("Linked list status : ------------------- ");
        System.out.println("");
        while(temp!=null) {
            System.out.print(temp.val + " -> ");
            temp = temp.nextNode;
        }
        System.out.println("");
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = null;
        // String[] strArr = new String[] { "MyLinkedList","addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtTail",
        //         "addAtTail", "addAtIndex", "deleteAtIndex", "deleteAtIndex", "addAtTail" };
        String[] strArr = new String[] { "MyLinkedList","addAtHead","get","addAtHead","addAtHead",
                                        "deleteAtIndex","addAtHead","get","get","get","addAtHead", "addAtIndex","deleteAtIndex" };

        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<Integer>() {
            {}
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(4);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(1);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(1);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(5);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(3);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(7);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(3);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(3);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(3);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(1);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(4);
                add(41);
            }
        });arrayList.add(new ArrayList<Integer>() {
            {
                add(4);
            }
        });

        int i = 1;
        for (String str : strArr) {
            switch (str) {
                case "addAtHead":
                    System.out.println("addAtHead");
                    myLinkedList.addAtHead(arrayList.get(i++).get(0));
                    myLinkedList.showLinkedList();
                    break;
                case "addAtTail":
                    System.out.println("addAtTail");
                    myLinkedList.addAtTail(arrayList.get(i++).get(0));
                    myLinkedList.showLinkedList();
                    break;
                case "addAtIndex":
                    System.out.println("addAtIndex at " + arrayList.get(i).get(1));
                    myLinkedList.addAtIndex(arrayList.get(i).get(0), arrayList.get(i++).get(1));
                    myLinkedList.showLinkedList();
                    break;
                case "get":
                    System.out.println("get at " + arrayList.get(i).get(0));
                    System.out.println(myLinkedList.get(arrayList.get(i++).get(0)));
                    myLinkedList.showLinkedList();
                    break;
                case "deleteAtIndex":
                    System.out.println("deleteAtIndex at " + arrayList.get(i).get(0));
                    myLinkedList.deleteAtIndex(arrayList.get(i++).get(0));
                    myLinkedList.showLinkedList();
                    break;
                case "MyLinkedList":
                    myLinkedList = new MyLinkedList();
                    myLinkedList.showLinkedList();
                    break;
            }
        }
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