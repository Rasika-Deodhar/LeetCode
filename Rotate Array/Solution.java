import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        if (k == 0 || k == nums.length) {
            for (int i : nums) {
                System.out.println(i);
            }
        } else {
            if (nums.length < k) {
                // for (int i = 0, j = nums.length - 1; i < nums.length && j > 0; i++, j--) {
                // int temp = nums[i];
                // nums[i] = nums[j];
                // nums[j] = temp;
                // }

                k = k - nums.length;
            }
            int i1 = 0, i2 = nums.length - k - 1, j1 = i2 + 1, j2 = nums.length - 1, i = i1, j = j1;

            do {
                while (i <= i2 && j <= j2) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j++;
                }
                if (i <= i2) {
                    j = i2 + 1;
                    j2 = nums.length - 1;
                } else if (j <= j2) {
                    // i = j - (j2 - j + 1);
                    i = j - 1;
                    i2 = j - 1;
                }
            } while (i <= i2 && j <= j2);

            for (int l : nums) {
                System.out.println(l);
            }
        }

    }

    public static void main(String[] args) {
        Solution.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
        // Solution.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 6);
    }
}