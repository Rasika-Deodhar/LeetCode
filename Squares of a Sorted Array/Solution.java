import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] S = new int[A.length];
        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            S[i] = (int) Math.pow(A[i], 2);
        }

        Arrays.sort(S);
        for (int i = S.length - 1; i >= 0; i--) {
            res[i] = S[i];
        }

        return res;
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
        int[] result = s.sortedSquares(arr);
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
        sc.close();
    }
}