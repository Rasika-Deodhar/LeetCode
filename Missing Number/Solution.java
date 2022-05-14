class Solution {
    public int missingNumber(int[] nums) {

        int length = nums.length;
        int length_sum = (length * (length+1))/2;
        int nums_sum =0;

        for (int i : nums) {
            nums_sum += i;
        }
        
        return length_sum-nums_sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[] {0,1})); 
    }
}