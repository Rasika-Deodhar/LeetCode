import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return null;
        }
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> l1 = Arrays.asList(list1);
        List<String> l2 = Arrays.asList(list2);
        List<String> result = new ArrayList<>();

        int min_length = Math.min(l1.size(), l2.size());

        for (int i = 0; i < min_length; i++) {
            if (l2.contains(l1.get(i))) {
                hm.put(l1.get(i), i + l2.indexOf(l1.get(i)));
            }
        }
        if (l1.size() != min_length) {
            for (int i = min_length; i < l1.size(); i++) {
                if (l2.contains(l1.get(i))) {
                    hm.put(l1.get(i), i + l2.indexOf(l1.get(i)));
                }
            }
        }

        // https://stackoverflow.com/a/2581754
        List<Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(Entry.comparingByValue());
        Map<String, Integer> res = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list) {
            res.put(entry.getKey(), entry.getValue());
        }

        int min_value = -1;
        for (Entry<String, Integer> entry : res.entrySet()) {
            if (!result.contains(entry.getKey()) && min_value == -1) {
                result.add(entry.getKey());
            } else if (!result.contains(entry.getKey()) && min_value == entry.getValue()) {
                result.add(entry.getKey());
            } else if (min_value < entry.getValue()) {
                break;
            }
            min_value = entry.getValue();
        }

        // https://stackoverflow.com/a/4042464
        return result.toArray(new String[result.size()]);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] res = s.findRestaurant(new String[] { "S", "TEXP", "BK", "KFC" }, new String[] { "KFC", "BK", "S" });
        for (String string : res) {
            System.out.println(string);
        }
    }

    // Avg Time Complexity = O(N)
    // Avg Space Complexity = O(N)

}