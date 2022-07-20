class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length,k=0;
        if(nums.length == 1) {
            return nums[0]==target ? 0 : -1;
        }
        while(i<j) {
            if(k!=(i+j)/2) { k = (i+j)/2;} else {return -1;}

            if(nums[k] == target) { return k;}
            else if(nums[k] > target) { j=k;}
            else if(nums[k] < target){ i=k+1; }
        }
        
        
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[] {-1,0,3,5,9,12}, 2));
    }
}