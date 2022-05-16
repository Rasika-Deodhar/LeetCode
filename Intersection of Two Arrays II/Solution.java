import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
    //         return null;
    //     }

    //     if (nums1.length < nums2.length) {
    //         return intersect(nums2, nums1);
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     HashMap<Integer, Integer> hm1 = new HashMap<>();
    //     HashMap<Integer, Integer> hm2 = new HashMap<>();

    //     for (int integer : nums1) {
    //         if (hm1.containsKey(integer)) {
    //             hm1.put(integer, hm1.get(integer) + 1);
    //         } else {
    //             hm1.put(integer, 1);
    //         }
    //     }
    //     for (int integer : nums2) {
    //         if (hm2.containsKey(integer)) {
    //             hm2.put(integer, hm2.get(integer) + 1);
    //         } else {
    //             hm2.put(integer, 1);
    //         }
    //     }

    //     int i = 0, min_value = 0;
    //     for (Entry<Integer, Integer> entry : hm1.entrySet()) {
    //         if (hm2.containsKey(entry.getKey())) {
    //             i = 0;
    //             min_value = Math.min(entry.getValue(), hm2.get(entry.getKey()));
    //             while (i < min_value) {
    //                 result.add(entry.getKey());
    //                 i++;
    //             }
    //         }
    //     }

    //     return result.stream().mapToInt(r -> r).toArray();
    // }

    //Solution 2 by - https://www.youtube.com/watch?v=B9L2hjjQCN0
    public int[] intersect(int[] nums1, int[] nums2) {

        int i=0,j=0,k=0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                nums1[k++] = nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });
        for (int i : res) {
            System.out.println(i);
        }
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}