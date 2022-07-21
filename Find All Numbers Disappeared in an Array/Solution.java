import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        int[] counter = new int[nums.length]; // counter array to count 1-n indexes

        // index is counted as n-1 -> add 1 to the indices which are contained in nums array
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i] - 1]++;
        }

        // those who are not in the array will remain 0, and can be returned in result set
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                result.add(i + 1);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        List<Integer> result = Solution.findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });

        for (Integer integer : result) {
            System.out.println(integer);
        }

        // Time Complexity - O(N)
        // All cases seem equal.

        // Space Complexity - O(N) -> extra array added and traversed once

    }
}