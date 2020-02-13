class Solution {
    public int pivotIndex(final int[] nums) {
        int sum_left=0, sum_right=0,j,k;
        
        if(nums.length==0)
            return -1;
        
        j=-2; k=0;
        for(int i=0; i<nums.length; i++){
            
            j++; k++;
             
            if(i>0 && j<i){
                sum_left += nums[j];
            }
            
            while(i==0 && k<nums.length){
                sum_right += nums[k];
                k++;
            }

            if(k==nums.length && i==0){
                k=1;
            }

            if(k==nums.length && i>0){
                sum_right=0;
            }
            
            if(i>0 && k<nums.length){
                sum_right -= nums[k-1];
            }
            
            if(sum_left==sum_right){
                return i;
            }
        }
        return -1;
    }

    public static void main(final String[] args){

        final Solution s = new Solution();
        final int[] nums = {-1,-1,0,1,1,0};
        final int a = s.pivotIndex(nums);
        System.out.println(a);
    }
}