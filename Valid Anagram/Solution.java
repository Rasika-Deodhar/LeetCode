import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) return false;
        
        char tempArray[] = s.toCharArray();
        Arrays.sort(tempArray);
        String s1 = new String(tempArray);
        
        char tempArray1[] = t.toCharArray();
        Arrays.sort(tempArray1);
        String t1 = new String(tempArray1);
        
        return s1.equals(t1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
    }
}