class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1 || num == 4)
            return true;
        if(num < 16)
            return false;
        while(num > 2 && (num%100)%4==0) {
            num /= 4;
        }
        if(num==1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfFour(44442));
    }
}