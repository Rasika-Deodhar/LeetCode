import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {

        if (N == 1)
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        List<Integer> numbers = new ArrayList<>();

        // Failing larger test cases -> time limit exceeded
        // int initial_number = (int) Math.pow(10, N - 1);
        // int last_number = (int) Math.pow(10, N);

        // while (initial_number < last_number) {

        // // check if its 2 decimal places subtract to k till end
        // int power = N - 1;

        // while (power > 0) {
        // int a = (initial_number / (int) Math.pow(10, power)) % 10;
        // int b = (initial_number / (int) Math.pow(10, power - 1)) % 10;
        // if (Math.abs(a - b) == K) {
        // power--;
        // } else {
        // break;
        // }
        // }
        // if (power == 0) {
        // numbers.add(initial_number);
        // }

        // initial_number++;
        // }

        // DFS solution
        for (int num = 1; num < 10; num++)
            dfs(N - 1, num, K, numbers);

        int[] nums = numbers.stream().mapToInt(m -> m.intValue()).toArray();
        return nums;
    }

    private void dfs(int N, int num, int K, List<Integer> numbers) {

        // if power is 0, then add the number to list and return
        if (N == 0) {
            numbers.add(num);
            return;
        }

        // if n+k is less than 10, then add it to the right
        if (num % 10 + K < 10)
            dfs(N - 1, num * 10 + num % 10 + K, K, numbers);

        // if n-k is greater than or equal to 0 then add it to the right
        if (K > 0 && num % 10 - K >= 0)
            dfs(N - 1, num * 10 + num % 10 - K, K, numbers);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.numsSameConsecDiff(7, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}