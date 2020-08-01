class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==0)
            return false;
        if(word.length()==1)
            return true;
        char[] w = word.toCharArray();
        if(Character.isUpperCase(w[0])){
            if(Character.isUpperCase(w[1])){
             //rest all should be capital
                int i=2;
                while(i<w.length){
                    if(Character.isLowerCase(w[i]))
                        return false;
                    i++;
                }
            }
            else{
              //rest all should be small
                int i=2;
                while(i<w.length){
                    if(Character.isUpperCase(w[i]))
                        return false;
                    i++;
                }
            }
        } 
        else{
                //rest all should be small
                int i=1;
                while(i<w.length){
                    if(Character.isUpperCase(w[i]))
                        return false;
                    i++;
                }
            }
        return true;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.detectCapitalUse("Abcd"));
    }
}