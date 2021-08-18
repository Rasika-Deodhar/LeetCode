import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        List<List<String>> result = new ArrayList<>();

        if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        }

        HashMap<String, Integer> hm = new HashMap<>();
        int index = 0;
        for (String list : strs) {
            char[] ch = list.toCharArray();
            Arrays.sort(ch);
            String rev_ch = String.valueOf(ch);
            if (!hm.containsKey(rev_ch)) {
                hm.put(rev_ch, index++);
            }
        }

        for (int i = 0; i < index; i++) {
            result.add(new ArrayList<>());
        }

        for (String list : strs) {
            char[] ch = list.toCharArray();
            Arrays.sort(ch);
            String rev_ch = String.valueOf(ch);
            result.get(hm.get(rev_ch)).add(list);
        }

        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> result = s.groupAnagrams(new String[] { "a" });
        for (List<String> list : result) {
            for (String list2 : list) {
                System.out.print(list2 + " ");
            }
            System.out.println();
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}