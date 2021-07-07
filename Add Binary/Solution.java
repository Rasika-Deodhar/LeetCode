class Solution {

    public static String addition(String a, String b) {

        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }

        Double da = 0D, db = 0D, dr = 0D;
        String res = "";

        for (int i = a.length() - 1, j = 0; i >= 0; i--, j++) {
            da += Math.pow(2, j) * Double.valueOf(a.substring(i, i + 1));
        }
        for (int i = b.length() - 1, j = 0; i >= 0; i--, j++) {
            db += Math.pow(2, j) * Double.valueOf(b.substring(i, i + 1));
        }

        dr = da + db;

        if (dr == 0) {
            return "0";
        }

        for (; dr > 0D; dr /= 2D) {
            res += String.valueOf((int) (dr % 2D));
        }

        StringBuilder final_res = new StringBuilder(res).reverse();
        if (res.substring(0, 1) == "0") {
            int i = 0;
            for (i = 0; i < res.length() && res.substring(i, i + 1).equals("0"); i++) {
            }

            // final_res = res(i,)
        }

        return new StringBuilder(res).reverse().toString();
    }

    public static void main(String args[]) {
        System.out.println(Solution.addition(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}