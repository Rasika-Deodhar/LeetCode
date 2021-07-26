import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static void rotate(int[] nums, int k) {

        // ** O(1) space attempt */

        // if (nums == null || nums.length == 0 || nums.length == 1) {
        // return;
        // }
        // if (k == 0 || k == nums.length) {
        // for (int i : nums) {
        // System.out.println(i);
        // }
        // } else {
        // if (nums.length < k) {
        // // for (int i = 0, j = nums.length - 1; i < nums.length && j > 0; i++, j--) {
        // // int temp = nums[i];
        // // nums[i] = nums[j];
        // // nums[j] = temp;
        // // }

        // k = k - nums.length;
        // }
        // int i1 = 0, i2 = nums.length - k - 1, j1 = i2 + 1, j2 = nums.length - 1, i =
        // i1, j = j1;

        // do {
        // while (i <= i2 && j <= j2) {
        // int temp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = temp;
        // i++;
        // j++;
        // }
        // if (i <= i2) {
        // j = i2 + 1;
        // j2 = nums.length - 1;
        // } else if (j <= j2) {
        // // i = j - (j2 - j + 1);
        // i = j - 1;
        // i2 = j - 1;
        // }
        // } while (i <= i2 && j <= j2);

        // for (int l : nums) {
        // System.out.println(l);
        // }
        // }

        // ** Simple approach */
        // Time Complexity -> Best = Edge cases, Avg + Worst = O(N)
        // Space complexity -> O(N)

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        if (nums.length - 1 == k) {
            Collections.reverse(Arrays.asList(nums));
        }
        while (nums.length < k) {
            k = k - nums.length;
        }

        int[] result = new int[nums.length];
        int i = 0, j = 0;

        for (i = 0, j = nums.length - k; j < nums.length; i++, j++) {
            result[i] = nums[j];
        }
        for (j = 0; j < nums.length - k && i < nums.length; j++) {
            result[i++] = nums[j];
        }

        for (int j2 = 0; j2 < result.length; j2++) {
            nums[j2] = result[j2];
        }

        for (int r : nums) {
            System.out.println(r);
        }

    }

    public static void main(String[] args) {
        // Solution.rotate(new int[] { -1, -100, 3, 99 }, 2);
        Solution.rotate(new int[] { 1, 2 }, 3);
    }
}