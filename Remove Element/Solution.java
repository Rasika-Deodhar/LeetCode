import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int removeElement(int[] nums, final int val) {

        final List<ArrayList> list = new ArrayList<>();

        if (nums.length == 0)
            return 0;

        final int len = nums.length;
        int val_count = 0;

        for (int i = 0; i < len; i++) {
            if (val == nums[i]) {
                val_count++;
                int j=i;
                while(j<len-1){
                nums[j] = nums[j+1];
                j++;
                }

                // nums = new_array(nums, i);
            }
        }
        nums = Arrays.copyOf(nums, nums.length-val_count);

        return (len - val_count);
    }

    // public int[] new_array(int[] nums, final int i) {
    //     final List<Integer> arrayList = IntStream.of(nums)
    //                                   .boxed() 
    //                                   .collect(Collectors.toList());
    //     arrayList.remove(i);
    //     Integer[] nums1 = arrayList.toArray(new Integer[0]);
    //     int[] n = arrayList.stream().mapToInt();
    //     return nums1.ge;

    //     // return arrayList.removeIf(l->l==val);
        
    // }

    public static void main(final String args[]) {
        final Solution s = new Solution();
        System.out.println(s.removeElement(new int[] {2,3,4,5,3,5,6,3}, 3));
    }
}