class Solution {
    public String longestCommonPrefix(String[] strs) {
        
       if(strs.length==0) return "";
        
       String prefix = strs[0]; // prefix as 1st string or word
        
        for(int i=0; i<strs.length; i++){
            while(strs[i].indexOf(prefix)!=0){ // if prefix not found in the word
                prefix = prefix.substring(0,prefix.length()-1); // reduce prefix by 1 character
            }
        }
        
        return prefix;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        String[] a = {"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(a));
    }
}