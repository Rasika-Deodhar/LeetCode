import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 0)
            return null;
        if (intervals.length == 1)
            return new int[] { -1 };

        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i != j) {
                    if (intervals[j][0] >= intervals[i][1]) {
                        if (result[i] == -1 || intervals[result[i]][0] > intervals[j][0]) {
                            result[i] = j;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.findRightInterval(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } });
        for (int i : result) {
            System.out.println(i);
        }
    }
}