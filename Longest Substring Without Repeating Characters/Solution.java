import java.util.HashMap;
import java.util.Map;

class Solution {

    // Solution not suitable for all test-cases
    public int lengthOfLongestSubstring(String s) {

        // Not suitable for all codes
        // if (s.equals(" ") || s.length() == 1) {
        // return 1;
        // }

        // int result = 0;
        // Map<String, Integer> m = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        // if (!m.containsKey(s.substring(i, i + 1))) {
        // m.put(s.substring(i, i + 1), 1);
        // } else {
        // result = m.size() > result ? m.size() : result;
        // m.clear();
        // --i;
        // }
        // }

        // result = m.size() > result ? m.size() : result;

        // return result;

        // Sliding Window Problem
        if (s.equals(" ") || s.length() == 1) {
            return 1;
        }

        int result = 0;
        Map<String, Integer> m = new HashMap<>();

        for (int i = 0, j = i + 1; i < s.length() && j < s.length();) {
            if (!m.containsKey(s.substring(i, j)) && s.substring(i, j).contains(s.subSequence(i, i + 1))) {
                // TODO
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        // System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}