class Solution {
    public int[] plusOne(int[] digits) {
        
    //     int flag=0;
        
    //     for(int i=digits.length-1; i>=0; i--){
    //         if(digits[i]==9 && i>0 && flag==0){
    //             digits[i]=0;
    //             flag=1;
    //         }
    //         else if(digits[i]==9 && i>0 && flag==1){
    //             digits[i]=0;
    //             flag=1;
    //         }
    //         else if(digits[i]!=9 && i>0 && flag==1){
    //             digits[i] += 1;
    //             return digits;
    //         }
    //         else if(digits[i]==9 && i==0){
    //             int[] a = new int[digits.length+1];
    //             a[0] = 1;
    //             return a;
    //         }
    //         else{
    //             digits[i] +=1;
    //             return digits;
    //         }
    //     }
    
    // return digits;


    // Easier solution on Leetcode -> https://leetcode.com/submissions/detail/297966937/
    int n = digits.length;
        for(int i=n-1; i>=0; i--){
            // if digit less than 9 -> add and return (units place adding/ carry) 
            // Eg. 45+1=46 or 49+1 => 1st loop: 9+1=0 (1 carry -> will be handled in 2nd loop -> 4<9 -> 4++) -> 50 will be returned
            if(digits[i] <9){
                digits[i]++;
                return digits;
            }
            digits[i]=0; // If digit is 9 -> 9+1=10 -> replace the digit to 0 and carry will be handled in the above condition
        }
        // If all digits are 0 -> then add 1 on left. Eg. 9 or 99 or 9999 + 1 = 10000 (replace 9s with 0s and add 1 on left)
        int[] ans = new int[n+1];
        ans[0] =1;
        return ans;
    }

    public static void main(String[] args) {
        int[] result = new Solution().plusOne(new int[] {4,9});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}