public class Solution {

    public static boolean validMountainArray(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        int flag = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (diff(arr[i], arr[i + 1]) > 0 && flag == 0 && i == 0) {
                return false;
            }
            if (diff(arr[i], arr[i + 1]) > 0 && flag == 0) {
                flag = 1;
            }
            if (diff(arr[i], arr[i + 1]) < 0 && flag == 1) {
                return false;
            }
            if (diff(arr[i], arr[i + 1]) == 0) {
                return false;
            }
        }

        return flag == 1 ? true : false;

    }

    private static int diff(int i, int j) {
        return i - j;
    }

    public static void main(String[] args) {
        // Not so optimized solution
        System.out.println(Solution.validMountainArray(new int[] { 2, 1, 0 }));
    }

    // Time Complexity - O(N)
    // Best Case - O(1), Avg & Worst Case - O(N)
    // Space Complexity - O(E[x] of flag variable) = O(1/2)
}