class Solution {
    public static int heightChecker(int[] heights) {

        int[] sorted_array = sort_heights(heights.clone());
        int count = 0;

        for (int i = 0; i < sorted_array.length; i++) {
            if (sorted_array[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }

    private static int[] sort_heights(int[] heights) {
        for (int i = heights.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (heights[i] < heights[j]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                }
            }

        }
        return heights;
    }

    public static void main(String[] args) {
        System.out.println(Solution.heightChecker(new int[] { 5, 1, 2, 3, 4 }));
    }

    // Time Complexity -
    // Best Case -> Array already sorted -> O(N)
    // Avg Case -> Array partially sored -> O(N)
    // Worst Case -> Array descending ordered -> O(N)

    // Space Complexity = O(N) -> extra array used
}