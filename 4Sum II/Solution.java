import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Solution refered from discussion forum -
        // https://leetcode.com/problems/4sum-ii/discuss/1740490/Java-or-3-liner-or-Simple-or-Explained
        var pairCountBySum = new HashMap<Integer, Integer>();
        for (var num1 : nums1)
            for (var num2 : nums2)
                pairCountBySum.compute(num1 + num2, (k, sumCount) -> sumCount == null ? 1 : ++sumCount);

        var fourSumCount = 0;
        for (var num3 : nums3)
            for (var num4 : nums4)
                fourSumCount += pairCountBySum.getOrDefault(-(num3 + num4), 0);

        return fourSumCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
                s.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 }));
    }
}