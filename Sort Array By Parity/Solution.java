class Solution {
    public static int[] sortArrayByParity(int[] nums) {

        if (nums != null || nums.length > 1) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0) {
                    count++;
                }
            }

            for (int i = 0, r = 0; i < nums.length && r < count; i++) {
                if (nums[i] % 2 == 0) {
                    int temp = nums[i];
                    nums[i] = nums[r];
                    nums[r++] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String args[]) {
        int[] arr = Solution.sortArrayByParity(new int[] { 1, 2, 3, 4 });

        for (int i : arr) {
            System.out.println(i);
        }

        // Time Complexity -
        // Best case -> all even numbers or all odd numbers, no swapping = O(1)
        // Avg Case -> few even numbers -> few swaps = O(N)
        // Worst Case -> many even numbers -> max swaps = O(N)

        // Space Complexity = O(1) -> No extra array used
    }
}