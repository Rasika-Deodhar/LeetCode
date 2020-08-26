import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add(String.valueOf(1));
        } else {
            int i = 1;
            while (i <= n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    result.add("Fizz");
                } else if (i % 3 != 0 && i % 5 == 0) {
                    result.add("Buzz");
                } else if (i % 3 == 0 && i % 5 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add(String.valueOf(i));
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.fizzBuzz(15);
        for (String str : result) {
            System.out.println(str);
        }
    }
}