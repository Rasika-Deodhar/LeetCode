class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum=0, sum=nums[0]; // max sum is first value initially

        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i]; // add the current index value
            if(curr_sum > sum){sum = curr_sum;} // if current sum is > max sum, then store the value
            if(curr_sum < 0){ curr_sum=0;} // if current sum is negative then reset the current index and start with new sum from next loop/ next value
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2,-1}));
    }

    // Solution Ref - https://www.youtube.com/watch?v=5WZl3MMT0Eg, https://www.youtube.com/watch?v=jnoVtCKECmQ
    // Time Complexity = O(N)
    // Space COmplexity = O(1)
}