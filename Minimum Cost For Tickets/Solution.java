class Solution {
    //Solution from Nideesh Terapalli Youtube video
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        boolean[] travelDays = new boolean[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < days.length; i++) {
            travelDays[days[i]] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            if (travelDays[i] == false) {
                dp[i] = dp[i - 1];
                continue;
            }
            int one = dp[i - 1] + costs[0];
            int seven = dp[Math.max(i - 7, 0)] + costs[1];
            int thirty = dp[Math.max(i - 30, 0)] + costs[2];

            if (Math.min(one, seven) == Math.min(one, thirty)) {
                dp[i] = one;
            } else if (Math.min(seven, one) == Math.min(seven, thirty)) {
                dp[i] = seven;
            } else if (Math.min(thirty, one) == Math.min(thirty, seven)) {
                dp[i] = thirty;
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out
                .println(s.mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));
    }
}