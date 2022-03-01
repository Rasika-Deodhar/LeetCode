import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    // Solution not suitable for all test-cases
    public int lengthOfLongestSubstring(String s) {

        // Not suitable for all test cases
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

        // Sliding Window Problem Way -> refered
        // https://www.youtube.com/watch?v=3IETreEybaA
        if (s.equals(" ") || s.length() == 1) {
            return 1;
        }

        int result = 0;
        HashSet<Character> chars = new HashSet<>();

        for (int i = 0, j = 0; j < s.length();) {
            if (!chars.contains(s.charAt(j))) {
                chars.add(s.charAt(j));
                result = result < chars.size() ? chars.size() : result;
                j++;
            } else {
                chars.remove(s.charAt(i));
                i++;
            }
        }

        return result;

        // Time Complexity -> O(n)
        // Space Complexity -> O(n)

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}