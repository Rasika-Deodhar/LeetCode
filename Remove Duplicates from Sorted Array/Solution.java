import java.util.Scanner;

class Solution {
    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
        }

        int i = 0, j = 0;
        while (i++ < count) {
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            nums[i] = nums[j++ + 1];
        }

        System.out.println("--Array---");
        for (int k : nums) {
            System.out.println(k);
        }
        System.out.println("---Solution--");

        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(Solution.removeDuplicates(new int[] { 1, 2, 3, 4, 5 }));
    }

    // Time Complexity -
    // Best Case = No repeated elements -> O(1) -> only calculate the count
    // Avg Case = Few elements repeated -> O(N)
    // Worst Case = Many elements repeated -> O(N)

    // Space Complexity -> O(N)
}