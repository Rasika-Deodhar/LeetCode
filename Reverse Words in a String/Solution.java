class Solution {
    public static String reverseWords(String s) {

        char[] res = s.replaceAll("\\s{2,}", " ").trim().toCharArray();
        char[] res1 = new char[res.length];

        int i = 0, j = 0, k = 0, r = 0;

        for (i = res.length - 1, j = res.length - 1; i >= 0 && j >= 0; j--) {
            if (res[j] != ' ') {
                continue;
            }

            for (k = j + 1; k <= i; k++) {
                res1[r++] = res[k];
            }
            res1[r++] = ' ';
            i = --j;
        }

        if (j < 0 && r < res.length) {
            for (k = 0; k <= i; k++) {
                res1[r++] = res[k];
            }
        }

        return String.valueOf(res1);

    }

    public static void main(String[] args) {
        // System.out.println(Solution.reverseWords(" the cat rat frog "));
        System.out.println(Solution.reverseWords("  the  "));

        // Time Complexity ->
        // Best Case = 1 word = O(1)
        // Avg Case or Worst Case = More spaces + More words = O(N)

        // Space Complexity -> O(N)
    }
}