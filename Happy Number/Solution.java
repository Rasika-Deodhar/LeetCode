class Solution {
    public boolean isHappy(int n) {

        if (n == 0 || n >= 2 && n <= 6 || n == 8 || n == 9) {
            return false;
        }
        if (isPower(10, n) || n == 1 || n == 7) {
            return true;
        }

        return isHappy(squaredSum_n(n));
    }

    private int squaredSum_n(int n) {
        int sum = 0;

        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }

    private boolean isPower(int x, int y) {

        if (x == 1)
            return (y == 1);

        long pow = 1;
        while (pow < y) {
            pow *= x;
        }
        return (pow == y);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(1999999999));
    }

    // Time Complexity = O(1)
    // Space Complexity = O(1)
}