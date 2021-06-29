import java.util.Arrays;

public class Solution {

    public static int[] replaceElements(int[] arr) {

        if (arr.length < 1) {
            return arr;
        }
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        if (arr.length == 2) {
            arr[0] = arr[1];
            arr[1] = -1;
            return arr;
        }

        arr[0] = max_element(Arrays.copyOfRange(arr, 1, arr.length));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i] && i < arr.length - 1) {
                arr[i] = max_element(Arrays.copyOfRange(arr, i + 1, arr.length));
            } else {
                arr[i] = arr[i - 1];
            }
            if (i == arr.length - 1) {
                arr[i] = -1;
            }
        }

        return arr;
    }

    private static int max_element(int[] copyOfRange) {
        int max = 0;
        for (int i : copyOfRange) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = Solution.replaceElements(new int[] { 1, 2, 3 });
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

    // Time Complexity -
    // Best Case = O(N) <- calc the max element just once/ last element is the
    // largest element
    // Avg Case = O(N^2) <- calc max element more than once
    // Worst Case = O(N^2) <- calc max element every time

    // Space Complexity - O(N)
}