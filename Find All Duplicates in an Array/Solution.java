import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums.length != 0 && nums.length != 1) {
            int i = 0, j;
            while (i < nums.length) {
                j = Math.abs(nums[i]) - 1;
                if (nums[j] < 0)
                    list.add(j+1);
                nums[j] = -nums[j];
                i++;
            }
        }

        return list;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums = { 4,3,2,7,8,2,3,1 };

        List<Integer> list = s.findDuplicates(nums);
        System.out.println(list);
    }
}