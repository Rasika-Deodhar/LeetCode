class Solution {
    public static int thirdMax(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, flag = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                flag = 1;
                continue;
            }
            if (nums[i] > max1) {
                if (max1 == Integer.MIN_VALUE) {
                    max1 = nums[i];
                    continue;
                }
                if (max2 == Integer.MIN_VALUE) {
                    max2 = max1;
                    max1 = nums[i];
                    continue;
                }
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                continue;
            }
            if (nums[i] < max1 && nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
                continue;
            }
            if (nums[i] < max2 && max3 < nums[i]) {
                max3 = nums[i];
            }
        }

        return max3 != Integer.MIN_VALUE ? max3 : flag == 1 ? (max2 == Integer.MIN_VALUE ? max1 : max3) : max1;

    }

    public static void main(String[] args) {
        System.out.println(Solution.thirdMax(new int[] { -2147483648, 1, 1 }));
    }

    // Time Complexity -
    // Best Case -> no 3rd max element -> Less assignments of variable/swapping ->
    // O(N)
    // Avg Case -> 3rd max element in beginning -> Avg assignments of
    // variable/swapping -> O(N)
    // Worst Case -> 3rd max element in the end -> More assignments of variable/
    // swapping -> O(N)

    // Space Complexity = O(1) -> No extra space

    // Better Solution -> consider max1, max2 and max3 as Long.MIN_VALUE instead of
    // INTEGER.MIN_VALUE
}