// class Solution {
//     public boolean isPalindrome(String s) {
//         if (s.length() == 0)
//             return true;
//         if (s.length() == 1)
//             return true;

//         String regex = "[a-zA-Z0-9]+";
//         int i = 0, j = s.length() - 1;

//         //while right pointer and left pointer do not inter-cross
//         while (i < j) {

//             //check if left pointer is alphanumeric, otherwise go ahead
//             while ((i + 1) < s.length() && !s.substring(i, i + 1).matches(regex))
//                 i++;
//             //check if right pointer is alphanumeric, otherwise go behind
//             while ((j + 1) > 0 && !s.substring(j, j + 1).matches(regex))
//                 j--;

//             // if both overlaps means only non-alphanumeric present or outer string are aplhanumeric & matching
//             if (i > j) {
//                 return true;
//             }

//             // check if the cuurent 2 aplanumeric chars match each other, else return false
//             if (s.substring(i, i + 1).toLowerCase().equals(s.substring(j, j + 1).toLowerCase())) {
//                 i++;
//                 j--;
//             } else
//                 return false;
//         }
//         return true;
//     }

//     public static void main(String args[]) {
//         Solution s = new Solution();
//         System.out.println(s.isPalindrome(".,"));
//     }
// }

/*
SOLUTION 2
*/
// class Solution {
//     public boolean isPalindrome(String s) {
//         if (s.length() == 0 || s.length() == 1)
//             return true;

//         String regex = "[^a-zA-Z0-9]+";

//         //change into new string by removing all alphanumeric chars
//         String s1 = s.replaceAll(regex, "");

//         if (s.length() == 0 || s.length() == 1)
//             return true;

//         int i = 0, j = s1.length() - 1;

//         // while right pointer and left pointer do not inter-cross
//         while (i < j) {

//             // check if the cuurent 2 aplanumeric chars match each other, else return false
//             if (s1.substring(i, i + 1).toLowerCase().equals(s1.substring(j, j + 1).toLowerCase())) {
//                 i++;
//                 j--;
//             } else
//                 return false;
//         }
//         return true;
//     }

//     public static void main(String args[]) {
//         Solution s = new Solution();
//         System.out.println(s.isPalindrome(".,"));
//     }
// }

/*
SOLUTION 3
*/
// class Solution {
//     public boolean isPalindrome(String s) {
//         if (s.length() == 0 || s.length() == 1)
//             return true;

//         String regex = "[^a-zA-Z0-9]+";

//         //convert into char array
//         char[] s1 = s.replaceAll(regex, "").toLowerCase().toCharArray();

//         int i = 0, j = s1.length-1;

//         // while right pointer and left pointer do not inter-cross
//         while (i < j) {

//             // check if the cuurent 2 aplanumeric chars match each other, else return false
//             if (s1[i] == s1[j]) {
//                 i++;
//                 j--;
//             } else
//                 return false;
//         }
//         return true;
//     }

//     public static void main(String args[]) {
//         Solution s = new Solution();
//         System.out.println(s.isPalindrome(".,"));
//     }
// }

/*
SOLUTION 4
*/
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;

        //convert into char array
        char[] s1 = s.toLowerCase().toCharArray();

        int i = 0, j = s1.length-1;

        // while right pointer and left pointer do not inter-cross
        while (i < j) {

            //check if left pointer is alphanumeric, otherwise go ahead
            while (i < s1.length && !Character.isLetterOrDigit(s1[i]))
                i++;
            //check if right pointer is alphanumeric, otherwise go behind
            while (j > 0 && !Character.isLetterOrDigit(s1[j]))
                j--;

            // if both overlaps means only non-alphanumeric present or outer string are aplhanumeric & matching
            if (i > j) {
                return true;
            }

            // check if the cuurent 2 aplanumeric chars match each other, else return false
            if (s1[i] == s1[j]) {
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