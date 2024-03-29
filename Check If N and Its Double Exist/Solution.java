import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean checkIfExist(int[] arr) {

        // Non-optimized solution
        // List<Integer> even = new ArrayList<>();
        // int zero = 0;

        // if (arr == null || arr.length < 2)
        // return false;

        // for (int i = 0; i < arr.length; i++) {
        // if (arr[i] == 0)
        // zero++;
        // if (!even.contains(arr[i]) && arr[i] != 0) {
        // if (arr[i] % 2 == 0)
        // even.add(arr[i]);
        // }
        // }

        // if (zero > 1)
        // return true;

        // for (int i = 0; i < arr.length; i++) {
        // if (even.contains(arr[i] * 2))
        // return true;
        // }
        // return false;

        // Leetcode Fresh Look - without completely referring to best solution
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
                return true;
            }
            if (set.contains(arr[i] * 2)) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkIfExist(new int[] { -2, 0, 10, -19, 4, 6, -8 }));
    }
}
