import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);
            } else {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = hm.entrySet().stream().max((a, b) -> a.getValue() > b.getValue() ? 1 : -1).get().getKey();
            hm.remove(result[i]);
        }

        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] result = s.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        int[] result = s.topKFrequent(new int[] { 1 }, 1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}