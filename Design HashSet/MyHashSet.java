// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;

// class MyHashSet {
//     public Map<Integer, ArrayList<Integer>> map = new HashMap<>();

//     //try using arraylist

//     /** Initialize your data structure here. */
//     public MyHashSet() {
//         map.put(0, new ArrayList<>());
//         map.put(1, new ArrayList<>());
//         map.put(2, new ArrayList<>());
//         map.put(3, new ArrayList<>());
//         map.put(4, new ArrayList<>());
//         map.put(5, new ArrayList<>());
//         map.put(6, new ArrayList<>());
//         map.put(7, new ArrayList<>());
//         map.put(8, new ArrayList<>());
//         map.put(9, new ArrayList<>());
//     }

//     public void add(final int key) {
//         ArrayList<Integer> m = map.get(key%10);
//         if(!contains(key))
//             m.add(Integer.valueOf(key));
//     }

//     public void remove(final int key) {
//         ArrayList<Integer> m = map.get(key%10);
//         if(contains(key))
//             m.remove(Integer.valueOf(key));
//     }

//     /** Returns true if this set contains the specified element */
//     public boolean contains(final int key) {
//         ArrayList<Integer> m = map.get(key%10);
//         if(m.contains(key))
//             return true;
//         else
//             return false;
//     }

//     public static void main(String args[]) {
//         MyHashSet obj = new MyHashSet();
//         int key=1;
//         obj.add(key);
//         obj.remove(key);
//         System.out.println(obj.contains(key));
//     }
// }

//SOLUTION 2

// /**
//  * Your MyHashSet object will be instantiated and called as such:
//  * MyHashSet obj = new MyHashSet();
//  * obj.add(key);
//  * obj.remove(key);
//  * boolean param_3 = obj.contains(key);
//  */

import java.util.ArrayList;

class MyHashSet {
    public ArrayList<Integer> l;

    //try using arraylist

    /** Initialize your data structure here. */
    public MyHashSet() {
       l = new ArrayList<>(10000);
    }

    public void add(final int key) {
        if(!contains(key))
            l.add(key);
    }

    public void remove(final int key) {
        if(contains(key))
            l.remove(Integer.valueOf(key));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(final int key) {
        if(l.contains(key))
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        MyHashSet obj = new MyHashSet();
        int key=1;
        obj.add(key);
        obj.remove(key);
        System.out.println(obj.contains(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */