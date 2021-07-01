public class Solution {
    public static void moveZeroes(int[] nums) {
        int count = 0;
        if (nums != null || nums.length > 2) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    count++;
                }
            }

            for (int i = 0, j = 0; i < nums.length && j < count; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }

            for (int i = count; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Solution.moveZeroes(new int[] { 1, 0, 2, 3, 3, 8, 6, 14 });
    }

    // Time Complexity -
    // Best Case -> All zeros or All non-zeros, no swapping/ placing of elements =
    // O(1)
    // Avg Case -> Few non-zeros or zeros, less swapping or placing of elements =
    // O(N)
    // Worst Case -> Just 1 zero element, swapping all elements = O(N)

    // Space complexity = O(1)
}
