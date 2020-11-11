import java.util.Scanner;

public class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i < arr.length - 1) {
                for (int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
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
        s.duplicateZeros(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        sc.close();
    }
}
