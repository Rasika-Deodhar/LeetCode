class Solution {
    public static String reverseWords(String s) {

        StringBuffer str_buff = new StringBuffer();
        char[] str = s.toCharArray();
        int i = 0, j = 0, k = 0;

        for (i = 0, j = 0, k = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                for (j = i - 1; j >= k; j--) {
                    str_buff.append(str[j]);
                }
                str_buff.append(' ');
                k = i + 1;
            }
        }
        for (j = i - 1; j >= k; j--) {
            str_buff.append(str[j]);
        }

        return str_buff.toString();

    }

    public static void main(String[] args) {
        System.out.println(Solution.reverseWords("Let's take LeetCode contest"));
    }

    // Time Complexity -> O(N) (In any case)
    // Space Complexity -> O(N)
}