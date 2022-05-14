import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target-nums[i]);
                result[1] = i;
                break;
            }
            hashMap.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[] { 2,7,11,15 }, 9);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}