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

        Arrays.sort(nums);

        int res = 0, sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            if (sum - sum1 >= target) {
                res = nums.length - (i + 1);
            } else {
                return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution.minSubArrayLen(15, new int[] { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 }));
    }
}
