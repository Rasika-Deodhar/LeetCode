import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsValue(target - nums[i])) {
                result[0] = Solution.getKeyByValue(hashMap, target - nums[i]);
                result[1] = i;
                break;
            }
            hashMap.put(i, nums[i]);
        }

        return result;
    }

    public static int getKeyByValue(Map<Integer, Integer> hashMap, int value) {
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[] { 3, 3 }, 6);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}