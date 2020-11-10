import java.util.Scanner;

class Solution {
    public int findNumbers(int[] nums) {

        int even_count = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            count = 0;
            while (nums[i] / 10 != 0) {
                nums[i] = nums[i] / 10;
                count++;
            }
            count++;

            if (count % 2 == 0)
                even_count++;
        }

        return even_count;
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
        System.out.println(s.findNumbers(arr));
        sc.close();
    }
}