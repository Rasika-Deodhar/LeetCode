import java.util.Scanner;

class Solution {
    public int removeDuplicates(int[] nums) {

        //Very long solution - not much optimized
        int duplicate = 0, flag = 0, i = 0, j = 0;

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        while (i < nums.length) {
            if (j < nums.length - 1 && nums[j] != -100000 && nums[j] != nums[j + 1]) {
                duplicate++;
            }
            if (j == nums.length-1 && nums[j] != -100000 && nums[j] != nums[j - 1]) {
                duplicate++;
            }
            while (j < nums.length - 1 && nums[j] != -100000 && nums[j] == nums[j + 1]) {
                flag++;
                j++;
            }
            if (flag > 0 && j <= nums.length - 1)
                duplicate++;
            while (flag > 0) {
                for (int k = i; k < nums.length - 1; k++) {
                    nums[k] = nums[k + 1];
                    if (k == nums.length - 2) {
                        nums[k + 1] = -100000;
                    }
                }
                flag--;
            }
            i++;
            j = i;
            flag = 0;
        }

        return duplicate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] arr = new int[m];
        int i = 0;
        while (m-- > 0) {
            arr[i++] = sc.nextInt();
        }

        Solution s = new Solution();
        System.out.println(s.removeDuplicates(arr));

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        sc.close();
    }
}