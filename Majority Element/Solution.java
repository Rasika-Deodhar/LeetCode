import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {

        if(nums.length==1){return nums[0];}

        int zero=0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] - nums[i] !=0){
                zero=0;
            } else {
                zero++;
                if(zero >= (nums.length/2)) { 
                    return nums[i]; 
                }
            }
        }
        
        return 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[] {3,2,3}));
    }

    //Time Complexity = O(N)
    //SPace Complexity = O(1)
}