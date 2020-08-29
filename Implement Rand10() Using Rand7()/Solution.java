import java.util.HashMap;
import java.util.Map;

/**
 * The rand7() API is already defined in the parent class SolBase. public int
 * rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int n;
    Map<Integer, Integer> map;

    Solution() {
        this.n = 1;
        map.put(1, -1);
        map.put(2, -1);
        map.put(3, -1);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
    }

    Solution(int n) {
        this.n = n;
        this.map = new HashMap<>();
        map.put(1, -1);
        map.put(2, -1);
        map.put(3, -1);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
    }

    public int rand10() {
        int rand7 = rand7();
        if (rand7 > 3 && map.containsKey(Integer.valueOf(rand7))) {
            return map.get(Integer.valueOf(rand7)).intValue();
        }
        if (map.get(rand7) == -1) {
            map.put(rand7, 0);
            return rand7 + 7;
        }
        map.put(rand7, -1);
        return rand7;
    }

    public static void main(String[] args) {
        Solution s = new Solution(1);
        int n = s.n;
        while (n > 0) {
            System.out.println(s.rand10());
            n--;
        }
    }
}