public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(String s) {
        // String s = String.valueOf(n);
        int a = Integer.valueOf(s);
        System.out.println(a);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("1"))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight("11111111111111111111111111111101"));
    }
}