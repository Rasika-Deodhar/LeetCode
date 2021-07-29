class MyHashMap {

    int[][] map;
    int i;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[10000][2];
        i = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        if (get(key) != -1) {
            for (int[] is : map) {
                if (is[0] == key) {
                    is[1] = value;
                }
            }
            return;
        }

        map[i][0] = key;
        map[i][1] = value;
        i++;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int j = 0;
        for (int[] is : map) {
            if (is[0] == key) {
                return is[1];
            }
            if (j++ == i) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int j = 0;

        for (int[] is : map) {
            if (is[0] == key) {
                break;
            }
            j++;
        }

        for (; j <= i && j < map[0].length; j++) {
            map[j][0] = map[j + 1][0];
            map[j][1] = map[j + 1][1];
        }
    }

    public static void main(String[] args) {
        MyHashMap mhm = new MyHashMap();
        mhm.put(1, 1);
        mhm.put(2, 2);
        System.out.println(mhm.get(1));
        System.out.println(mhm.get(3));
        mhm.put(2, 1);
        System.out.println(mhm.get(2));
        mhm.remove(2);
        System.out.println(mhm.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */