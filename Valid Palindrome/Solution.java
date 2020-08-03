class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        if (s.length() == 1)
            return true;

        String regex = "[a-zA-Z0-9]+";
        int i = 0, j = s.length() - 1;
        while (i < j) {

            while ((i + 1) < s.length() && !s.substring(i, i + 1).matches(regex))
                i++;
            while ((j + 1) > 0 && !s.substring(j, j + 1).matches(regex))
                j--;

            if (i > j) {
                return true;
            }

            if (s.substring(i, i + 1).toLowerCase().equals(s.substring(j, j + 1).toLowerCase())) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(".,"));
    }
}