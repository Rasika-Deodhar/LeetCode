import java.util.Scanner;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }

        for (int k2 = 0; k2 < res.length; k2++) {
            nums1[k2] = res[k2];
            System.out.print(nums1[k2] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int m = sc.nextInt();
        // int[] arr1 = new int[m];
        // int i = 0;
        // while (m-- > 0) {
        //     arr1[i++] = sc.nextInt();
        // }

        // int n = sc.nextInt();
        // int[] arr2 = new int[n];
        // i = 0;
        // while (n-- > 0) {
        //     arr2[i++] = sc.nextInt();
        // }

        Solution s = new Solution();
        // s.merge(arr1, 3, arr2, 3);
        s.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);

        sc.close();
    }
}
