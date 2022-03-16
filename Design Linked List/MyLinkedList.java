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
        } else if (index == length) {
            return head != null ? tail.val : -1;
        } else if (index > length) {
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
        if (index == 0) {
            head = head.nextNode;
        } else if (index < length) {
            int i = 0;
            MyLinkedList temp = head;
            MyLinkedList temp_prev = head;
            while (i++ < index) {
                temp_prev = temp;
                temp = temp.nextNode;
            }
            temp_prev.nextNode = temp.nextNode;
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
        length--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String[] strArr = new String[] { "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtIndex", "addAtTail",
                "addAtTail", "addAtIndex", "deleteAtIndex", "deleteAtIndex", "addAtTail" };

        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<Integer>() {
            {
                add(0);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(1);
                add(4);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(8);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(5);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(4);
                add(3);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(0);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(5);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(6);
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
                add(5);
            }
        });
        arrayList.add(new ArrayList<Integer>() {
            {
                add(4);
            }
        });

        int i = 0;
        for (String str : strArr) {
            switch (str) {
                case "addAtHead":
                    myLinkedList.addAtHead(arrayList.get(i++).get(0));
                    break;
                case "addAtTail":
                    myLinkedList.addAtTail(arrayList.get(i++).get(0));
                    break;
                case "addAtIndex":
                    myLinkedList.addAtIndex(arrayList.get(i).get(0), arrayList.get(i++).get(1));
                    break;
                case "get":
                    System.out.println(myLinkedList.get(arrayList.get(i++).get(0)));
                    break;
                case "deleteAtIndex":
                    myLinkedList.deleteAtIndex(arrayList.get(i++).get(0));
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