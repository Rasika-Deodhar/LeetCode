import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0, j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j] && !hashSet.contains(nums1[i])) {
                hashSet.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] == nums2[j] && hashSet.contains(nums1[i])) {
                i++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
        }

        i = 0;
        int[] a = new int[hashSet.size()];
        for (Integer val : hashSet)
            a[i++] = val;

        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = s.intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 });

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    // Time Complexity = O(N) -> N (max array length)
    // Space Complexity = O(N)
}