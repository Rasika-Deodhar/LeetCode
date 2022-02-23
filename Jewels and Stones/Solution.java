import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int result = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(stones.substring(i, i + 1))) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(s.numJewelsInStones("z", "ZZ"));
    }

    // Time Complexity = O(n) -> n- length of stones
    // Space Complexity = O(1)
}