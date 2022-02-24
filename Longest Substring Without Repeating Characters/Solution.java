import java.util.HashMap;
import java.util.Map;

class Solution {

    // Solution not suitable for all test-cases
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!m.containsKey(s.substring(i, i + 1))) {
                m.put(s.substring(i, i + 1), 1);
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}