class Solution {
    public int removeElement(int[] nums, final int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
                for (int j = i; j < nums.length; j++) {
                    if (j == nums.length - 1) {
                        nums[j] = -1;
                    } else {
                        nums[j] = nums[j + 1];
                    }
                }
                i--;
            }
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }

        return nums.length - count;
    }

    public static void main(final String args[]) {
        final Solution s = new Solution();
        System.out.println(s.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
    }
}