import java.util.HashSet;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i : nums) {
            if (hs.contains(i)) {
                return true;
            }
            hs.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Solution.containsDuplicate(new int[] { 1, 2, 3, 4 }));
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
}