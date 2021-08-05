import java.util.Arrays;

class Solution {
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int i = 0;
        for (i = 0; i < nums.length - 2;) {
            if (nums[i] == nums[i + 1]) {
                i += 2;
                continue;
            } else if (nums[i] != nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                return nums[i];
            }
            i++;
        }

        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(Solution.singleNumber(new int[] { 1 }));
    }

    // Time Complexity = O(n logn + n) = O(n)
    // Space Complexity = O(1)
}