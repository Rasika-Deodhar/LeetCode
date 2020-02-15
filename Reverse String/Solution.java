class Solution {
    public void reverseString(char[] s) {
        char temp;
        for(int i=0, j=s.length-1; i<j; i++,j--){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        for(int i=0; i<s.length; i++){
            System.out.print(s[i]);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char [] a = {'h','e','l'};
        s.reverseString(a);
    }
}