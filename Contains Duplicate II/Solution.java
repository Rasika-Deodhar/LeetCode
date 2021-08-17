import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (Math.abs(i - hm.get(nums[i])) <= k) {
                    return true;
                } else {
                    hm.put(nums[i], i);
                }
            } else {
                hm.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(new int[] { 1, 2, 1 }, 2));
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}