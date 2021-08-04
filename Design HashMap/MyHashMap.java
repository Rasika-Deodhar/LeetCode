import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyHashMap {

    // int[][] map;
    // public static int i = -1;

    // /** Initialize your data structure here. */
    // public MyHashMap() {
    // map = new int[10000][2];
    // }

    // /** value will always be non-negative. */
    // public void put(int key, int value) {

    // if (i > 10000) {
    // return;
    // }

    // if (get(key) != -1) {
    // for (int[] is : map) {
    // if (is[0] == key) {
    // is[1] = value;
    // }
    // }
    // return;
    // }

    // if (MyHashMap.i == -1) {
    // MyHashMap.i = 0;
    // }

    // map[MyHashMap.i][0] = key;
    // map[MyHashMap.i][1] = value;
    // MyHashMap.i++;
    // }

    // /**
    // * Returns the value to which the specified key is mapped, or -1 if this map
    // * contains no mapping for the key
    // */
    // public int get(int key) {
    // int j = 0;
    // for (int[] is : map) {
    // if (is[0] == key) {
    // return is[1];
    // }
    // if (j++ == MyHashMap.i) {
    // return -1;
    // }
    // }
    // return -1;
    // }

    // /**
    // * Removes the mapping of the specified value key if this map contains a
    // mapping
    // * for the key
    // */
    // public void remove(int key) {
    // int j = 0;

    // if (get(key) == -1 || MyHashMap.i == -1) {
    // return;
    // }

    // for (int[] is : map) {
    // if (is[0] == key) {
    // break;
    // }
    // j++;
    // }

    // for (; j <= i && j < map.length - 1; j++) {
    // map[j][0] = map[j + 1][0];
    // map[j][1] = map[j + 1][1];
    // }
    // MyHashMap.i--;
    // }

    // Much better solution from Leetcode discussions -
    // https://leetcode.com/problems/design-hashmap/discuss/227081/Java-Solutions

    int[] map;

    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public int get(int key) {
        return map[key];
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap mhm = new MyHashMap();
        List<String> ops = new ArrayList<>();
        ops.addAll(Arrays.asList("MyHashMap", "remove", "put", "remove", "remove", "get", "remove", "put", "get",
                "remove", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "put",
                "put", "get", "put", "get", "put", "put", "get", "put", "remove", "remove", "put", "put", "get",
                "remove", "put", "put", "put", "get", "put", "put", "remove", "put", "remove", "remove", "remove",
                "put", "remove", "get", "put", "put", "put", "put", "remove", "put", "get", "put", "put", "get", "put",
                "remove", "get", "get", "remove", "put", "put", "put", "put", "put", "put", "get", "get", "remove",
                "put", "put", "put", "put", "get", "remove", "put", "put", "put", "put", "put", "put", "put", "put",
                "put", "put", "remove", "remove", "get", "remove", "put", "put", "remove", "get", "put", "put"));
        List<List<Integer>> numList = new ArrayList<>();
        numList.addAll(Arrays.asList(Arrays.asList(), Arrays.asList(27), Arrays.asList(65, 65), Arrays.asList(19),
                Arrays.asList(0), Arrays.asList(18), Arrays.asList(3), Arrays.asList(42, 0), Arrays.asList(19),
                Arrays.asList(42), Arrays.asList(17, 90), Arrays.asList(31, 76), Arrays.asList(48, 71),
                Arrays.asList(5, 50), Arrays.asList(7, 68), Arrays.asList(73, 74), Arrays.asList(85, 18),
                Arrays.asList(74, 95), Arrays.asList(84, 82), Arrays.asList(59, 29), Arrays.asList(71, 71),
                Arrays.asList(42), Arrays.asList(51, 40), Arrays.asList(33, 76), Arrays.asList(17),
                Arrays.asList(89, 95), Arrays.asList(95), Arrays.asList(30, 31), Arrays.asList(37, 99),
                Arrays.asList(51), Arrays.asList(95, 35), Arrays.asList(65), Arrays.asList(81), Arrays.asList(61, 46),
                Arrays.asList(50, 33), Arrays.asList(59), Arrays.asList(5), Arrays.asList(75, 89),
                Arrays.asList(80, 17), Arrays.asList(35, 94), Arrays.asList(80), Arrays.asList(19, 68),
                Arrays.asList(13, 17), Arrays.asList(70), Arrays.asList(28, 35), Arrays.asList(99), Arrays.asList(37),
                Arrays.asList(13), Arrays.asList(90, 83), Arrays.asList(41), Arrays.asList(50), Arrays.asList(29, 98),
                Arrays.asList(54, 72), Arrays.asList(6, 8), Arrays.asList(51, 88), Arrays.asList(13),
                Arrays.asList(8, 22), Arrays.asList(85), Arrays.asList(31, 22), Arrays.asList(60, 9), Arrays.asList(96),
                Arrays.asList(6, 35), Arrays.asList(54), Arrays.asList(15), Arrays.asList(28), Arrays.asList(51),
                Arrays.asList(80, 69), Arrays.asList(58, 92), Arrays.asList(13, 12), Arrays.asList(91, 56),
                Arrays.asList(83, 52), Arrays.asList(8, 48), Arrays.asList(62), Arrays.asList(54), Arrays.asList(25),
                Arrays.asList(36, 4), Arrays.asList(67, 68), Arrays.asList(83, 36), Arrays.asList(47, 58),
                Arrays.asList(82), Arrays.asList(36), Arrays.asList(30, 85), Arrays.asList(33, 87),
                Arrays.asList(42, 18), Arrays.asList(68, 83), Arrays.asList(50, 53), Arrays.asList(32, 78),
                Arrays.asList(48, 90), Arrays.asList(97, 95), Arrays.asList(13, 8), Arrays.asList(15, 7),
                Arrays.asList(5), Arrays.asList(42), Arrays.asList(20), Arrays.asList(65), Arrays.asList(57, 9),
                Arrays.asList(2, 41), Arrays.asList(6), Arrays.asList(33), Arrays.asList(16, 44),
                Arrays.asList(95, 30)));

        for (int k = 0; k < ops.size(); k++) {
            switch (ops.get(k)) {
                case "put":
                    mhm.put(numList.get(k).get(0), numList.get(k).get(1));
                    break;
                case "get":
                    System.out.println(mhm.get(numList.get(k).get(0)));
                    break;
                case "remove":
                    if (numList.size() > 0 && numList.get(k).size() > 0) {
                        mhm.remove(numList.get(k).get(0));
                    }
                    break;
                default:
                    continue;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */