class Solution {
    public static int pivotIndex(final int[] nums) {

        int sum = 0, right_sum = 0, left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            right_sum = sum - nums[i] - left_sum;
            if (left_sum == right_sum) {
                return i;
            }
            left_sum += nums[i];
        }

        return -1;
    }

    public static void main(final String[] args) {
        System.out.println(Solution.pivotIndex(new int[] { 2, 1, -1 }));
    }

    // Time Complexity -
    // Best Case -> 0th element is Pivot element -> O(1)
    // Avg Case -> Pivot is between 0 and n-1 -> O(N)
    // Worst Case -> Pivot is at n-1 index or there is no pivot -> O(N)

    // Space Complexity = O(1)
}