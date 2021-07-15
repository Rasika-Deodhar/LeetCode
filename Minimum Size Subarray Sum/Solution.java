import java.util.Arrays;

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return 1;
            }
            sum += nums[i];
        }

        if (sum < target) {
            return 0;
        }
        if (sum == target) {
            return nums.length;
        }

        int res = 0;
        for (int i = 0, j = 0, sum1 = nums[i]; i <= nums.length - 1;) {
            if (sum1 >= target) {
                res = res != 0 ? (j - i + 1 < res ? j - i + 1 : res) : j - i + 1;
                i++;
                j = i;
                sum1 = 0;
            } else if (sum1 < target) {
                j++;
            }
            if (i == nums.length || j == nums.length) {
                break;
            }
            sum1 = sum1 + nums[j];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution.minSubArrayLen(6, new int[] { 10, 2, 3 }));
    }

    // Time Complexity -
    // Best Case -> sum <= target -> O(1)
    // Avg or Worst case -> contiguous sub-array within the array -> O(N)

    // Space Complexity -
    // O(1)
}
