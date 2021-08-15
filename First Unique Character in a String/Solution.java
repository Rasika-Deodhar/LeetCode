import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Solution {
    public int firstUniqChar(String s) {

        LinkedHashMap<Character, Integer> tm = new LinkedHashMap<>();
        int i = 0;

        for (char ch : s.toCharArray()) {
            if (!tm.containsKey(ch)) {
                tm.put(ch, i);
            } else {
                tm.put(ch, -1);
            }
            i++;
        }

        for (Entry<Character, Integer> map : tm.entrySet()) {
            if (map.getValue() != -1) {
                return map.getValue().intValue();
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("dddccdbba"));
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}