import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
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

    // Bad Solution

    // public int firstUniqChar(String s) {

    //     HashSet<Character> hs = new LinkedHashSet<>();
    //     List<Character> list = new ArrayList<>();

    //     for (int i = 0; i < s.length(); i++) {
    //         if(!list.contains(s.charAt(i))){
    //             if(!hs.add(s.charAt(i))){
    //                 list.add(s.charAt(i));
    //                 hs.remove(s.charAt(i));
    //             }
    //         }
    //     }

    //     return hs.isEmpty() ? -1 : s.indexOf(hs.iterator().next()) ;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("aabb"));
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}