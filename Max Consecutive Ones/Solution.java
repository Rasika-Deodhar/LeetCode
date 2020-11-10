import java.util.Scanner;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0, prev_count = 0, i = 0;

        while (i < nums.length) {
            prev_count = count;
            count = 0;
            if (nums[i] == 1) {
                while (i < nums.length && nums[i] == 1) {
                    count++;
                    i++;
                }
            } else
                i++;

            if (prev_count > count)
                count = prev_count;
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int[] arr = new int[c];
        int i = 0;
        while (c-- > 0) {
            arr[i++] = sc.nextInt();
        }
        Solution s = new Solution();
        System.out.println(s.findMaxConsecutiveOnes(arr));
        sc.close();
    }
}